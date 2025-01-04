package org.loaders.soul_morphing.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

import static org.loaders.soul_morphing.Soul_morphing.MODID;


public record SoulsData(int souls, int maxSouls) implements CustomPacketPayload {

    public static final CustomPacketPayload.Type<SoulsData> TYPE = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath(MODID, "souls_data"));

    public static final StreamCodec<ByteBuf, SoulsData> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.VAR_INT,
            SoulsData::souls,
            ByteBufCodecs.VAR_INT,
            SoulsData::maxSouls,
            SoulsData::new
    );

    @Override
    public @NotNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}


