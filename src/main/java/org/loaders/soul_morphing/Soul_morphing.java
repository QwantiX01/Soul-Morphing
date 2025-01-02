package org.loaders.soul_morphing;

import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.loaders.soul_morphing.init.*;
import org.loaders.soul_morphing.util.Souls;
import org.slf4j.Logger;

@Mod(Soul_morphing.MODID)
public class Soul_morphing {
    public static final String MODID = "soul_morphing";
    private static final Logger LOGGER = LogUtils.getLogger();

    public Soul_morphing(IEventBus modEventBus, ModContainer modContainer) {
        SoulBlocksEntities.REGISTRY.register(modEventBus);
        SoulBlocks.BLOCKS.register(modEventBus);
        SoulAttributes.REGISTRY.register(modEventBus);
        SoulItems.ITEMS.register(modEventBus);
        SoulMenus.REGISTRY.register(modEventBus);
        SoulCreativeTab.CREATIVE_MODE_TABS.register(modEventBus);

        NeoForge.EVENT_BUS.register(this);
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }

    @EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            ItemProperties.register(SoulItems.MIST_AMULET.get(), ResourceLocation.withDefaultNamespace("capable"),
                    (itemStack, clientLevel, livingEntity, i) ->
                            livingEntity != null && (livingEntity.getItemInHand(InteractionHand.MAIN_HAND) == itemStack || livingEntity.getItemInHand(InteractionHand.OFF_HAND) == itemStack) && Souls.getSouls(livingEntity) >= 8 ? 1 : 0);
        }
    }

}
