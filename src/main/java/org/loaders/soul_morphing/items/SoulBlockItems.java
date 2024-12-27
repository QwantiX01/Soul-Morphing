package org.loaders.soul_morphing.items;

import net.minecraft.core.Holder;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.loaders.soul_morphing.blocks.SoulBlocks;

import java.util.function.Supplier;

import static org.loaders.soul_morphing.Soul_morphing.MODID;

public class SoulBlockItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);
    public static final DeferredItem<BlockItem> SOUL_FURNACE = ITEMS.registerSimpleBlockItem(SoulBlocks.SOUL_FURNACE.getDelegate());
    public static final DeferredItem<BlockItem> ETERNITY_VAULT = ITEMS.registerSimpleBlockItem(SoulBlocks.ETERNITY_VAULT.getDelegate());
}
