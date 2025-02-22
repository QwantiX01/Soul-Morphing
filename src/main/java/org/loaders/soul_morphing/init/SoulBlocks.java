package org.loaders.soul_morphing.init;

import static org.loaders.soul_morphing.Soul_morphing.MODID;

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

  public static final DeferredHolder<Block, Block> DAUNGEON_CRYSTAL3 =
      BLOCKS.registerSimpleBlock(
          "daungeon_crystal3",
          BlockBehaviour.Properties.of()
              .setId(
                  ResourceKey.create(
                      Registries.BLOCK,
                      ResourceLocation.fromNamespaceAndPath(MODID, "daungeon_crystal3"))));

  public static final DeferredHolder<Block, Block> DUNGEON_CRYSTAL =
      BLOCKS.registerSimpleBlock(
          "dungeon_crystal",
          BlockBehaviour.Properties.of()
              .setId(
                  ResourceKey.create(
                      Registries.BLOCK,
                      ResourceLocation.fromNamespaceAndPath(MODID, "dungeon_crystal"))));

  public static final DeferredHolder<Block, Block> DUNGEON_CRYSTAL2 =
      BLOCKS.registerSimpleBlock(
          "dungeon_crystal2",
          BlockBehaviour.Properties.of()
              .setId(
                  ResourceKey.create(
                      Registries.BLOCK,
                      ResourceLocation.fromNamespaceAndPath(MODID, "dungeon_crystal2"))));

  public static final DeferredHolder<Block, Block> DUNGEON_CRYSTAL4PNG =
      BLOCKS.registerSimpleBlock(
          "dungeon_crystal4png",
          BlockBehaviour.Properties.of()
              .setId(
                  ResourceKey.create(
                      Registries.BLOCK,
                      ResourceLocation.fromNamespaceAndPath(MODID, "dungeon_crystal4png"))));

  public static final DeferredHolder<Block, Block> DUNGEON_CRYSTAL5PNG =
      BLOCKS.registerSimpleBlock(
          "dungeon_crystal5png",
          BlockBehaviour.Properties.of()
              .setId(
                  ResourceKey.create(
                      Registries.BLOCK,
                      ResourceLocation.fromNamespaceAndPath(MODID, "dungeon_crystal5png"))));

  public static final DeferredHolder<Block, Block> DUNGEON_DARK_MARBLE =
      BLOCKS.registerSimpleBlock(
          "dungeon_dark_marble",
          BlockBehaviour.Properties.of()
              .setId(
                  ResourceKey.create(
                      Registries.BLOCK,
                      ResourceLocation.fromNamespaceAndPath(MODID, "dungeon_dark_marble"))));

  public static final DeferredHolder<Block, Block> DUNGEON_DARK_MARBLE2 =
      BLOCKS.registerSimpleBlock(
          "dungeon_dark_marble2",
          BlockBehaviour.Properties.of()
              .setId(
                  ResourceKey.create(
                      Registries.BLOCK,
                      ResourceLocation.fromNamespaceAndPath(MODID, "dungeon_dark_marble2"))));

  public static final DeferredHolder<Block, Block> DUNGEON_PURPLE_LIGHT_MARBLE =
      BLOCKS.registerSimpleBlock(
          "dungeon_purple_light_marble",
          BlockBehaviour.Properties.of()
              .setId(
                  ResourceKey.create(
                      Registries.BLOCK,
                      ResourceLocation.fromNamespaceAndPath(
                          MODID, "dungeon_purple_light_marble"))));

  public static final DeferredHolder<Block, Block> DUNGEON_ROCK =
      BLOCKS.registerSimpleBlock(
          "dungeon_rock",
          BlockBehaviour.Properties.of()
              .setId(
                  ResourceKey.create(
                      Registries.BLOCK,
                      ResourceLocation.fromNamespaceAndPath(MODID, "dungeon_rock"))));

  public static final DeferredHolder<Block, Block> DUNGEON_TERRACOTTA =
      BLOCKS.registerSimpleBlock(
          "dungeon_terracotta",
          BlockBehaviour.Properties.of()
              .setId(
                  ResourceKey.create(
                      Registries.BLOCK,
                      ResourceLocation.fromNamespaceAndPath(MODID, "dungeon_terracotta"))));
}
