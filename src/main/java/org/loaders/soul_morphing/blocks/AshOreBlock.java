package org.loaders.soul_morphing.blocks;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import static org.loaders.soul_morphing.Soul_morphing.MODID;

public class AshOreBlock extends Block {
    public AshOreBlock() {
        super(Properties.of()
                .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(MODID, "ash_ore")))
                .destroyTime(Blocks.ANCIENT_DEBRIS.defaultDestroyTime())
        );
    }
}
