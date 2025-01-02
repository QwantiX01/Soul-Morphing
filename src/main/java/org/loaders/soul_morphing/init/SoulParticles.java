package org.loaders.soul_morphing.init;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static org.loaders.soul_morphing.Soul_morphing.MODID;

public class SoulParticles {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES =
            DeferredRegister.create(BuiltInRegistries.PARTICLE_TYPE, MODID);

    public static final Supplier<SimpleParticleType> MIST_PARTICLE = PARTICLE_TYPES.register(
            "mist_particle",
            () -> new SimpleParticleType(false)
    );
}
