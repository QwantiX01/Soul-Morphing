package org.loaders.soul_morphing.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.loaders.soul_morphing.blocks.SpiritiumOreBlock;
import org.loaders.soul_morphing.blocks.animated.EternityVaultBlock;
import org.loaders.soul_morphing.blocks.animated.VoidFurnaceBlock;

import javax.swing.*;

import static org.loaders.soul_morphing.Soul_morphing.MODID;

public class SoulBlocks {
    // ============================================== REGISTRY =========================================================

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);


    // ========================================== FUNCTIONAL BLOCKS ====================================================

    public static final DeferredHolder<Block, Block> VOID_FURNACE = BLOCKS.register("void_furnace", VoidFurnaceBlock::new);
    public static final DeferredHolder<Block, Block> ETERNITY_VAULT = BLOCKS.register("eternity_vault", EternityVaultBlock::new);

    // ================================================= ORES ==========================================================

    public static final DeferredHolder<Block, Block> SPIRITIUM_ORE = BLOCKS.register("spiritium_ore", SpiritiumOreBlock::new);
    public static final DeferredHolder<Block, Block> ASH_ORE = BLOCKS.registerSimpleBlock("ash_ore", BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(MODID, "ash_ore"))));
    public static final DeferredHolder<Block, Block> SPIRITIUM_BLOCK = BLOCKS.registerSimpleBlock("spiritium_block", BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(MODID, "spiritium_block"))));
    public static final DeferredHolder<Block, Block> ASH_BLOCK = BLOCKS.registerSimpleBlock("ash_block", BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(MODID, "ash_block"))));

}
