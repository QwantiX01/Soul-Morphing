package org.loaders.soul_morphing.blocks;

import net.minecraft.world.item.BlockItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import static org.loaders.soul_morphing.Soul_morphing.MODID;

public class SoulBlockItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);
    public static final DeferredItem<BlockItem> SOUL_FURNACE = ITEMS.registerSimpleBlockItem(SoulBlocks.SOUL_FURNACE.getDelegate());
    public static final DeferredItem<BlockItem> ETERNITY_VAULT = ITEMS.registerSimpleBlockItem(SoulBlocks.ETERNITY_VAULT.getDelegate());
}
