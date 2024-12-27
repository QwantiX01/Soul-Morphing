package org.loaders.soul_morphing.items;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

import static org.loaders.soul_morphing.Soul_morphing.MODID;

public class SoulTags {
    public static final TagKey<Block> SOUL_INGOTS = BlockTags.create(ResourceLocation.fromNamespaceAndPath(MODID, "tags/item/soul_ingots"));
}
