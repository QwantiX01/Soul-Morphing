package org.loaders.soul_morphing.init;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static org.loaders.soul_morphing.Soul_morphing.MODID;

public class SoulParticleTypes {
    public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(Registries.PARTICLE_TYPE, MODID);
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> MIST_PARTICLE = REGISTRY.register("mist_particle", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> SINN_H_PARTICLE = REGISTRY.register("sinn_h_particle", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> SINN_L_PARTICLE = REGISTRY.register("sinn_l_particle", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> WITHERING_PARTICLE = REGISTRY.register("withering_particle", () -> new SimpleParticleType(false));
}
