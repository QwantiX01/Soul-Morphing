package org.loaders.soul_morphing.blocks;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static org.loaders.soul_morphing.Soul_morphing.MODID;
import static org.loaders.soul_morphing.init.SoulBlocks.BLOCKS;

public class SpiritiumOreBlock extends Block {
    public SpiritiumOreBlock() {
        super(BlockBehaviour.Properties.of()
                .setId(ResourceKey.create(BLOCKS.getRegistryKey(), ResourceLocation.fromNamespaceAndPath(MODID, "spiritium_ore")))
                .destroyTime(Blocks.END_STONE.defaultDestroyTime())
        );
    }


}
