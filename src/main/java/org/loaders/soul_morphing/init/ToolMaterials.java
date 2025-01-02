package org.loaders.soul_morphing.init;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.ToolMaterial;

import static org.loaders.soul_morphing.Soul_morphing.MODID;
import static org.loaders.soul_morphing.init.SoulTags.SPIRITIUM_MATERIALS;

public class ToolMaterials {
    public static final ToolMaterial SPIRITIUM_MATERIAL = new ToolMaterial(
            BlockTags.create(ResourceLocation.fromNamespaceAndPath(MODID, "incompatible_with_spiritium_materials")),
            1942,
            10f,
            6f,
            16,
            SPIRITIUM_MATERIALS
    );
}
