package mario.worldofchemistry.objects.entities;

import mario.worldofchemistry.init.EntityInit;
import mario.worldofchemistry.init.ItemInit;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityStatuses;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class IceBombEntity extends ThrownItemEntity {

    public IceBombEntity(EntityType<? extends IceBombEntity> entityType, World world) {
        super(entityType, world);
    }

    public IceBombEntity(World world, LivingEntity owner, ItemStack stack) {
        super(EntityInit.ICE_BOMB_ENTITY_TYPE, owner, world, stack);
    }

    public IceBombEntity(World world, double x, double y, double z) {
        super(EntityInit.ICE_BOMB_ENTITY_TYPE, x, y, z, world, new ItemStack(ItemInit.ICE_BOMB));
    }

    @Override
    protected Item getDefaultItem() {
        return ItemInit.ICE_BOMB;
    }

    @Override
    public void handleStatus(byte status) {
        if (status == EntityStatuses.PLAY_DEATH_SOUND_OR_ADD_PROJECTILE_HIT_PARTICLES) {
            ParticleEffect particleEffect = ParticleTypes.ITEM_SNOWBALL;
            for (int i = 0; i < 8; ++i) {
                this.getWorld().addParticleClient(particleEffect, this.getX(), this.getY(), this.getZ(), 0.0, 0.0, 0.0);
            }
        } else {
            super.handleStatus(status);
        }
    }

    private void applyIceBombEffect(BlockPos impactCenter) {
        if (this.getWorld().isClient) {
            return;
        }

        this.getWorld().playSound(
                null,
                impactCenter.getX() + 0.5, impactCenter.getY() + 0.5, impactCenter.getZ() + 0.5,
                SoundEvents.BLOCK_GLASS_BREAK,
                SoundCategory.NEUTRAL,
                0.7f,
                1.0f / (this.random.nextFloat() * 0.4f + 0.8f)
        );

        int radius = 1;
        for (int xOffset = -radius; xOffset <= radius; xOffset++) {
            for (int yOffset = -radius; yOffset <= radius; yOffset++) {
                for (int zOffset = -radius; zOffset <= radius; zOffset++) {
                    BlockPos currentPos = impactCenter.add(xOffset, yOffset, zOffset);
                    BlockState blockState = this.getWorld().getBlockState(currentPos);

                    if (blockState.isOf(Blocks.WATER)) {
                        this.getWorld().setBlockState(currentPos, Blocks.ICE.getDefaultState(), Block.NOTIFY_ALL);
                    }
                }
            }
        }
    }

    @Override
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);

        if (!this.getWorld().isClient && !this.isRemoved()) {
            BlockPos impactPos;
            if (hitResult.getType() == HitResult.Type.BLOCK) {
                impactPos = ((BlockHitResult) hitResult).getBlockPos();
            } else if (hitResult.getType() == HitResult.Type.ENTITY) {
                impactPos = ((EntityHitResult) hitResult).getEntity().getBlockPos();
            } else {
                impactPos = this.getBlockPos();
            }

            applyIceBombEffect(impactPos);
            this.getWorld().sendEntityStatus(this, EntityStatuses.PLAY_DEATH_SOUND_OR_ADD_PROJECTILE_HIT_PARTICLES);
            this.discard();
        }
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.getWorld().isClient && !this.isRemoved() && this.isTouchingWater()) {
            applyIceBombEffect(this.getBlockPos());
            this.getWorld().sendEntityStatus(this, EntityStatuses.PLAY_DEATH_SOUND_OR_ADD_PROJECTILE_HIT_PARTICLES);
            this.discard();
        }
    }
}
