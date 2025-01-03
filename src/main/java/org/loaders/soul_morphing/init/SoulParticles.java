package org.loaders.soul_morphing.init;

import net.minecraft.client.particle.SoulParticle;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.loaders.soul_morphing.particles.MistParticle;

import java.util.function.Supplier;

import static org.loaders.soul_morphing.Soul_morphing.MODID;


@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class SoulParticles {
    @SubscribeEvent
    public static void registerParticles(RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(SoulParticleTypes.MIST_PARTICLE.get(), MistParticle::provider);
    }
}
