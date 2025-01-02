package org.loaders.soul_morphing.init;


import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import org.loaders.soul_morphing.hud.VoidFurnaceGuiScreen;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class SoulScreens {
    @SubscribeEvent
    public static void clientLoad(RegisterMenuScreensEvent event) {
        event.register(SoulMenus.VOID_FURNACE_GUI.get(), VoidFurnaceGuiScreen::new);
    }
}


