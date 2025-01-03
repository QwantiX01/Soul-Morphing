package org.loaders.soul_morphing.items.armor;

import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.equipment.ArmorType;

import static org.loaders.soul_morphing.Soul_morphing.MODID;
import static org.loaders.soul_morphing.init.ArmorMaterials.SPIRITIUM_ARMOR_MATERIAL;
import static org.loaders.soul_morphing.init.SoulEnchantments.SOUL_DEFORMATION;
import static org.loaders.soul_morphing.init.SoulEnchantments.SOUL_REGENERATION;
import static org.loaders.soul_morphing.init.SoulItems.ITEMS;

public class SpiritiumBoots extends ArmorItem {
    public SpiritiumBoots(Properties properties) {
        super(SPIRITIUM_ARMOR_MATERIAL, ArmorType.BOOTS,
                properties.setId(ResourceKey.create(ITEMS.getRegistryKey(),
                        ResourceLocation.fromNamespaceAndPath(MODID, "spiritium_boots"))));
    }

    public static int getSoulsBonus(ItemStack stack){
        int enchantmentLevel = stack.getEnchantmentLevel(Minecraft.getInstance().level.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(SOUL_DEFORMATION));
        return 4 + enchantmentLevel;
    }

    public static int getSoulsRegeneration(ItemStack stack) {
        int enchantmentLevel = stack.getEnchantmentLevel(Minecraft.getInstance().level.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(SOUL_REGENERATION));
        return enchantmentLevel;
    }
}