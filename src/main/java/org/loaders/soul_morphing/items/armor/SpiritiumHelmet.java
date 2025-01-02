package org.loaders.soul_morphing.items.armor;

import net.minecraft.client.Minecraft;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.vehicle.Minecart;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import net.minecraft.world.item.equipment.ArmorType;

import static org.loaders.soul_morphing.Soul_morphing.MODID;
import static org.loaders.soul_morphing.init.ArmorMaterials.SPIRITIUM_ARMOR_MATERIAL;
import static org.loaders.soul_morphing.init.SoulEnchantments.SOUL_DEFORMATION;
import static org.loaders.soul_morphing.init.SoulItems.ITEMS;

public class SpiritiumHelmet extends ArmorItem {
    public SpiritiumHelmet(Properties properties) {
        super(SPIRITIUM_ARMOR_MATERIAL, ArmorType.HELMET,
                properties.setId(ResourceKey.create(ITEMS.getRegistryKey(),
                        ResourceLocation.fromNamespaceAndPath(MODID, "spiritium_helmet"))));
    }

    public static int getSoulsBonus(ItemStack stack) {
        int enchantmentLevel = stack.getEnchantmentLevel(Minecraft.getInstance().level.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(SOUL_DEFORMATION));
        return 6 + enchantmentLevel;
    }
}