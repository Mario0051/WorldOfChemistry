package mario.worldofchemistry.init;

import mario.worldofchemistry.WorldOfChemistry;
import mario.worldofchemistry.objects.blockentities.ElementConstructorBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class BlockEntityInit {

    public static BlockEntityType<ElementConstructorBlockEntity> ELEMENT_CONSTRUCTOR_BLOCK_ENTITY_TYPE;

    public static void initialize() {
        ELEMENT_CONSTRUCTOR_BLOCK_ENTITY_TYPE = Registry.register(
                Registries.BLOCK_ENTITY_TYPE,
                Identifier.of(WorldOfChemistry.MOD_ID, "element_constructor"),
                FabricBlockEntityTypeBuilder.create(ElementConstructorBlockEntity::new, BlockInit.ELEMENT_CONSTRUCTOR)
                        .build()
        );
    }
}
