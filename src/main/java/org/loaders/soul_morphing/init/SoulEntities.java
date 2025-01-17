package org.loaders.soul_morphing.init;

import static org.loaders.soul_morphing.Soul_morphing.MODID;

import java.util.function.Supplier;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.loaders.soul_morphing.entity.custom.*;

@EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD)
public class SoulEntities {
  public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
      DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, MODID);

  public static final Supplier<EntityType<? extends CursedSkeletonEntity>> CURSED_SKELETON_ENTITY =
      ENTITY_TYPES.register(
          "cursed_skeleton",
          () ->
              EntityType.Builder.of(CursedSkeletonEntity::new, MobCategory.MONSTER)
                  .sized(0.6F, 2.25F)
                  .build(
                      ResourceKey.create(
                          Registries.ENTITY_TYPE,
                          ResourceLocation.fromNamespaceAndPath(MODID, "cursed_skeleton"))));

  public static final Supplier<EntityType<? extends DungeonGolemEntity>> DUNGEON_GOLEM =
      ENTITY_TYPES.register(
          "dungeon_golem",
          () ->
              EntityType.Builder.of(DungeonGolemEntity::new, MobCategory.MONSTER)
                  .sized(0.6F, 2.25F)
                  .build(
                      ResourceKey.create(
                          Registries.ENTITY_TYPE,
                          ResourceLocation.fromNamespaceAndPath(MODID, "dungeon_golem"))));

  public static final Supplier<EntityType<? extends HellBoarEntity>> HELL_BOAR_ENTITY =
      ENTITY_TYPES.register(
          "hellboar",
          () ->
              EntityType.Builder.of(HellBoarEntity::new, MobCategory.MONSTER)
                  .sized(0.6F, 2.25F)
                  .build(
                      ResourceKey.create(
                          Registries.ENTITY_TYPE,
                          ResourceLocation.fromNamespaceAndPath(MODID, "hellboar"))));

  public static final Supplier<EntityType<? extends IgniteSpiritEntity>> IGNITE_SPIRIT_ENTITY =
      ENTITY_TYPES.register(
          "ignite_spirit",
          () ->
              EntityType.Builder.of(IgniteSpiritEntity::new, MobCategory.MONSTER)
                  .sized(0.6F, 2.25F)
                  .build(
                      ResourceKey.create(
                          Registries.ENTITY_TYPE,
                          ResourceLocation.fromNamespaceAndPath(MODID, "ignite_spirit"))));

  public static final Supplier<EntityType<? extends DeevourerEntity>> DEVOURER =
      ENTITY_TYPES.register(
          "deevourer",
          () ->
              EntityType.Builder.of(DeevourerEntity::new, MobCategory.MONSTER)
                  .sized(0.6F, 2.25F)
                  .build(
                      ResourceKey.create(
                          Registries.ENTITY_TYPE,
                          ResourceLocation.fromNamespaceAndPath(MODID, "deevourer"))));

  public static final Supplier<EntityType<? extends InfernalBlazeEntity>> INFERNAL_BLAZE =
      ENTITY_TYPES.register(
          "infernal_blaze",
          () ->
              EntityType.Builder.of(InfernalBlazeEntity::new, MobCategory.MONSTER)
                  .sized(1.5F, 2.60F)
                  .build(
                      ResourceKey.create(
                          Registries.ENTITY_TYPE,
                          ResourceLocation.fromNamespaceAndPath(MODID, "infernal_blaze"))));

  public static final DeferredHolder<EntityType<?>, EntityType<SinnerLightSphereEntity>>
      SINNER_LIGHT_SHPERE =
          register(
              "sinner_light_shpere",
              EntityType.Builder.<SinnerLightSphereEntity>of(
                      SinnerLightSphereEntity::new, MobCategory.MISC)
                  .setShouldReceiveVelocityUpdates(true)
                  .setTrackingRange(64)
                  .setUpdateInterval(1)
                  .sized(0.5f, 0.5f));

  public static final DeferredHolder<EntityType<?>, EntityType<SinnerHeavySphereEntity>>
      SINNER_HEAVY_SHPERE =
          register(
              "sinner_heavy_shpere",
              EntityType.Builder.<SinnerHeavySphereEntity>of(
                      SinnerHeavySphereEntity::new, MobCategory.MISC)
                  .setShouldReceiveVelocityUpdates(true)
                  .setTrackingRange(64)
                  .setUpdateInterval(1)
                  .sized(3f, 3f));

  public static final Supplier<EntityType<? extends SpiritHoundEntity>> SPIRIT_HOUND =
      ENTITY_TYPES.register(
          "spirit_hound",
          () ->
              EntityType.Builder.of(SpiritHoundEntity::new, MobCategory.MONSTER)
                  .sized(0.6F, 2.25F)
                  .build(
                      ResourceKey.create(
                          Registries.ENTITY_TYPE,
                          ResourceLocation.fromNamespaceAndPath(MODID, "spirit_hound"))));

  private static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> register(
      String registryname, EntityType.Builder<T> entityTypeBuilder) {
    return ENTITY_TYPES.register(
        registryname,
        () ->
            entityTypeBuilder.build(
                ResourceKey.create(
                    ENTITY_TYPES.getRegistryKey(),
                    ResourceLocation.fromNamespaceAndPath(MODID, registryname))));
  }

  @SubscribeEvent
  public static void registerEntity(EntityAttributeCreationEvent event) {
    event.put(CURSED_SKELETON_ENTITY.get(), CursedSkeletonEntity.createAttributes().build());
    event.put(IGNITE_SPIRIT_ENTITY.get(), IgniteSpiritEntity.createAttributes().build());
    event.put(DEVOURER.get(), DeevourerEntity.createAttributes().build());
    event.put(SPIRIT_HOUND.get(), DeevourerEntity.createAttributes().build());
    event.put(HELL_BOAR_ENTITY.get(), HellBoarEntity.createAttributes().build());
    event.put(INFERNAL_BLAZE.get(), InfernalBlazeEntity.createAttributes().build());
    event.put(DUNGEON_GOLEM.get(), DungeonGolemEntity.createAttributes().build());
  }
}
