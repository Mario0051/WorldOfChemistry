package mario.worldofchemistry.objects.blockentities;

import mario.worldofchemistry.handler.ElementConstructorScreenOpeningData;
import mario.worldofchemistry.handler.ElementConstructorScreenHandler;
import mario.worldofchemistry.init.BlockEntityInit;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class ElementConstructorBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory<ElementConstructorScreenOpeningData> {

    public ElementConstructorBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityInit.ELEMENT_CONSTRUCTOR_BLOCK_ENTITY_TYPE, pos, state);
    }

    @Override
    public ElementConstructorScreenOpeningData getScreenOpeningData(ServerPlayerEntity player) {
        return new ElementConstructorScreenOpeningData(this.pos);
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable(getCachedState().getBlock().getTranslationKey());
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new ElementConstructorScreenHandler(syncId, playerInventory, getScreenOpeningData((ServerPlayerEntity) player));
    }

    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup registries) {
        return createNbt(registries);
    }

}