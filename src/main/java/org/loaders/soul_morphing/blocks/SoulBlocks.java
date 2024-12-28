package org.loaders.soul_morphing.blocks;

import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.loaders.soul_morphing.blocks.extended.animated.EternityVaultBlock;
import org.loaders.soul_morphing.blocks.extended.SoulFurnaceBlock;

import static org.loaders.soul_morphing.Soul_morphing.MODID;

public class SoulBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);
    public static final DeferredHolder<Block, Block> SOUL_FURNACE = BLOCKS.registerBlock("furnace", props -> new SoulFurnaceBlock());
    public static final DeferredHolder<Block, Block> ETERNITY_VAULT = BLOCKS.register("eternity_vault", EternityVaultBlock::new);

}
