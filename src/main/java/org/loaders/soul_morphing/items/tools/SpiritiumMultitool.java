package org.loaders.soul_morphing.items.tools;

import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.DiggerItem;

import static org.loaders.soul_morphing.Soul_morphing.MODID;
import static org.loaders.soul_morphing.init.SoulBlocks.BLOCKS;
import static org.loaders.soul_morphing.init.SoulItems.ITEMS;
import static org.loaders.soul_morphing.init.ToolMaterials.SPIRITIUM_MATERIAL;

public class SpiritiumMultitool extends DiggerItem {
    public SpiritiumMultitool() {
        super(
                SPIRITIUM_MATERIAL,
                BlockTags.create(ResourceLocation.fromNamespaceAndPath(MODID, "mineable_with_spiritium_materials")),
                0,
                -2.7f,
                new Properties()
                        .setId(ResourceKey.create(ITEMS.getRegistryKey(), ResourceLocation.fromNamespaceAndPath(MODID, "spiritium_multitool"))));
    }
}
