package org.loaders.soul_morphing.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.loaders.soul_morphing.blocks.SpiritiumOreBlock;
import org.loaders.soul_morphing.blocks.animated.EternityVaultBlock;
import org.loaders.soul_morphing.blocks.animated.VoidFurnaceBlock;

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

    // ========================================== DUNGEON BLOCKS =======================================================

    public static final DeferredHolder<Block, Block> SHATTERED_DUNGEON_BRICK = BLOCKS.registerSimpleBlock("shattered_dungeon_brick", BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(MODID, "shattered_dungeon_brick"))));


    public static final DeferredHolder<Block, LeavesBlock> DUNGEON_LEAVES = BLOCKS.registerBlock(
            "dungeon_leaves",
            poop -> new LeavesBlock(
                    BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)
                            .destroyTime(-1)
                            .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(MODID, "dungeon_leaves")))
            )
    );

    public static final DeferredHolder<Block, LanternBlock> DUNGEON_SOUL_LANTERN = BLOCKS.registerBlock(
            "dungeon_soul_lantern",
            poop -> new LanternBlock(
                    BlockBehaviour.Properties.ofFullCopy(Blocks.LANTERN)
                            .mapColor(MapColor.METAL)
                            .forceSolidOn()
                            .requiresCorrectToolForDrops()
                            .strength(3.5F)
                            .sound(SoundType.LANTERN)
                            .lightLevel(p_50804_ -> 10)
                            .noOcclusion()
                            .pushReaction(PushReaction.DESTROY)
                            .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(MODID, "dungeon_soul_lantern")))
            )
    );

    public static final DeferredHolder<Block, Block> DUNGEON_LAMP = BLOCKS.registerSimpleBlock(
            "dungeon_lamp",
            BlockBehaviour.Properties.of()
                    .destroyTime(-1)
                    .lightLevel(value -> 15)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(MODID, "dungeon_lamp")))
    );

    public static final DeferredHolder<Block, Block> DUNGEON_BRICK2 = BLOCKS.registerSimpleBlock(
            "dungeon_brick2",
            BlockBehaviour.Properties.of()
                    .destroyTime(-1)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(MODID, "dungeon_brick2")))
    );

    public static final DeferredHolder<Block, Block> DUNGEON_BRICK = BLOCKS.registerSimpleBlock(
            "dungeon_brick",
            BlockBehaviour.Properties.of()
                    .destroyTime(-1)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(MODID, "dungeon_brick")))
    );

    public static final DeferredHolder<Block, Block> DUNGEON_BOTTOM = BLOCKS.registerSimpleBlock(
            "dungeon_bottom",
            BlockBehaviour.Properties.of()
                    .destroyTime(-1)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(MODID, "dungeon_bottom")))
    );


}
