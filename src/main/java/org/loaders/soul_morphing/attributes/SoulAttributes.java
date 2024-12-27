package org.loaders.soul_morphing.attributes;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.DefaultAttributes;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeModificationEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.stream.Stream;

import static org.loaders.soul_morphing.Soul_morphing.MODID;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)

public class SoulAttributes {
    public static final DeferredRegister<Attribute> REGISTRY = DeferredRegister.create(BuiltInRegistries.ATTRIBUTE, MODID);
    public static final DeferredHolder<Attribute, Attribute> SOULS_COUNT = REGISTRY.register("souls_count", () -> new RangedAttribute("attribute.soul_morphing.souls_count`", 20, 0, Double.MAX_VALUE).setSyncable(true));
    public static final DeferredHolder<Attribute, Attribute> MAX_SOULS_COUNT = REGISTRY.register("max_souls_count", () -> new RangedAttribute("attribute.soul_morphing.souls_count`", 20, 0, Double.MAX_VALUE).setSyncable(true));

    @SubscribeEvent
    public static void addAttributes(EntityAttributeModificationEvent event) {
        Stream.of(EntityType.ALLAY).filter(DefaultAttributes::hasSupplier).map(entityType -> (EntityType<? extends LivingEntity>) entityType).toList().forEach(entity -> {
            event.add(entity, SOULS_COUNT);
            event.add(entity, MAX_SOULS_COUNT);
        });

        event.add(EntityType.PLAYER, SOULS_COUNT);
        event.add(EntityType.PLAYER, MAX_SOULS_COUNT);
    }

}
