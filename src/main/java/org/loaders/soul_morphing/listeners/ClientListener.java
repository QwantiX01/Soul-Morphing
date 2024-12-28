package org.loaders.soul_morphing.listeners;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import org.loaders.soul_morphing.blocks.SoulBlocksEntities;
import org.loaders.soul_morphing.blocks.entities.EternityVaultBlockEntity;
import org.loaders.soul_morphing.blocks.extended.animated.EternityVaultBlockRenderer;

import static org.loaders.soul_morphing.Soul_morphing.MODID;

@EventBusSubscriber(modid = MODID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public class ClientListener {
    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer((BlockEntityType<EternityVaultBlockEntity>) SoulBlocksEntities.ETERNITY_VAULT_ENTITY.get(), context -> new EternityVaultBlockRenderer());
    }
}
