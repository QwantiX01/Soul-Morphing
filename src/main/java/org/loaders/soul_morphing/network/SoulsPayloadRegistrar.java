package org.loaders.soul_morphing.network;


import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.handling.DirectionalPayloadHandler;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import org.loaders.soul_morphing.util.Souls;

import static org.loaders.soul_morphing.Soul_morphing.MODID;

@EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD)
public class SoulsPayloadRegistrar {

    public static class ClientPayloadHandler {

        public static void handleDataOnMain(final SoulsData data, final IPayloadContext context) {
            Player player = context.player();
            Souls.setSouls(player, data.souls());
            Souls.setMaxSouls(player, data.maxSouls());
        }
    }

    public static class ServerPayloadHandler {

        public static void handleDataOnMain(final SoulsData data, final IPayloadContext context) {
            Player player = context.player();
            Souls.setSouls(player, data.souls());
            Souls.setMaxSouls(player, data.maxSouls());
        }
    }

    @SubscribeEvent
    public static void register(final RegisterPayloadHandlersEvent event) {
        final PayloadRegistrar registrar = event.registrar("1");
        registrar.playBidirectional(
                SoulsData.TYPE,
                SoulsData.STREAM_CODEC,
                new DirectionalPayloadHandler<>(
                        ClientPayloadHandler::handleDataOnMain,
                        ServerPayloadHandler::handleDataOnMain
                )
        );
    }
}
