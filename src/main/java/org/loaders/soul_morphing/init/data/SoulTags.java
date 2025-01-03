package org.loaders.soul_morphing.init.data;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

import static org.loaders.soul_morphing.Soul_morphing.MODID;

public class SoulTags {
    public static final TagKey<Item> SPIRITIUM_MATERIALS = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(MODID, "spiritium_materials"));
    public static final TagKey<Item> SPIRITIUM_ARMORS = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(MODID, "spiritium_armor"));
}
