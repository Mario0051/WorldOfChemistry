package mario.worldofchemistry.objects.items;

import net.minecraft.block.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;

import java.util.Collections;

public class RapidFertilizerItem extends Item {

    public RapidFertilizerItem(Item.Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        ItemStack stack = context.getStack();

        if (world.isClient) {
            BlockState currentBlockStateClient = world.getBlockState(pos);
            Block currentBlockClient = currentBlockStateClient.getBlock();
            if (currentBlockClient instanceof Fertilizable ||
                    currentBlockClient instanceof SaplingBlock ||
                    currentBlockClient instanceof CropBlock ||
                    currentBlockClient instanceof StemBlock ||
                    currentBlockClient instanceof CocoaBlock ||
                    currentBlockClient instanceof SweetBerryBushBlock ||
                    currentBlockClient instanceof MushroomPlantBlock ||
                    currentBlockClient instanceof FungusBlock ||
                    currentBlockClient instanceof KelpBlock ||
                    currentBlockClient instanceof KelpPlantBlock) {
                return ActionResult.SUCCESS;
            }
            return ActionResult.PASS;
        }

        boolean success = false;
        BlockState initialBlockState = world.getBlockState(pos);
        Block initialBlock = initialBlockState.getBlock();

        final int UPDATE_FLAGS = Block.NOTIFY_LISTENERS | Block.NOTIFY_NEIGHBORS;

        if (initialBlock instanceof BeetrootsBlock beetrootsBlock) {
            IntProperty ageProperty = BeetrootsBlock.AGE;
            int maxAge = beetrootsBlock.getMaxAge();
            if (initialBlockState.contains(ageProperty)) {
                if (initialBlockState.get(ageProperty) < maxAge) {
                    world.setBlockState(pos, initialBlockState.with(ageProperty, maxAge), UPDATE_FLAGS);
                    success = true;
                    BlockState newState = world.getBlockState(pos);
                    if (newState.getBlock() instanceof Fertilizable f &&
                            newState.get(ageProperty) == maxAge &&
                            f.isFertilizable(world,pos,newState) &&
                            f.canGrow(world, world.random, pos, newState)) {
                        f.grow((ServerWorld) world, world.random, pos, newState);
                    }
                }
            }
        }
        else if (initialBlock instanceof CropBlock cropBlock) {
            IntProperty ageProperty = CropBlock.AGE;
            int maxAge = cropBlock.getMaxAge();
            if (initialBlockState.contains(ageProperty)) {
                if (initialBlockState.get(ageProperty) < maxAge) {
                    world.setBlockState(pos, initialBlockState.with(ageProperty, maxAge), UPDATE_FLAGS);
                    success = true;
                }
            }
        }
        else if (initialBlock instanceof PropaguleBlock && initialBlockState.contains(PropaguleBlock.HANGING) && initialBlockState.get(PropaguleBlock.HANGING)) {
            IntProperty ageProperty = PropaguleBlock.AGE;
            int maxAge = Collections.max(ageProperty.getValues());

            if (initialBlockState.contains(ageProperty)) {
                if (initialBlockState.get(ageProperty) < maxAge) {
                    world.setBlockState(pos, initialBlockState.with(ageProperty, maxAge), UPDATE_FLAGS);
                    success = true;
                }
            }
        }
        else if (initialBlock instanceof SaplingBlock sapling) {
            if (world instanceof ServerWorld serverWorld) {
                Block originalBlockType = initialBlockState.getBlock();
                BlockState currentState = initialBlockState;
                Fertilizable fertilizableSapling = (Fertilizable)sapling;
                fertilizableSapling.grow(serverWorld, serverWorld.random, pos, currentState);
                BlockState stateAfterFirstGrow = serverWorld.getBlockState(pos);
                if (stateAfterFirstGrow.getBlock() != originalBlockType) {
                    success = true;
                }
                else if (stateAfterFirstGrow.getBlock() == originalBlockType &&
                        stateAfterFirstGrow.get(SaplingBlock.STAGE) == 1) {
                    fertilizableSapling.grow(serverWorld, serverWorld.random, pos, stateAfterFirstGrow);
                    if (serverWorld.getBlockState(pos).getBlock() != originalBlockType) {
                        success = true;
                    }
                }
            }
        }
        else if (initialBlock instanceof MushroomPlantBlock mushroomPlantBlock) {
            if (world instanceof ServerWorld serverWorld) {
                Fertilizable fertilizableMushroom = (Fertilizable)mushroomPlantBlock;
                fertilizableMushroom.grow(serverWorld, serverWorld.random, pos, initialBlockState);
                BlockState stateAfterGrow = serverWorld.getBlockState(pos);
                if (stateAfterGrow.getBlock() != initialBlock) {
                    success = true;
                }
            }
        }
        else if (initialBlock instanceof FungusBlock fungusBlock) {
            if (world instanceof ServerWorld serverWorld) {
                Fertilizable fertilizableFungus = (Fertilizable)fungusBlock;
                fertilizableFungus.grow(serverWorld, serverWorld.random, pos, initialBlockState);
                BlockState stateAfterGrow = serverWorld.getBlockState(pos);
                if (stateAfterGrow.getBlock() != initialBlock) {
                    success = true;
                }
            }
        }
        else if (initialBlock instanceof KelpBlock || initialBlock instanceof KelpPlantBlock) {
            if (world instanceof ServerWorld serverWorld && initialBlock instanceof Fertilizable fertilizableKelp) {
                BlockState blockAboveBeforeGrow = serverWorld.getBlockState(pos.up());
                BlockState stateAtPosBeforeGrow = initialBlockState;
                if (fertilizableKelp.isFertilizable(serverWorld, pos, initialBlockState) &&
                        fertilizableKelp.canGrow(serverWorld, serverWorld.random, pos, initialBlockState)) {
                    fertilizableKelp.grow(serverWorld, serverWorld.random, pos, initialBlockState);
                    BlockState stateAtPosAfterGrow = serverWorld.getBlockState(pos);
                    BlockState blockAboveAfterGrow = serverWorld.getBlockState(pos.up());
                    if (!stateAtPosAfterGrow.equals(stateAtPosBeforeGrow) ||
                            (blockAboveAfterGrow.getBlock() instanceof KelpPlantBlock && !blockAboveAfterGrow.equals(blockAboveBeforeGrow))) {
                        success = true;
                    }
                }
            }
        }
        else if (initialBlock instanceof StemBlock) {
            if (initialBlockState.contains(Properties.AGE_7)) {
                int currentAge = initialBlockState.get(Properties.AGE_7);
                int maxAge = Collections.max(Properties.AGE_7.getValues());
                if (currentAge < maxAge) {
                    world.setBlockState(pos, initialBlockState.with(Properties.AGE_7, maxAge), UPDATE_FLAGS);
                    success = true;
                }
            }
        }
        else if (initialBlock instanceof CocoaBlock) {
            if (initialBlockState.contains(CocoaBlock.AGE)) {
                int currentAge = initialBlockState.get(CocoaBlock.AGE);
                int maxAge = Collections.max(CocoaBlock.AGE.getValues());
                if (currentAge < maxAge) {
                    world.setBlockState(pos, initialBlockState.with(CocoaBlock.AGE, maxAge), UPDATE_FLAGS);
                    success = true;
                }
            }
        }
        else if (initialBlock instanceof SweetBerryBushBlock) {
            if (initialBlockState.contains(SweetBerryBushBlock.AGE)) {
                int currentAge = initialBlockState.get(SweetBerryBushBlock.AGE);
                int maxAge = Collections.max(SweetBerryBushBlock.AGE.getValues());
                if (currentAge < maxAge) {
                    world.setBlockState(pos, initialBlockState.with(SweetBerryBushBlock.AGE, maxAge), UPDATE_FLAGS);
                    success = true;
                }
            }
        }
        else if (initialBlock instanceof Fertilizable fertilizable &&
                !(initialBlock instanceof MushroomPlantBlock) &&
                !(initialBlock instanceof FungusBlock) &&
                !(initialBlock instanceof KelpBlock) &&
                !(initialBlock instanceof KelpPlantBlock) &&
                !(initialBlock instanceof PropaguleBlock) && initialBlockState.contains(PropaguleBlock.HANGING) && initialBlockState.get(PropaguleBlock.HANGING)) {
            if (fertilizable.isFertilizable(world, pos, initialBlockState) &&
                    fertilizable.canGrow(world, world.random, pos, initialBlockState)) {
                fertilizable.grow((ServerWorld) world, world.random, pos, initialBlockState);
                success = true;
            }
        }

        if (success) {
            if (context.getPlayer() == null || !context.getPlayer().getAbilities().creativeMode) {
                stack.decrement(1);
            }
            world.syncWorldEvent(WorldEvents.BONE_MEAL_USED, pos, 15);
            return ActionResult.SUCCESS;
        }

        return ActionResult.PASS;
    }
}
