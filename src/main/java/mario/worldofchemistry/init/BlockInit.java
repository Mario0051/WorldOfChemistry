package mario.worldofchemistry.init;

import mario.worldofchemistry.objects.blocks.ElementConstructorBlock;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.function.Function;

import static mario.worldofchemistry.WorldOfChemistry.MOD_ID;

public class BlockInit {
    private static Block register(String name, Function<AbstractBlock.Settings, Block> blockFactory, AbstractBlock.Settings settings, boolean shouldRegisterItem) {
        RegistryKey<Block> blockKey = keyOfBlock(name);
        Block block = blockFactory.apply(settings.registryKey(blockKey));

        if (shouldRegisterItem) {
            RegistryKey<Item> itemKey = keyOfItem(name);

            BlockItem blockItem = new BlockItem(block, new Item.Settings().registryKey(itemKey));
            Registry.register(Registries.ITEM, itemKey, blockItem);
        }

        return Registry.register(Registries.BLOCK, blockKey, block);
    }

    private static RegistryKey<Block> keyOfBlock(String name) {
        return RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MOD_ID, name));
    }

    private static RegistryKey<Item> keyOfItem(String name) {
        return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MOD_ID, name));
    }
    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemInit.CUSTOM_ITEM_GROUP_KEY).register((itemGroup) -> {
            itemGroup.add(BlockInit.ELEMENT_0.asItem());
            itemGroup.add(BlockInit.ELEMENT_1.asItem());
            itemGroup.add(BlockInit.ELEMENT_2.asItem());
            itemGroup.add(BlockInit.ELEMENT_3.asItem());
            itemGroup.add(BlockInit.ELEMENT_4.asItem());
            itemGroup.add(BlockInit.ELEMENT_5.asItem());
            itemGroup.add(BlockInit.ELEMENT_6.asItem());
            itemGroup.add(BlockInit.ELEMENT_7.asItem());
            itemGroup.add(BlockInit.ELEMENT_8.asItem());
            itemGroup.add(BlockInit.ELEMENT_9.asItem());
            itemGroup.add(BlockInit.ELEMENT_10.asItem());
            itemGroup.add(BlockInit.ELEMENT_11.asItem());
            itemGroup.add(BlockInit.ELEMENT_12.asItem());
            itemGroup.add(BlockInit.ELEMENT_13.asItem());
            itemGroup.add(BlockInit.ELEMENT_14.asItem());
            itemGroup.add(BlockInit.ELEMENT_15.asItem());
            itemGroup.add(BlockInit.ELEMENT_16.asItem());
            itemGroup.add(BlockInit.ELEMENT_17.asItem());
            itemGroup.add(BlockInit.ELEMENT_18.asItem());
            itemGroup.add(BlockInit.ELEMENT_19.asItem());
            itemGroup.add(BlockInit.ELEMENT_20.asItem());
            itemGroup.add(BlockInit.ELEMENT_21.asItem());
            itemGroup.add(BlockInit.ELEMENT_22.asItem());
            itemGroup.add(BlockInit.ELEMENT_23.asItem());
            itemGroup.add(BlockInit.ELEMENT_24.asItem());
            itemGroup.add(BlockInit.ELEMENT_25.asItem());
            itemGroup.add(BlockInit.ELEMENT_26.asItem());
            itemGroup.add(BlockInit.ELEMENT_27.asItem());
            itemGroup.add(BlockInit.ELEMENT_28.asItem());
            itemGroup.add(BlockInit.ELEMENT_29.asItem());
            itemGroup.add(BlockInit.ELEMENT_30.asItem());
            itemGroup.add(BlockInit.ELEMENT_31.asItem());
            itemGroup.add(BlockInit.ELEMENT_32.asItem());
            itemGroup.add(BlockInit.ELEMENT_33.asItem());
            itemGroup.add(BlockInit.ELEMENT_34.asItem());
            itemGroup.add(BlockInit.ELEMENT_35.asItem());
            itemGroup.add(BlockInit.ELEMENT_36.asItem());
            itemGroup.add(BlockInit.ELEMENT_37.asItem());
            itemGroup.add(BlockInit.ELEMENT_38.asItem());
            itemGroup.add(BlockInit.ELEMENT_39.asItem());
            itemGroup.add(BlockInit.ELEMENT_40.asItem());
            itemGroup.add(BlockInit.ELEMENT_41.asItem());
            itemGroup.add(BlockInit.ELEMENT_42.asItem());
            itemGroup.add(BlockInit.ELEMENT_43.asItem());
            itemGroup.add(BlockInit.ELEMENT_44.asItem());
            itemGroup.add(BlockInit.ELEMENT_45.asItem());
            itemGroup.add(BlockInit.ELEMENT_46.asItem());
            itemGroup.add(BlockInit.ELEMENT_47.asItem());
            itemGroup.add(BlockInit.ELEMENT_48.asItem());
            itemGroup.add(BlockInit.ELEMENT_49.asItem());
            itemGroup.add(BlockInit.ELEMENT_50.asItem());
            itemGroup.add(BlockInit.ELEMENT_51.asItem());
            itemGroup.add(BlockInit.ELEMENT_52.asItem());
            itemGroup.add(BlockInit.ELEMENT_53.asItem());
            itemGroup.add(BlockInit.ELEMENT_54.asItem());
            itemGroup.add(BlockInit.ELEMENT_55.asItem());
            itemGroup.add(BlockInit.ELEMENT_56.asItem());
            itemGroup.add(BlockInit.ELEMENT_57.asItem());
            itemGroup.add(BlockInit.ELEMENT_58.asItem());
            itemGroup.add(BlockInit.ELEMENT_59.asItem());
            itemGroup.add(BlockInit.ELEMENT_60.asItem());
            itemGroup.add(BlockInit.ELEMENT_61.asItem());
            itemGroup.add(BlockInit.ELEMENT_62.asItem());
            itemGroup.add(BlockInit.ELEMENT_63.asItem());
            itemGroup.add(BlockInit.ELEMENT_64.asItem());
            itemGroup.add(BlockInit.ELEMENT_65.asItem());
            itemGroup.add(BlockInit.ELEMENT_66.asItem());
            itemGroup.add(BlockInit.ELEMENT_67.asItem());
            itemGroup.add(BlockInit.ELEMENT_68.asItem());
            itemGroup.add(BlockInit.ELEMENT_69.asItem());
            itemGroup.add(BlockInit.ELEMENT_70.asItem());
            itemGroup.add(BlockInit.ELEMENT_71.asItem());
            itemGroup.add(BlockInit.ELEMENT_72.asItem());
            itemGroup.add(BlockInit.ELEMENT_73.asItem());
            itemGroup.add(BlockInit.ELEMENT_74.asItem());
            itemGroup.add(BlockInit.ELEMENT_75.asItem());
            itemGroup.add(BlockInit.ELEMENT_76.asItem());
            itemGroup.add(BlockInit.ELEMENT_77.asItem());
            itemGroup.add(BlockInit.ELEMENT_78.asItem());
            itemGroup.add(BlockInit.ELEMENT_79.asItem());
            itemGroup.add(BlockInit.ELEMENT_80.asItem());
            itemGroup.add(BlockInit.ELEMENT_81.asItem());
            itemGroup.add(BlockInit.ELEMENT_82.asItem());
            itemGroup.add(BlockInit.ELEMENT_83.asItem());
            itemGroup.add(BlockInit.ELEMENT_84.asItem());
            itemGroup.add(BlockInit.ELEMENT_85.asItem());
            itemGroup.add(BlockInit.ELEMENT_86.asItem());
            itemGroup.add(BlockInit.ELEMENT_87.asItem());
            itemGroup.add(BlockInit.ELEMENT_88.asItem());
            itemGroup.add(BlockInit.ELEMENT_89.asItem());
            itemGroup.add(BlockInit.ELEMENT_90.asItem());
            itemGroup.add(BlockInit.ELEMENT_91.asItem());
            itemGroup.add(BlockInit.ELEMENT_92.asItem());
            itemGroup.add(BlockInit.ELEMENT_93.asItem());
            itemGroup.add(BlockInit.ELEMENT_94.asItem());
            itemGroup.add(BlockInit.ELEMENT_95.asItem());
            itemGroup.add(BlockInit.ELEMENT_96.asItem());
            itemGroup.add(BlockInit.ELEMENT_97.asItem());
            itemGroup.add(BlockInit.ELEMENT_98.asItem());
            itemGroup.add(BlockInit.ELEMENT_99.asItem());
            itemGroup.add(BlockInit.ELEMENT_100.asItem());
            itemGroup.add(BlockInit.ELEMENT_101.asItem());
            itemGroup.add(BlockInit.ELEMENT_102.asItem());
            itemGroup.add(BlockInit.ELEMENT_103.asItem());
            itemGroup.add(BlockInit.ELEMENT_104.asItem());
            itemGroup.add(BlockInit.ELEMENT_105.asItem());
            itemGroup.add(BlockInit.ELEMENT_106.asItem());
            itemGroup.add(BlockInit.ELEMENT_107.asItem());
            itemGroup.add(BlockInit.ELEMENT_108.asItem());
            itemGroup.add(BlockInit.ELEMENT_109.asItem());
            itemGroup.add(BlockInit.ELEMENT_110.asItem());
            itemGroup.add(BlockInit.ELEMENT_111.asItem());
            itemGroup.add(BlockInit.ELEMENT_112.asItem());
            itemGroup.add(BlockInit.ELEMENT_113.asItem());
            itemGroup.add(BlockInit.ELEMENT_114.asItem());
            itemGroup.add(BlockInit.ELEMENT_115.asItem());
            itemGroup.add(BlockInit.ELEMENT_116.asItem());
            itemGroup.add(BlockInit.ELEMENT_117.asItem());
            itemGroup.add(BlockInit.ELEMENT_118.asItem());
            itemGroup.add(BlockInit.ELEMENT_CONSTRUCTOR.asItem());
        });
    }
    public static final Block ELEMENT_0 = register(
            "element_0",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_1 = register(
            "element_1",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_2 = register(
            "element_2",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_3 = register(
            "element_3",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_4 = register(
            "element_4",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_5 = register(
            "element_5",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_6 = register(
            "element_6",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_7 = register(
            "element_7",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_8 = register(
            "element_8",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_9 = register(
            "element_9",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_10 = register(
            "element_10",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_11 = register(
            "element_11",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_12 = register(
            "element_12",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_13 = register(
            "element_13",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_14 = register(
            "element_14",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_15 = register(
            "element_15",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_16 = register(
            "element_16",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_17 = register(
            "element_17",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_18 = register(
            "element_18",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_19 = register(
            "element_19",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_20 = register(
            "element_20",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_21 = register(
            "element_21",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_22 = register(
            "element_22",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_23 = register(
            "element_23",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_24 = register(
            "element_24",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_25 = register(
            "element_25",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_26 = register(
            "element_26",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_27 = register(
            "element_27",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_28 = register(
            "element_28",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_29 = register(
            "element_29",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_30 = register(
            "element_30",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_31 = register(
            "element_31",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_32 = register(
            "element_32",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_33 = register(
            "element_33",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_34 = register(
            "element_34",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_35 = register(
            "element_35",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_36 = register(
            "element_36",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_37 = register(
            "element_37",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_38 = register(
            "element_38",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_39 = register(
            "element_39",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_40 = register(
            "element_40",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_41 = register(
            "element_41",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_42 = register(
            "element_42",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_43 = register(
            "element_43",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_44 = register(
            "element_44",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_45 = register(
            "element_45",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_46 = register(
            "element_46",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_47 = register(
            "element_47",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_48 = register(
            "element_48",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_49 = register(
            "element_49",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_50 = register(
            "element_50",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_51 = register(
            "element_51",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_52 = register(
            "element_52",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_53 = register(
            "element_53",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_54 = register(
            "element_54",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_55 = register(
            "element_55",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_56 = register(
            "element_56",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_57 = register(
            "element_57",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_58 = register(
            "element_58",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_59 = register(
            "element_59",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_60 = register(
            "element_60",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_61 = register(
            "element_61",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_62 = register(
            "element_62",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_63 = register(
            "element_63",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_64 = register(
            "element_64",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_65 = register(
            "element_65",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_66 = register(
            "element_66",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_67 = register(
            "element_67",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_68 = register(
            "element_68",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_69 = register(
            "element_69",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_70 = register(
            "element_70",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_71 = register(
            "element_71",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_72 = register(
            "element_72",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_73 = register(
            "element_73",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_74 = register(
            "element_74",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_75 = register(
            "element_75",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_76 = register(
            "element_76",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_77 = register(
            "element_77",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_78 = register(
            "element_78",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_79 = register(
            "element_79",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_80 = register(
            "element_80",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_81 = register(
            "element_81",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_82 = register(
            "element_82",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_83 = register(
            "element_83",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_84 = register(
            "element_84",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_85 = register(
            "element_85",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_86 = register(
            "element_86",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_87 = register(
            "element_87",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_88 = register(
            "element_88",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_89 = register(
            "element_89",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_90 = register(
            "element_90",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_91 = register(
            "element_91",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_92 = register(
            "element_92",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_93 = register(
            "element_93",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_94 = register(
            "element_94",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_95 = register(
            "element_95",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_96 = register(
            "element_96",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_97 = register(
            "element_97",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_98 = register(
            "element_98",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_99 = register(
            "element_99",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_100 = register(
            "element_100",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_101 = register(
            "element_101",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_102 = register(
            "element_102",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_103 = register(
            "element_103",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_104 = register(
            "element_104",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_105 = register(
            "element_105",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_106 = register(
            "element_106",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_107 = register(
            "element_107",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_108 = register(
            "element_108",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_109 = register(
            "element_109",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_110 = register(
            "element_110",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_111 = register(
            "element_111",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_112 = register(
            "element_112",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_113 = register(
            "element_113",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_114 = register(
            "element_114",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_115 = register(
            "element_115",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_116 = register(
            "element_116",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_117 = register(
            "element_117",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_118 = register(
            "element_118",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block ELEMENT_CONSTRUCTOR = register(
            "element_constructor",
            ElementConstructorBlock::new,
            AbstractBlock.Settings.create()
                    .strength(2.5f, 2.0f)
                    .sounds(BlockSoundGroup.STONE),
            true
    );
}
