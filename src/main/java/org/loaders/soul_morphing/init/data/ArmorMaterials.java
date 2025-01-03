package org.loaders.soul_morphing.init.data;

import net.minecraft.Util;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;

import java.util.EnumMap;

import static org.loaders.soul_morphing.Soul_morphing.MODID;

public class ArmorMaterials  {
    public static final ArmorMaterial SPIRITIUM_ARMOR_MATERIAL = new ArmorMaterial(
            15,
            Util.make(new EnumMap<>(ArmorType.class), map -> {
                map.put(ArmorType.BOOTS, 2);
                map.put(ArmorType.LEGGINGS, 4);
                map.put(ArmorType.CHESTPLATE, 6);
                map.put(ArmorType.HELMET, 2);
            }),
            10,
            SoundEvents.ARMOR_EQUIP_GENERIC,
            3,
            0.1F,
            SoulTags.SPIRITIUM_MATERIALS,
            ResourceLocation.fromNamespaceAndPath(MODID, "spiritium")
    );
}
