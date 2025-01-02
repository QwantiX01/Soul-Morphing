package org.loaders.soul_morphing.init;

import net.minecraft.Util;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.registries.RegisterEvent;

import java.util.EnumMap;
import java.util.List;

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
