package org.loaders.soul_morphing.blocks;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.loaders.soul_morphing.blocks.entities.EternityVaultBlockEntity;

import java.util.function.Supplier;

import static org.loaders.soul_morphing.Soul_morphing.MODID;

public class SoulBlocksEntities {
    public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, MODID);
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> ETERNITY_VAULT_ENTITY =
            register("eternity_vault_entity", SoulBlocks.ETERNITY_VAULT, EternityVaultBlockEntity::new);

    private static DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> register(String registryname, DeferredHolder<Block, Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
        return REGISTRY.register(registryname, () -> new BlockEntityType<>(supplier, block.get()));
    }
}