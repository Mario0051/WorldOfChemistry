package mario.worldofchemistry.handler;

import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.util.math.BlockPos;

public record ElementConstructorScreenOpeningData(BlockPos blockEntityPos) {

    public static final PacketCodec<RegistryByteBuf, ElementConstructorScreenOpeningData> PACKET_CODEC =
            PacketCodec.tuple(
                    BlockPos.PACKET_CODEC,
                    ElementConstructorScreenOpeningData::blockEntityPos,
                    ElementConstructorScreenOpeningData::new
            );
}