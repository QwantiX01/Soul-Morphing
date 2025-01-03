package org.loaders.soul_morphing.items.tools;

import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.SwordItem;

import static org.loaders.soul_morphing.Soul_morphing.MODID;
import static org.loaders.soul_morphing.init.SoulItems.ITEMS;
import static org.loaders.soul_morphing.init.data.ToolMaterials.SPIRITIUM_MATERIAL;


public class SoulMorphist extends SwordItem {

    public SoulMorphist() {
        super(SPIRITIUM_MATERIAL, 1, 1,
                new Properties()
                        .setId(ResourceKey.create(ITEMS.getRegistryKey(), ResourceLocation.fromNamespaceAndPath(MODID, "soul_morphist")))
        );
    }

}
