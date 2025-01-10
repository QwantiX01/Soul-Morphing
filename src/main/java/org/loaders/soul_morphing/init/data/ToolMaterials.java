package org.loaders.soul_morphing.init.data;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.ToolMaterial;

import static org.loaders.soul_morphing.Soul_morphing.MODID;
import static org.loaders.soul_morphing.init.data.SoulTags.SPIRITIUM_MATERIALS;

public class ToolMaterials {
    public static final ToolMaterial SPIRITIUM_MATERIAL = new ToolMaterial(
            BlockTags.create(ResourceLocation.fromNamespaceAndPath(MODID, "incompatible_with_spiritium_materials")),
            1942,
            10f,
            6f,
            16,
            SPIRITIUM_MATERIALS
    );

    public static final ToolMaterial WITHERING_MATERIAL = new ToolMaterial(
            BlockTags.create(ResourceLocation.fromNamespaceAndPath(MODID, "incompatible_with_spiritium_materials")),
            2742,
            10f,
            8f,
            16,
            SPIRITIUM_MATERIALS
    );
}
