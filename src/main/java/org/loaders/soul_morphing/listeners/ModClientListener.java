package org.loaders.soul_morphing.listeners;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.tick.LevelTickEvent;
import org.loaders.soul_morphing.blocks.animated.entity.VoidFurnaceBlockEntity;
import org.loaders.soul_morphing.blocks.animated.renderer.VoidFurnaceBlockRenderer;
import org.loaders.soul_morphing.entity.custom.models.CursedSkeletonModel;
import org.loaders.soul_morphing.init.SoulBlocksEntities;
import org.loaders.soul_morphing.blocks.animated.entity.EternityVaultBlockEntity;
import org.loaders.soul_morphing.blocks.animated.renderer.EternityVaultBlockRenderer;
import org.loaders.soul_morphing.util.Souls;

import java.util.UUID;

import static org.loaders.soul_morphing.Soul_morphing.MODID;
import static org.loaders.soul_morphing.util.Souls.getTotalBonus;

@EventBusSubscriber(modid = MODID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public class ModClientListener {
    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer((BlockEntityType<EternityVaultBlockEntity>) SoulBlocksEntities.ETERNITY_VAULT_ENTITY.get(), context -> new EternityVaultBlockRenderer());
        event.registerBlockEntityRenderer((BlockEntityType<VoidFurnaceBlockEntity>) SoulBlocksEntities.VOID_FURNACE_ENTITY.get(), context -> new VoidFurnaceBlockRenderer());
    }

    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(CursedSkeletonModel.LAYER_LOCATION, CursedSkeletonModel::createBodyLayer);
    }


}
