package org.loaders.soul_morphing.init;

import static org.loaders.soul_morphing.Soul_morphing.MODID;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.loaders.soul_morphing.blocks.animated.entity.EternityVaultBlockEntity;
import org.loaders.soul_morphing.blocks.animated.entity.VoidFurnaceBlockEntity;

public class SoulBlocksEntities {
  public static final DeferredRegister<BlockEntityType<?>> REGISTRY =
      DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, MODID);

  public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<EternityVaultBlockEntity>>
      ETERNITY_VAULT_ENTITY =
          REGISTRY.register(
              "eternity_vault_entity",
              () ->
                  new BlockEntityType<EternityVaultBlockEntity>(
                      EternityVaultBlockEntity::new, SoulBlocks.ETERNITY_VAULT.get()));

  public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<VoidFurnaceBlockEntity>>
      VOID_FURNACE_ENTITY =
          REGISTRY.register(
              "void_furnace_entity",
              () ->
                  new BlockEntityType<VoidFurnaceBlockEntity>(
                      VoidFurnaceBlockEntity::new, SoulBlocks.VOID_FURNACE.get()));
}
