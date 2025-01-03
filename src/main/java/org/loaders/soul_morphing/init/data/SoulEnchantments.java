package org.loaders.soul_morphing.init.data;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.enchantment.Enchantment;

import static org.loaders.soul_morphing.Soul_morphing.MODID;

public class SoulEnchantments {
    public static final ResourceKey<Enchantment> SOUL_DEFORMATION = ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.fromNamespaceAndPath(MODID, "soul_deformation"));
    public static final ResourceKey<Enchantment> SOUL_REGENERATION = ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.fromNamespaceAndPath(MODID, "soul_regeneration"));
}
