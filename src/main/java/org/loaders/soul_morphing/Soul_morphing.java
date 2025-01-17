package org.loaders.soul_morphing;

import net.minecraft.client.renderer.entity.EntityRenderers;
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
import org.loaders.soul_morphing.entity.custom.models.*;
import org.loaders.soul_morphing.entity.custom.renderers.*;
import org.loaders.soul_morphing.init.*;
import org.loaders.soul_morphing.init.data.SoulAttributes;
import org.loaders.soul_morphing.util.Souls;

@Mod(Soul_morphing.MODID)
public class Soul_morphing {
  public static final String MODID = "soul_morphing";

  public Soul_morphing(IEventBus modEventBus, ModContainer modContainer) {
    SoulBlocksEntities.REGISTRY.register(modEventBus);
    SoulBlocks.BLOCKS.register(modEventBus);
    SoulAttributes.REGISTRY.register(modEventBus);
    SoulItems.ITEMS.register(modEventBus);
    SoulMenus.REGISTRY.register(modEventBus);
    SoulCreativeTab.CREATIVE_MODE_TABS.register(modEventBus);
    SoulEntities.ENTITY_TYPES.register(modEventBus);
    SoulParticleTypes.REGISTRY.register(modEventBus);

    NeoForge.EVENT_BUS.register(this);
    modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
  }

  @SubscribeEvent
  public void onServerStarting(ServerStartingEvent event) {}

  @EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
  public static class ClientModEvents {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
      ItemProperties.register(
          SoulItems.MIST_AMULET.get(),
          ResourceLocation.withDefaultNamespace("capable"),
          (itemStack, clientLevel, livingEntity, i) ->
              livingEntity != null
                      && (livingEntity.getItemInHand(InteractionHand.MAIN_HAND) == itemStack
                          || livingEntity.getItemInHand(InteractionHand.OFF_HAND) == itemStack)
                      && Souls.getSouls(livingEntity) >= 8
                  ? 1
                  : 0);

      EntityRenderers.register(
          SoulEntities.CURSED_SKELETON_ENTITY.get(),
          context ->
              new CursedSkeletonRenderer(
                  context,
                  new CursedSkeletonModel<>(context.bakeLayer(CursedSkeletonModel.LAYER_LOCATION)),
                  0.5f));

      EntityRenderers.register(
          SoulEntities.DUNGEON_GOLEM.get(),
          context ->
              new DungeonGolemRenderer(
                  context,
                  new DungeonGolemModel<>(context.bakeLayer(DungeonGolemModel.LAYER_LOCATION)),
                  0.5f));

      EntityRenderers.register(
          SoulEntities.IGNITE_SPIRIT_ENTITY.get(),
          context ->
              new IgniteSpiritRenderer(
                  context,
                  new IgniteSpiritModel<>(context.bakeLayer(IgniteSpiritModel.LAYER_LOCATION)),
                  0.5f));

      EntityRenderers.register(
          SoulEntities.DEVOURER.get(),
          context ->
              new DeevourerRenderer(
                  context,
                  new DeevourerModel<>(context.bakeLayer(DeevourerModel.LAYER_LOCATION)),
                  0.5f));
      EntityRenderers.register(
          SoulEntities.SPIRIT_HOUND.get(),
          context ->
              new SpiritHoundRenderer(
                  context,
                  new SpiritHoundModel<>(context.bakeLayer(SpiritHoundModel.LAYER_LOCATION)),
                  0.5f));
      EntityRenderers.register(
          SoulEntities.HELL_BOAR_ENTITY.get(),
          context ->
              new HellBoarRenderer(
                  context,
                  new HellBoarModel<>(context.bakeLayer(HellBoarModel.LAYER_LOCATION)),
                  0.5f));
      EntityRenderers.register(
          SoulEntities.INFERNAL_BLAZE.get(),
          context ->
              new InfernalBlazeRenderer(
                  context,
                  new InfernalBlazeModel<>(context.bakeLayer(InfernalBlazeModel.LAYER_LOCATION)),
                  0.5f));
    }
  }
}
