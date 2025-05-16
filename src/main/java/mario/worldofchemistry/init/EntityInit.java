package mario.worldofchemistry.init;

import mario.worldofchemistry.WorldOfChemistry;
import mario.worldofchemistry.objects.entities.IceBombEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class EntityInit {

    public static EntityType<IceBombEntity> ICE_BOMB_ENTITY_TYPE;

    public static void initialize() {

        Identifier entityTypeId = Identifier.of(WorldOfChemistry.MOD_ID, "ice_bomb");

        RegistryKey<EntityType<?>> entityRegistryKey = RegistryKey.of(RegistryKeys.ENTITY_TYPE, entityTypeId);

        EntityType<IceBombEntity> builtEntityType = EntityType.Builder.<IceBombEntity>create(IceBombEntity::new, SpawnGroup.MISC)
                .dimensions(0.25f, 0.25f)
                .build(entityRegistryKey);

        ICE_BOMB_ENTITY_TYPE = Registry.register(
                Registries.ENTITY_TYPE,
                entityTypeId,
                builtEntityType
        );
    }
}
