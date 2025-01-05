package org.loaders.soul_morphing.init;

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
import org.loaders.soul_morphing.entity.custom.CursedSkeletonEntity;
import org.loaders.soul_morphing.entity.custom.SinnerHeavySphereEntity;
import org.loaders.soul_morphing.entity.custom.SinnerLightSphereEntity;

import java.util.function.Supplier;

import static org.loaders.soul_morphing.Soul_morphing.MODID;

@EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD)
public class SoulEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, MODID);
    public static final Supplier<EntityType<? extends CursedSkeletonEntity>> CURSED_SKELETON_ENTITY =
            ENTITY_TYPES.register("cursed_skeleton", () -> EntityType.Builder
                    .of(CursedSkeletonEntity::new, MobCategory.MONSTER)
                    .sized(0.6F, 2.25F)
                    .build(ResourceKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(MODID, "cursed_skeleton"))));


    public static final DeferredHolder<EntityType<?>, EntityType<SinnerLightSphereEntity>> SINNER_LIGHT_SHPERE = register("sinner_light_shpere",
            EntityType.Builder.<SinnerLightSphereEntity>of(SinnerLightSphereEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));

    public static final DeferredHolder<EntityType<?>, EntityType<SinnerHeavySphereEntity>> SINNER_HEAVY_SHPERE = register("sinner_heavy_shpere",
            EntityType.Builder.<SinnerHeavySphereEntity>of(SinnerHeavySphereEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(3f, 3f));

    private static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
        return ENTITY_TYPES.register(registryname, () -> entityTypeBuilder.build(ResourceKey.create(ENTITY_TYPES.getRegistryKey(), ResourceLocation.fromNamespaceAndPath(MODID, registryname))));
    }


    @SubscribeEvent
    public static void registerEntity(EntityAttributeCreationEvent event) {
        event.put(CURSED_SKELETON_ENTITY.get(), CursedSkeletonEntity.createAttributes().build());
    }
}

