package org.loaders.soul_morphing.items.armor;

import static org.loaders.soul_morphing.Soul_morphing.MODID;
import static org.loaders.soul_morphing.init.SoulItems.ITEMS;
import static org.loaders.soul_morphing.init.data.ArmorMaterials.SPIRITIUM_ARMOR_MATERIAL;

import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.equipment.ArmorType;

public class SpiritiumChestplate extends ArmorItem {
  public SpiritiumChestplate(Properties properties) {
    super(
        SPIRITIUM_ARMOR_MATERIAL,
        ArmorType.CHESTPLATE,
        properties.setId(
            ResourceKey.create(
                ITEMS.getRegistryKey(),
                ResourceLocation.fromNamespaceAndPath(MODID, "spiritium_chestplate"))));
  }
}
