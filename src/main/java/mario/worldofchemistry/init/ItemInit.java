package mario.worldofchemistry.init;

import mario.worldofchemistry.objects.items.IceBombItem;
import mario.worldofchemistry.objects.items.RapidFertilizerItem;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.function.Function;

import static mario.worldofchemistry.WorldOfChemistry.MOD_ID;

public class ItemInit {
    public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        // Create the item key.
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MOD_ID, name));

        // Create the item instance.
        Item item = itemFactory.apply(settings.registryKey(itemKey));

        // Register the item.
        Registry.register(Registries.ITEM, itemKey, item);

        return item;
    }
    public static void initialize() {
        Registry.register(Registries.ITEM_GROUP, CUSTOM_ITEM_GROUP_KEY, CUSTOM_ITEM_GROUP);
        ItemGroupEvents.modifyEntriesEvent(CUSTOM_ITEM_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(ItemInit.SALT);
            itemGroup.add(ItemInit.SODIUM_OXIDE);
            itemGroup.add(ItemInit.SODIUM_HYDROXIDE);
            itemGroup.add(ItemInit.MAGNESIUM_NITRATE);
            itemGroup.add(ItemInit.IRON_SULFIDE);
            itemGroup.add(ItemInit.LITHIUM_HYDRIDE);
            itemGroup.add(ItemInit.SODIUM_HYDRIDE);
            itemGroup.add(ItemInit.CALCIUM_BROMIDE);
            itemGroup.add(ItemInit.MAGNESIUM_OXIDE);
            itemGroup.add(ItemInit.SODIUM_ACETATE);
            itemGroup.add(ItemInit.LUMINOL);
            itemGroup.add(ItemInit.ALUMINUM_OXIDE);
            itemGroup.add(ItemInit.BORON_TRIOXIDE);
            itemGroup.add(ItemInit.SOAP);
            itemGroup.add(ItemInit.POLYETHYLENE);
            itemGroup.add(ItemInit.GARBAGE);
            itemGroup.add(ItemInit.MAGNESIUM_SALTS);
            itemGroup.add(ItemInit.SULFATE);
            itemGroup.add(ItemInit.BARIUM_SULFATE);
            itemGroup.add(ItemInit.POTASSIUM_CHLORIDE);
            itemGroup.add(ItemInit.MERCURIC_CHLORIDE);
            itemGroup.add(ItemInit.CERIUM_CHLORIDE);
            itemGroup.add(ItemInit.TUNGSTEN_CHLORIDE);
            itemGroup.add(ItemInit.CALCIUM_CHLORIDE);
            itemGroup.add(ItemInit.WATER);
            itemGroup.add(ItemInit.GLUE);
            itemGroup.add(ItemInit.HYPOCHLORITE);
            itemGroup.add(ItemInit.CRUDE_OIL);
            itemGroup.add(ItemInit.LATEX);
            itemGroup.add(ItemInit.POTASSIUM_IODIDE);
            itemGroup.add(ItemInit.SODIUM_FLUORIDE);
            itemGroup.add(ItemInit.BENZENE);
            itemGroup.add(ItemInit.HYDROGEN_PEROXIDE);
            itemGroup.add(ItemInit.AMMONIA);
            itemGroup.add(ItemInit.SODIUM_HYPOCHLORITE);
            itemGroup.add(ItemInit.RAPID_FERTILIZER);
            itemGroup.add(ItemInit.ICE_BOMB);
            itemGroup.add(ItemInit.BLEACH);
        });
    }
    public static final Item SALT = register("salt", Item::new, new Item.Settings());
    public static final Item SODIUM_OXIDE = register("sodium_oxide", Item::new, new Item.Settings());
    public static final Item SODIUM_HYDROXIDE = register("sodium_hydroxide", Item::new, new Item.Settings());
    public static final Item MAGNESIUM_NITRATE = register("magnesium_nitrate", Item::new, new Item.Settings());
    public static final Item IRON_SULFIDE = register("iron_sulfide", Item::new, new Item.Settings());
    public static final Item LITHIUM_HYDRIDE = register("lithium_hydride", Item::new, new Item.Settings());
    public static final Item SODIUM_HYDRIDE = register("sodium_hydride", Item::new, new Item.Settings());
    public static final Item CALCIUM_BROMIDE = register("calcium_bromide", Item::new, new Item.Settings());
    public static final Item MAGNESIUM_OXIDE = register("magnesium_oxide", Item::new, new Item.Settings());
    public static final Item SODIUM_ACETATE = register("sodium_acetate", Item::new, new Item.Settings());
    public static final Item LUMINOL = register("luminol", Item::new, new Item.Settings());
    public static final Item ALUMINUM_OXIDE = register("aluminum_oxide", Item::new, new Item.Settings());
    public static final Item BORON_TRIOXIDE = register("boron_trioxide", Item::new, new Item.Settings());
    public static final Item SOAP = register("soap", Item::new, new Item.Settings());
    public static final Item POLYETHYLENE = register("polyethylene", Item::new, new Item.Settings());
    public static final Item GARBAGE = register("garbage", Item::new, new Item.Settings());
    public static final Item MAGNESIUM_SALTS = register("magnesium_salts", Item::new, new Item.Settings());
    public static final Item SULFATE = register("sulfate", Item::new, new Item.Settings());
    public static final Item BARIUM_SULFATE = register("barium_sulfate", Item::new, new Item.Settings());
    public static final Item POTASSIUM_CHLORIDE = register("potassium_chloride", Item::new, new Item.Settings());
    public static final Item MERCURIC_CHLORIDE = register("mercuric_chloride", Item::new, new Item.Settings());
    public static final Item CERIUM_CHLORIDE = register("cerium_chloride", Item::new, new Item.Settings());
    public static final Item TUNGSTEN_CHLORIDE = register("tungsten_chloride", Item::new, new Item.Settings());
    public static final Item CALCIUM_CHLORIDE = register("calcium_chloride", Item::new, new Item.Settings());
    public static final Item WATER = register("water", Item::new, new Item.Settings());
    public static final Item GLUE = register("glue", Item::new, new Item.Settings());
    public static final Item HYPOCHLORITE = register("hypochlorite", Item::new, new Item.Settings());
    public static final Item CRUDE_OIL = register("crude_oil", Item::new, new Item.Settings());
    public static final Item LATEX = register("latex", Item::new, new Item.Settings());
    public static final Item POTASSIUM_IODIDE = register("potassium_iodide", Item::new, new Item.Settings());
    public static final Item SODIUM_FLUORIDE = register("sodium_fluoride", Item::new, new Item.Settings());
    public static final Item BENZENE = register("benzene", Item::new, new Item.Settings());
    public static final Item HYDROGEN_PEROXIDE = register("hydrogen_peroxide", Item::new, new Item.Settings());
    public static final Item AMMONIA = register("ammonia", Item::new, new Item.Settings());
    public static final Item SODIUM_HYPOCHLORITE = register("sodium_hypochlorite", Item::new, new Item.Settings());
    public static final Item RAPID_FERTILIZER = register("rapid_fertilizer", RapidFertilizerItem::new, new Item.Settings());
    public static final Item ICE_BOMB = register("ice_bomb", IceBombItem::new, new Item.Settings().maxCount(16));
    public static final Item BLEACH = register("bleach", Item::new, new Item.Settings());
    public static final RegistryKey<ItemGroup> CUSTOM_ITEM_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(MOD_ID, "item_group"));
    public static final ItemGroup CUSTOM_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(BlockInit.ELEMENT_0))
            .displayName(Text.translatable("itemGroup.woc"))
            .build();
}
