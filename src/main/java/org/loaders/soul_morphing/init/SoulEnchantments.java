package org.loaders.soul_morphing.init;

import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.enchantment.Enchantment;

import java.util.Arrays;
import java.util.Optional;

import static org.loaders.soul_morphing.Soul_morphing.MODID;
import static org.loaders.soul_morphing.init.SoulItems.ITEMS;
import static org.loaders.soul_morphing.init.SoulTags.SPIRITIUM_ARMORS;

public class SoulEnchantments {
    public static final ResourceKey<Enchantment> SOUL_DEFORMATION = ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.fromNamespaceAndPath(MODID, "soul_deformation"));
}
