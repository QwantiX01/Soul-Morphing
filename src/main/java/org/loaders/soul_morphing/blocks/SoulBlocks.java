package org.loaders.soul_morphing.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FurnaceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Properties;

import static org.loaders.soul_morphing.Soul_morphing.MODID;

public class SoulBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);
    public static final DeferredHolder<Block, Block> SOUL_FURNACE = BLOCKS.registerBlock("furnace", props -> new SoulFurnaceBlock());
    public static final DeferredHolder<Block, Block> ETERNITY_VAULT = BLOCKS.registerBlock("eternity_vault", props -> new EternityVault());

}
