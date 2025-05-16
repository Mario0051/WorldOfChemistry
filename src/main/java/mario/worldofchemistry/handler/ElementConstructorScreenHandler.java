package mario.worldofchemistry.handler;

import mario.worldofchemistry.data.AtomicData;
import mario.worldofchemistry.init.BlockInit;
import mario.worldofchemistry.init.ScreenHandlerInit;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;


public class ElementConstructorScreenHandler extends ScreenHandler {

    public static final int PROTONS_PROPERTY_INDEX = 0;
    public static final int NEUTRONS_PROPERTY_INDEX = 1;
    public static final int ELECTRONS_PROPERTY_INDEX = 2;
    public static final int PROPERTY_COUNT = 3;

    private static final int PROTON_SLIDER_BUTTON_ID_OFFSET = 100;
    private static final int PROTON_MAX_VALUE = 120;

    private static final int ELECTRON_SLIDER_BUTTON_ID_OFFSET = 300;
    private static final int ELECTRON_MAX_VALUE = 120;

    private static final int NEUTRON_SLIDER_BUTTON_ID_OFFSET = 500;
    private static final int NEUTRON_MAX_VALUE = 180;

    public static final int OUTPUT_SLOT_INDEX = 0;
    private static final int PLAYER_INVENTORY_START_INDEX = 1;
    private static final int PLAYER_HOTBAR_START_INDEX = PLAYER_INVENTORY_START_INDEX + 27;
    private static final int PLAYER_TOTAL_SLOTS_END_INDEX = PLAYER_HOTBAR_START_INDEX + 9;

    private final Inventory outputInventory;
    private final PropertyDelegate propertyDelegate;
    private final ScreenHandlerContext context;
    private final PlayerEntity player;

    public ElementConstructorScreenHandler(int syncId, PlayerInventory playerInventory, ElementConstructorScreenOpeningData data) {
        this(syncId, playerInventory, data, new ArrayPropertyDelegate(PROPERTY_COUNT), new SimpleInventory(1));
    }

    private ElementConstructorScreenHandler(int syncId, PlayerInventory playerInventory,
                                            ElementConstructorScreenOpeningData data,
                                            PropertyDelegate propertyDelegate, Inventory outputInventory) {
        super(ScreenHandlerInit.ELEMENT_CONSTRUCTOR_SCREEN_HANDLER_TYPE, syncId);
        this.player = playerInventory.player;
        this.context = ScreenHandlerContext.create(playerInventory.player.getWorld(), data.blockEntityPos());

        checkDataCount(propertyDelegate, PROPERTY_COUNT);
        this.propertyDelegate = propertyDelegate;
        this.addProperties(this.propertyDelegate);

        this.outputInventory = outputInventory;
        checkSize(outputInventory, 1);

        int outputSlotX_onScreen = 212;
        int outputSlotY_onScreen = 90;
        this.addSlot(new OutputSlot(this.outputInventory, OUTPUT_SLOT_INDEX, outputSlotX_onScreen, outputSlotY_onScreen, this));
        addPlayerInventorySlots(playerInventory);
    }

    private void addPlayerInventorySlots(PlayerInventory playerInventory) {
        int playerInvX = 84;
        int playerInvY = 133 + 8;
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(playerInventory, j + i * 9 + 9, playerInvX + j * 18, playerInvY + i * 18));
            }
        }
        int hotbarY = playerInvY + (3 * 18) + 3;
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, playerInvX + i * 18, hotbarY));
        }
    }

    private boolean isElementItem(ItemStack stack) {
        return getAtomicNumberFromItemStack(stack) > 0;
    }

    public void updatePneValuesFromSlotItem(ItemStack stackInSlot) {
        if (this.player == null || this.player.getWorld().isClient()) return;

        int p = 0, n = 0, e = 0;
        int atomicNumber = getAtomicNumberFromItemStack(stackInSlot);

        if (atomicNumber > 0) {
            p = atomicNumber;
            e = atomicNumber;
            n = AtomicData.MOST_COMMON_ISOTOPE_NEUTRONS.getOrDefault(atomicNumber, 0);
        }

        this.propertyDelegate.set(PROTONS_PROPERTY_INDEX, p);
        this.propertyDelegate.set(NEUTRONS_PROPERTY_INDEX, n);
        this.propertyDelegate.set(ELECTRONS_PROPERTY_INDEX, e);

        updateElementOutput();
    }

    public int getProtons() { return this.propertyDelegate.get(PROTONS_PROPERTY_INDEX); }
    public int getNeutrons() { return this.propertyDelegate.get(NEUTRONS_PROPERTY_INDEX); }
    public int getElectrons() { return this.propertyDelegate.get(ELECTRONS_PROPERTY_INDEX); }

    @Override
    public boolean onButtonClick(PlayerEntity player, int id) {
        boolean stateChanged = false;

        if (id >= PROTON_SLIDER_BUTTON_ID_OFFSET && id <= PROTON_SLIDER_BUTTON_ID_OFFSET + PROTON_MAX_VALUE) {
            int value = MathHelper.clamp(id - PROTON_SLIDER_BUTTON_ID_OFFSET, 0, PROTON_MAX_VALUE);
            if (getProtons() != value) {
                this.propertyDelegate.set(PROTONS_PROPERTY_INDEX, value);
                stateChanged = true;
            }
        } else if (id >= ELECTRON_SLIDER_BUTTON_ID_OFFSET && id <= ELECTRON_SLIDER_BUTTON_ID_OFFSET + ELECTRON_MAX_VALUE) {
            int value = MathHelper.clamp(id - ELECTRON_SLIDER_BUTTON_ID_OFFSET, 0, ELECTRON_MAX_VALUE);
            if (getElectrons() != value) {
                this.propertyDelegate.set(ELECTRONS_PROPERTY_INDEX, value);
                stateChanged = true;
            }
        } else if (id >= NEUTRON_SLIDER_BUTTON_ID_OFFSET && id <= NEUTRON_SLIDER_BUTTON_ID_OFFSET + NEUTRON_MAX_VALUE) {
            int value = MathHelper.clamp(id - NEUTRON_SLIDER_BUTTON_ID_OFFSET, 0, NEUTRON_MAX_VALUE);
            if (getNeutrons() != value) {
                this.propertyDelegate.set(NEUTRONS_PROPERTY_INDEX, value);
                stateChanged = true;
            }
        } else {
            int currentProtons = getProtons();
            int currentNeutrons = getNeutrons();
            int currentElectrons = getElectrons();
            switch (id) {
                case 0: if (currentProtons < PROTON_MAX_VALUE) { this.propertyDelegate.set(PROTONS_PROPERTY_INDEX, currentProtons + 1); stateChanged = true; } break;
                case 1: if (currentProtons > 0) { this.propertyDelegate.set(PROTONS_PROPERTY_INDEX, currentProtons - 1); stateChanged = true; } break;
                case 2: if (currentNeutrons < NEUTRON_MAX_VALUE) { this.propertyDelegate.set(NEUTRONS_PROPERTY_INDEX, currentNeutrons + 1); stateChanged = true; } break;
                case 3: if (currentNeutrons > 0) { this.propertyDelegate.set(NEUTRONS_PROPERTY_INDEX, currentNeutrons - 1); stateChanged = true; } break;
                case 4: if (currentElectrons < ELECTRON_MAX_VALUE) { this.propertyDelegate.set(ELECTRONS_PROPERTY_INDEX, currentElectrons + 1); stateChanged = true; } break;
                case 5: if (currentElectrons > 0) { this.propertyDelegate.set(ELECTRONS_PROPERTY_INDEX, currentElectrons - 1); stateChanged = true; } break;
                default: return false;
            }
        }

        if (stateChanged) {
            updateElementOutput();
        }
        return stateChanged;
    }

    private void updateElementOutput() {
        ItemStack currentOutput = ItemStack.EMPTY;
        int p = getProtons();
        int n = getNeutrons();
        int e = getElectrons();

        if (p > 0 && p <= 118) {
            int[] neutronRange = AtomicData.VALID_ISOTOPE_NEUTRON_RANGES.get(p);

            boolean isValidIsotope = false;
            if (neutronRange != null) {
                int minNeutrons = neutronRange[0];
                int maxNeutrons = neutronRange[1];
                if (n >= minNeutrons && n <= maxNeutrons) {
                    isValidIsotope = true;
                }
            }

            if (isValidIsotope && e == p) {
                currentOutput = getElementItemStack(p);
                if (currentOutput == null) {
                    currentOutput = ItemStack.EMPTY;
                }
            }
        }

        this.outputInventory.setStack(OUTPUT_SLOT_INDEX, currentOutput.copy());
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int slotIndex) {
        ItemStack newStackDefaultReturn = ItemStack.EMPTY;
        Slot slot = this.slots.get(slotIndex);

        if (slot != null && slot.hasStack()) {
            ItemStack originalStackInSlot = slot.getStack();
            newStackDefaultReturn = originalStackInSlot.copy();

            if (slotIndex == OUTPUT_SLOT_INDEX) {
                ItemStack creativeCopy = originalStackInSlot.copy();
                creativeCopy.setCount(creativeCopy.getMaxCount());
                if (!this.insertItem(creativeCopy, PLAYER_INVENTORY_START_INDEX, PLAYER_TOTAL_SLOTS_END_INDEX, true)) {
                    return ItemStack.EMPTY;
                }
                return ItemStack.EMPTY;
            }
            else if (slotIndex >= PLAYER_INVENTORY_START_INDEX && slotIndex < PLAYER_TOTAL_SLOTS_END_INDEX) {
                if (isElementItem(originalStackInSlot)) {
                    ItemStack itemToPlaceInOutput = originalStackInSlot.copy();
                    itemToPlaceInOutput.setCount(1);

                    Slot outputSlot = this.slots.get(OUTPUT_SLOT_INDEX);
                    ItemStack itemPreviouslyInOutput = outputSlot.getStack().copy();

                    outputSlot.setStack(itemToPlaceInOutput);
                    updatePneValuesFromSlotItem(itemToPlaceInOutput);

                    return ItemStack.EMPTY;
                }
                else if (slotIndex < PLAYER_HOTBAR_START_INDEX) {
                    if (!this.insertItem(originalStackInSlot, PLAYER_HOTBAR_START_INDEX, PLAYER_TOTAL_SLOTS_END_INDEX, false)) {
                        return ItemStack.EMPTY;
                    }
                } else {
                    if (!this.insertItem(originalStackInSlot, PLAYER_INVENTORY_START_INDEX, PLAYER_HOTBAR_START_INDEX, false)) {
                        return ItemStack.EMPTY;
                    }
                }
            }

            if (originalStackInSlot.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }

            if (originalStackInSlot.getCount() == newStackDefaultReturn.getCount()) {
                return ItemStack.EMPTY;
            }

            ItemStack transferredStack = newStackDefaultReturn.copy();
            transferredStack.setCount(newStackDefaultReturn.getCount() - originalStackInSlot.getCount());
            slot.onTakeItem(player, transferredStack);
        }
        return newStackDefaultReturn;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return ScreenHandler.canUse(this.context, player, getCachedState().getBlock());
    }

    private BlockState getCachedState() {
        return this.context.get(World::getBlockState).orElse(Blocks.AIR.getDefaultState());
    }

    @Override
    public void onClosed(PlayerEntity player) {
        super.onClosed(player);
    }

    @Override
    public void onSlotClick(int slotIndex, int button, SlotActionType actionType, PlayerEntity player) {
        Slot outputSlot = this.slots.get(OUTPUT_SLOT_INDEX);
        ItemStack cursorStack = this.getCursorStack();
        ItemStack itemCurrentlyInOutputSlot = outputSlot.getStack();

        if (slotIndex == OUTPUT_SLOT_INDEX) {
            if (actionType == SlotActionType.CLONE && player.getAbilities().creativeMode) {
                if (outputSlot.hasStack()) {
                    super.onSlotClick(slotIndex, button, actionType, player);
                }
                return;
            }

            if (actionType == SlotActionType.PICKUP) {
                if (outputSlot.hasStack()) {
                    if (cursorStack.isEmpty() || ItemStack.areItemsAndComponentsEqual(cursorStack, itemCurrentlyInOutputSlot)) {
                        ItemStack stackToPutOnCursor;
                        if (button == 0) {
                            if (cursorStack.isEmpty()) {
                                stackToPutOnCursor = itemCurrentlyInOutputSlot.copy();
                            } else {
                                stackToPutOnCursor = cursorStack.copy();
                                if (stackToPutOnCursor.getCount() < stackToPutOnCursor.getMaxCount()) {
                                    stackToPutOnCursor.increment(1);
                                }
                            }
                            stackToPutOnCursor.setCount(stackToPutOnCursor.getMaxCount());
                            this.setCursorStack(stackToPutOnCursor);
                            this.sendContentUpdates();
                            return;
                        } else if (button == 1) {
                            if (cursorStack.isEmpty()) {
                                stackToPutOnCursor = itemCurrentlyInOutputSlot.copy();
                            } else {
                                stackToPutOnCursor = cursorStack.copy();
                                if (stackToPutOnCursor.getCount() < stackToPutOnCursor.getMaxCount()) {
                                    stackToPutOnCursor.increment(1);
                                }
                            }
                            this.setCursorStack(stackToPutOnCursor);
                            this.sendContentUpdates();
                            return;
                        }
                    }
                    else if (isElementItem(cursorStack)) {
                        ItemStack itemToPlaceInSlot = cursorStack.copy();
                        itemToPlaceInSlot.setCount(1);

                        ItemStack previouslyInSlot = itemCurrentlyInOutputSlot.copy();

                        outputSlot.setStack(itemToPlaceInSlot);
                        updatePneValuesFromSlotItem(itemToPlaceInSlot);

                        if (!previouslyInSlot.isEmpty() && !ItemStack.areItemsAndComponentsEqual(previouslyInSlot, itemToPlaceInSlot)) {
                            player.getInventory().offerOrDrop(previouslyInSlot);
                        }
                        this.sendContentUpdates();
                        return;
                    }
                    else if (!cursorStack.isEmpty() && !isElementItem(cursorStack) && button == 0) {
                        ItemStack stackToPutOnCursor = itemCurrentlyInOutputSlot.copy();
                        stackToPutOnCursor.setCount(stackToPutOnCursor.getMaxCount());
                        this.setCursorStack(stackToPutOnCursor);
                        this.sendContentUpdates();
                        return;
                    }
                } else {
                    if (!cursorStack.isEmpty() && isElementItem(cursorStack)) {
                        ItemStack itemToPlaceInSlot = cursorStack.copy();
                        itemToPlaceInSlot.setCount(1);

                        outputSlot.setStack(itemToPlaceInSlot);
                        updatePneValuesFromSlotItem(itemToPlaceInSlot);
                        this.sendContentUpdates();
                        return;
                    }
                    else if (cursorStack.isEmpty()) {
                        this.setCursorStack(ItemStack.EMPTY);
                        return;
                    }
                }
            }
        }

        super.onSlotClick(slotIndex, button, actionType, player);
    }

    private static class OutputSlot extends Slot {
        private final ElementConstructorScreenHandler handler;

        public OutputSlot(Inventory inventory, int index, int x, int y, ElementConstructorScreenHandler handler) {
            super(inventory, index, x, y);
            this.handler = handler;
        }

        @Override
        public boolean canInsert(ItemStack stack) {
            return handler.isElementItem(stack);
        }

        @Override
        public int getMaxItemCount() { return 1; }

        @Override
        public int getMaxItemCount(ItemStack stack) { return 1; }

    }

    private ItemStack getElementItemStack(int atomicNumber) {
        return switch (atomicNumber) {
            case 1 -> new ItemStack(BlockInit.ELEMENT_1.asItem());
            case 2 -> new ItemStack(BlockInit.ELEMENT_2.asItem());
            case 3 -> new ItemStack(BlockInit.ELEMENT_3.asItem());
            case 4 -> new ItemStack(BlockInit.ELEMENT_4.asItem());
            case 5 -> new ItemStack(BlockInit.ELEMENT_5.asItem());
            case 6 -> new ItemStack(BlockInit.ELEMENT_6.asItem());
            case 7 -> new ItemStack(BlockInit.ELEMENT_7.asItem());
            case 8 -> new ItemStack(BlockInit.ELEMENT_8.asItem());
            case 9 -> new ItemStack(BlockInit.ELEMENT_9.asItem());
            case 10 -> new ItemStack(BlockInit.ELEMENT_10.asItem());
            case 11 -> new ItemStack(BlockInit.ELEMENT_11.asItem());
            case 12 -> new ItemStack(BlockInit.ELEMENT_12.asItem());
            case 13 -> new ItemStack(BlockInit.ELEMENT_13.asItem());
            case 14 -> new ItemStack(BlockInit.ELEMENT_14.asItem());
            case 15 -> new ItemStack(BlockInit.ELEMENT_15.asItem());
            case 16 -> new ItemStack(BlockInit.ELEMENT_16.asItem());
            case 17 -> new ItemStack(BlockInit.ELEMENT_17.asItem());
            case 18 -> new ItemStack(BlockInit.ELEMENT_18.asItem());
            case 19 -> new ItemStack(BlockInit.ELEMENT_19.asItem());
            case 20 -> new ItemStack(BlockInit.ELEMENT_20.asItem());
            case 21 -> new ItemStack(BlockInit.ELEMENT_21.asItem());
            case 22 -> new ItemStack(BlockInit.ELEMENT_22.asItem());
            case 23 -> new ItemStack(BlockInit.ELEMENT_23.asItem());
            case 24 -> new ItemStack(BlockInit.ELEMENT_24.asItem());
            case 25 -> new ItemStack(BlockInit.ELEMENT_25.asItem());
            case 26 -> new ItemStack(BlockInit.ELEMENT_26.asItem());
            case 27 -> new ItemStack(BlockInit.ELEMENT_27.asItem());
            case 28 -> new ItemStack(BlockInit.ELEMENT_28.asItem());
            case 29 -> new ItemStack(BlockInit.ELEMENT_29.asItem());
            case 30 -> new ItemStack(BlockInit.ELEMENT_30.asItem());
            case 31 -> new ItemStack(BlockInit.ELEMENT_31.asItem());
            case 32 -> new ItemStack(BlockInit.ELEMENT_32.asItem());
            case 33 -> new ItemStack(BlockInit.ELEMENT_33.asItem());
            case 34 -> new ItemStack(BlockInit.ELEMENT_34.asItem());
            case 35 -> new ItemStack(BlockInit.ELEMENT_35.asItem());
            case 36 -> new ItemStack(BlockInit.ELEMENT_36.asItem());
            case 37 -> new ItemStack(BlockInit.ELEMENT_37.asItem());
            case 38 -> new ItemStack(BlockInit.ELEMENT_38.asItem());
            case 39 -> new ItemStack(BlockInit.ELEMENT_39.asItem());
            case 40 -> new ItemStack(BlockInit.ELEMENT_40.asItem());
            case 41 -> new ItemStack(BlockInit.ELEMENT_41.asItem());
            case 42 -> new ItemStack(BlockInit.ELEMENT_42.asItem());
            case 43 -> new ItemStack(BlockInit.ELEMENT_43.asItem());
            case 44 -> new ItemStack(BlockInit.ELEMENT_44.asItem());
            case 45 -> new ItemStack(BlockInit.ELEMENT_45.asItem());
            case 46 -> new ItemStack(BlockInit.ELEMENT_46.asItem());
            case 47 -> new ItemStack(BlockInit.ELEMENT_47.asItem());
            case 48 -> new ItemStack(BlockInit.ELEMENT_48.asItem());
            case 49 -> new ItemStack(BlockInit.ELEMENT_49.asItem());
            case 50 -> new ItemStack(BlockInit.ELEMENT_50.asItem());
            case 51 -> new ItemStack(BlockInit.ELEMENT_51.asItem());
            case 52 -> new ItemStack(BlockInit.ELEMENT_52.asItem());
            case 53 -> new ItemStack(BlockInit.ELEMENT_53.asItem());
            case 54 -> new ItemStack(BlockInit.ELEMENT_54.asItem());
            case 55 -> new ItemStack(BlockInit.ELEMENT_55.asItem());
            case 56 -> new ItemStack(BlockInit.ELEMENT_56.asItem());
            case 57 -> new ItemStack(BlockInit.ELEMENT_57.asItem());
            case 58 -> new ItemStack(BlockInit.ELEMENT_58.asItem());
            case 59 -> new ItemStack(BlockInit.ELEMENT_59.asItem());
            case 60 -> new ItemStack(BlockInit.ELEMENT_60.asItem());
            case 61 -> new ItemStack(BlockInit.ELEMENT_61.asItem());
            case 62 -> new ItemStack(BlockInit.ELEMENT_62.asItem());
            case 63 -> new ItemStack(BlockInit.ELEMENT_63.asItem());
            case 64 -> new ItemStack(BlockInit.ELEMENT_64.asItem());
            case 65 -> new ItemStack(BlockInit.ELEMENT_65.asItem());
            case 66 -> new ItemStack(BlockInit.ELEMENT_66.asItem());
            case 67 -> new ItemStack(BlockInit.ELEMENT_67.asItem());
            case 68 -> new ItemStack(BlockInit.ELEMENT_68.asItem());
            case 69 -> new ItemStack(BlockInit.ELEMENT_69.asItem());
            case 70 -> new ItemStack(BlockInit.ELEMENT_70.asItem());
            case 71 -> new ItemStack(BlockInit.ELEMENT_71.asItem());
            case 72 -> new ItemStack(BlockInit.ELEMENT_72.asItem());
            case 73 -> new ItemStack(BlockInit.ELEMENT_73.asItem());
            case 74 -> new ItemStack(BlockInit.ELEMENT_74.asItem());
            case 75 -> new ItemStack(BlockInit.ELEMENT_75.asItem());
            case 76 -> new ItemStack(BlockInit.ELEMENT_76.asItem());
            case 77 -> new ItemStack(BlockInit.ELEMENT_77.asItem());
            case 78 -> new ItemStack(BlockInit.ELEMENT_78.asItem());
            case 79 -> new ItemStack(BlockInit.ELEMENT_79.asItem());
            case 80 -> new ItemStack(BlockInit.ELEMENT_80.asItem());
            case 81 -> new ItemStack(BlockInit.ELEMENT_81.asItem());
            case 82 -> new ItemStack(BlockInit.ELEMENT_82.asItem());
            case 83 -> new ItemStack(BlockInit.ELEMENT_83.asItem());
            case 84 -> new ItemStack(BlockInit.ELEMENT_84.asItem());
            case 85 -> new ItemStack(BlockInit.ELEMENT_85.asItem());
            case 86 -> new ItemStack(BlockInit.ELEMENT_86.asItem());
            case 87 -> new ItemStack(BlockInit.ELEMENT_87.asItem());
            case 88 -> new ItemStack(BlockInit.ELEMENT_88.asItem());
            case 89 -> new ItemStack(BlockInit.ELEMENT_89.asItem());
            case 90 -> new ItemStack(BlockInit.ELEMENT_90.asItem());
            case 91 -> new ItemStack(BlockInit.ELEMENT_91.asItem());
            case 92 -> new ItemStack(BlockInit.ELEMENT_92.asItem());
            case 93 -> new ItemStack(BlockInit.ELEMENT_93.asItem());
            case 94 -> new ItemStack(BlockInit.ELEMENT_94.asItem());
            case 95 -> new ItemStack(BlockInit.ELEMENT_95.asItem());
            case 96 -> new ItemStack(BlockInit.ELEMENT_96.asItem());
            case 97 -> new ItemStack(BlockInit.ELEMENT_97.asItem());
            case 98 -> new ItemStack(BlockInit.ELEMENT_98.asItem());
            case 99 -> new ItemStack(BlockInit.ELEMENT_99.asItem());
            case 100 -> new ItemStack(BlockInit.ELEMENT_100.asItem());
            case 101 -> new ItemStack(BlockInit.ELEMENT_101.asItem());
            case 102 -> new ItemStack(BlockInit.ELEMENT_102.asItem());
            case 103 -> new ItemStack(BlockInit.ELEMENT_103.asItem());
            case 104 -> new ItemStack(BlockInit.ELEMENT_104.asItem());
            case 105 -> new ItemStack(BlockInit.ELEMENT_105.asItem());
            case 106 -> new ItemStack(BlockInit.ELEMENT_106.asItem());
            case 107 -> new ItemStack(BlockInit.ELEMENT_107.asItem());
            case 108 -> new ItemStack(BlockInit.ELEMENT_108.asItem());
            case 109 -> new ItemStack(BlockInit.ELEMENT_109.asItem());
            case 110 -> new ItemStack(BlockInit.ELEMENT_110.asItem());
            case 111 -> new ItemStack(BlockInit.ELEMENT_111.asItem());
            case 112 -> new ItemStack(BlockInit.ELEMENT_112.asItem());
            case 113 -> new ItemStack(BlockInit.ELEMENT_113.asItem());
            case 114 -> new ItemStack(BlockInit.ELEMENT_114.asItem());
            case 115 -> new ItemStack(BlockInit.ELEMENT_115.asItem());
            case 116 -> new ItemStack(BlockInit.ELEMENT_116.asItem());
            case 117 -> new ItemStack(BlockInit.ELEMENT_117.asItem());
            case 118 -> new ItemStack(BlockInit.ELEMENT_118.asItem());
            default -> {
                System.err.println("[WorldOfChemistry] getElementItemStack: No item defined for atomic number " + atomicNumber);
                yield ItemStack.EMPTY;
            }
        };
    }

    private int getAtomicNumberFromItemStack(ItemStack stack) {
        if (stack == null || stack.isEmpty()) {
            return 0;
        }
        Item item = stack.getItem();
        if (item == BlockInit.ELEMENT_1.asItem()) return 1;
        if (item == BlockInit.ELEMENT_2.asItem()) return 2;
        if (item == BlockInit.ELEMENT_3.asItem()) return 3;
        if (item == BlockInit.ELEMENT_4.asItem()) return 4;
        if (item == BlockInit.ELEMENT_5.asItem()) return 5;
        if (item == BlockInit.ELEMENT_6.asItem()) return 6;
        if (item == BlockInit.ELEMENT_7.asItem()) return 7;
        if (item == BlockInit.ELEMENT_8.asItem()) return 8;
        if (item == BlockInit.ELEMENT_9.asItem()) return 9;
        if (item == BlockInit.ELEMENT_10.asItem()) return 10;
        if (item == BlockInit.ELEMENT_11.asItem()) return 11;
        if (item == BlockInit.ELEMENT_12.asItem()) return 12;
        if (item == BlockInit.ELEMENT_13.asItem()) return 13;
        if (item == BlockInit.ELEMENT_14.asItem()) return 14;
        if (item == BlockInit.ELEMENT_15.asItem()) return 15;
        if (item == BlockInit.ELEMENT_16.asItem()) return 16;
        if (item == BlockInit.ELEMENT_17.asItem()) return 17;
        if (item == BlockInit.ELEMENT_18.asItem()) return 18;
        if (item == BlockInit.ELEMENT_19.asItem()) return 19;
        if (item == BlockInit.ELEMENT_20.asItem()) return 20;
        if (item == BlockInit.ELEMENT_21.asItem()) return 21;
        if (item == BlockInit.ELEMENT_22.asItem()) return 22;
        if (item == BlockInit.ELEMENT_23.asItem()) return 23;
        if (item == BlockInit.ELEMENT_24.asItem()) return 24;
        if (item == BlockInit.ELEMENT_25.asItem()) return 25;
        if (item == BlockInit.ELEMENT_26.asItem()) return 26;
        if (item == BlockInit.ELEMENT_27.asItem()) return 27;
        if (item == BlockInit.ELEMENT_28.asItem()) return 28;
        if (item == BlockInit.ELEMENT_29.asItem()) return 29;
        if (item == BlockInit.ELEMENT_30.asItem()) return 30;
        if (item == BlockInit.ELEMENT_31.asItem()) return 31;
        if (item == BlockInit.ELEMENT_32.asItem()) return 32;
        if (item == BlockInit.ELEMENT_33.asItem()) return 33;
        if (item == BlockInit.ELEMENT_34.asItem()) return 34;
        if (item == BlockInit.ELEMENT_35.asItem()) return 35;
        if (item == BlockInit.ELEMENT_36.asItem()) return 36;
        if (item == BlockInit.ELEMENT_37.asItem()) return 37;
        if (item == BlockInit.ELEMENT_38.asItem()) return 38;
        if (item == BlockInit.ELEMENT_39.asItem()) return 39;
        if (item == BlockInit.ELEMENT_40.asItem()) return 40;
        if (item == BlockInit.ELEMENT_41.asItem()) return 41;
        if (item == BlockInit.ELEMENT_42.asItem()) return 42;
        if (item == BlockInit.ELEMENT_43.asItem()) return 43;
        if (item == BlockInit.ELEMENT_44.asItem()) return 44;
        if (item == BlockInit.ELEMENT_45.asItem()) return 45;
        if (item == BlockInit.ELEMENT_46.asItem()) return 46;
        if (item == BlockInit.ELEMENT_47.asItem()) return 47;
        if (item == BlockInit.ELEMENT_48.asItem()) return 48;
        if (item == BlockInit.ELEMENT_49.asItem()) return 49;
        if (item == BlockInit.ELEMENT_50.asItem()) return 50;
        if (item == BlockInit.ELEMENT_51.asItem()) return 51;
        if (item == BlockInit.ELEMENT_52.asItem()) return 52;
        if (item == BlockInit.ELEMENT_53.asItem()) return 53;
        if (item == BlockInit.ELEMENT_54.asItem()) return 54;
        if (item == BlockInit.ELEMENT_55.asItem()) return 55;
        if (item == BlockInit.ELEMENT_56.asItem()) return 56;
        if (item == BlockInit.ELEMENT_57.asItem()) return 57;
        if (item == BlockInit.ELEMENT_58.asItem()) return 58;
        if (item == BlockInit.ELEMENT_59.asItem()) return 59;
        if (item == BlockInit.ELEMENT_60.asItem()) return 60;
        if (item == BlockInit.ELEMENT_61.asItem()) return 61;
        if (item == BlockInit.ELEMENT_62.asItem()) return 62;
        if (item == BlockInit.ELEMENT_63.asItem()) return 63;
        if (item == BlockInit.ELEMENT_64.asItem()) return 64;
        if (item == BlockInit.ELEMENT_65.asItem()) return 65;
        if (item == BlockInit.ELEMENT_66.asItem()) return 66;
        if (item == BlockInit.ELEMENT_67.asItem()) return 67;
        if (item == BlockInit.ELEMENT_68.asItem()) return 68;
        if (item == BlockInit.ELEMENT_69.asItem()) return 69;
        if (item == BlockInit.ELEMENT_70.asItem()) return 70;
        if (item == BlockInit.ELEMENT_71.asItem()) return 71;
        if (item == BlockInit.ELEMENT_72.asItem()) return 72;
        if (item == BlockInit.ELEMENT_73.asItem()) return 73;
        if (item == BlockInit.ELEMENT_74.asItem()) return 74;
        if (item == BlockInit.ELEMENT_75.asItem()) return 75;
        if (item == BlockInit.ELEMENT_76.asItem()) return 76;
        if (item == BlockInit.ELEMENT_77.asItem()) return 77;
        if (item == BlockInit.ELEMENT_78.asItem()) return 78;
        if (item == BlockInit.ELEMENT_79.asItem()) return 79;
        if (item == BlockInit.ELEMENT_80.asItem()) return 80;
        if (item == BlockInit.ELEMENT_81.asItem()) return 81;
        if (item == BlockInit.ELEMENT_82.asItem()) return 82;
        if (item == BlockInit.ELEMENT_83.asItem()) return 83;
        if (item == BlockInit.ELEMENT_84.asItem()) return 84;
        if (item == BlockInit.ELEMENT_85.asItem()) return 85;
        if (item == BlockInit.ELEMENT_86.asItem()) return 86;
        if (item == BlockInit.ELEMENT_87.asItem()) return 87;
        if (item == BlockInit.ELEMENT_88.asItem()) return 88;
        if (item == BlockInit.ELEMENT_89.asItem()) return 89;
        if (item == BlockInit.ELEMENT_90.asItem()) return 90;
        if (item == BlockInit.ELEMENT_91.asItem()) return 91;
        if (item == BlockInit.ELEMENT_92.asItem()) return 92;
        if (item == BlockInit.ELEMENT_93.asItem()) return 93;
        if (item == BlockInit.ELEMENT_94.asItem()) return 94;
        if (item == BlockInit.ELEMENT_95.asItem()) return 95;
        if (item == BlockInit.ELEMENT_96.asItem()) return 96;
        if (item == BlockInit.ELEMENT_97.asItem()) return 97;
        if (item == BlockInit.ELEMENT_98.asItem()) return 98;
        if (item == BlockInit.ELEMENT_99.asItem()) return 99;
        if (item == BlockInit.ELEMENT_100.asItem()) return 100;
        if (item == BlockInit.ELEMENT_101.asItem()) return 101;
        if (item == BlockInit.ELEMENT_102.asItem()) return 102;
        if (item == BlockInit.ELEMENT_103.asItem()) return 103;
        if (item == BlockInit.ELEMENT_104.asItem()) return 104;
        if (item == BlockInit.ELEMENT_105.asItem()) return 105;
        if (item == BlockInit.ELEMENT_106.asItem()) return 106;
        if (item == BlockInit.ELEMENT_107.asItem()) return 107;
        if (item == BlockInit.ELEMENT_108.asItem()) return 108;
        if (item == BlockInit.ELEMENT_109.asItem()) return 109;
        if (item == BlockInit.ELEMENT_110.asItem()) return 110;
        if (item == BlockInit.ELEMENT_111.asItem()) return 111;
        if (item == BlockInit.ELEMENT_112.asItem()) return 112;
        if (item == BlockInit.ELEMENT_113.asItem()) return 113;
        if (item == BlockInit.ELEMENT_114.asItem()) return 114;
        if (item == BlockInit.ELEMENT_115.asItem()) return 115;
        if (item == BlockInit.ELEMENT_116.asItem()) return 116;
        if (item == BlockInit.ELEMENT_117.asItem()) return 117;
        if (item == BlockInit.ELEMENT_118.asItem()) return 118;

        return 0;
    }
}