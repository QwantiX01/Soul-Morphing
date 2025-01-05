package org.loaders.soul_morphing.network;

import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.loaders.soul_morphing.init.data.SoulAttributes;

public class ServerPayloadHandler {

    public static void handleDataOnMain(final SoulsData data, final IPayloadContext context) {
        Player player = context.player();
        player.getAttribute(SoulAttributes.SOULS_COUNT).setBaseValue(data.souls());
        player.getAttribute(SoulAttributes.MAX_SOULS_COUNT).setBaseValue(data.maxSouls());
    }
}
