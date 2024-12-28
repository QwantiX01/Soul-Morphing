package org.loaders.soul_morphing;

import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.loaders.soul_morphing.attributes.SoulAttributes;
import org.loaders.soul_morphing.blocks.SoulBlocks;
import org.loaders.soul_morphing.blocks.SoulBlockItems;
import org.loaders.soul_morphing.blocks.SoulBlocksEntities;
import org.loaders.soul_morphing.blocks.entities.EternityVaultBlockEntity;
import org.loaders.soul_morphing.blocks.extended.animated.EternityVaultBlockRenderer;
import org.loaders.soul_morphing.misc.SoulCreativeTab;
import org.loaders.soul_morphing.items.SoulItems;
import org.loaders.soul_morphing.util.Souls;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(Soul_morphing.MODID)
public class Soul_morphing {
    public static final String MODID = "soul_morphing";
    private static final Logger LOGGER = LogUtils.getLogger();

    public Soul_morphing(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);

        SoulItems.ITEMS.register(modEventBus);
        SoulBlocks.BLOCKS.register(modEventBus);
        SoulBlockItems.ITEMS.register(modEventBus);
        SoulBlocksEntities.REGISTRY.register(modEventBus);
        SoulCreativeTab.CREATIVE_MODE_TABS.register(modEventBus);
        SoulAttributes.REGISTRY.register(modEventBus);

        NeoForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);

        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");

        if (Config.logDirtBlock) LOGGER.info("DIRT BLOCK >> {}", BuiltInRegistries.BLOCK.getKey(Blocks.DIRT));

        LOGGER.info(Config.magicNumberIntroduction + Config.magicNumber);

        Config.items.forEach((item) -> LOGGER.info("ITEM >> {}", item.toString()));
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    @EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            ItemProperties.register(SoulItems.MIST_AMULET.get(), ResourceLocation.withDefaultNamespace("capable"),
                    (itemStack, clientLevel, livingEntity, i) ->
                            livingEntity != null && (livingEntity.getItemInHand(InteractionHand.MAIN_HAND) == itemStack || livingEntity.getItemInHand(InteractionHand.OFF_HAND) == itemStack) && Souls.getSouls(livingEntity) >= 8 ? 1 : 0);
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
}
