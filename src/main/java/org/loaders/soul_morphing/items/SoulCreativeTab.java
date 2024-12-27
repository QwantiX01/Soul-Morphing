package org.loaders.soul_morphing.items;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Arrays;
import java.util.function.Supplier;

import static net.neoforged.neoforge.internal.versions.neoforge.NeoForgeVersion.MOD_ID;
import static org.loaders.soul_morphing.Soul_morphing.MODID;

public class SoulCreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);
    private static final Supplier<CreativeModeTab> SOUL_CREATIVE_TAB = CREATIVE_MODE_TABS.register("soul_morphing_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup." + MODID + ".soul_morphing_tab"))
            .icon(() -> new ItemStack(SoulItems.SOUL_INGOT.get()))
            .displayItems((itemDisplayParameters, output) -> {
                for (var item : SoulItems.ITEMS.getEntries())
                    output.accept(item.get());
                for (var item : SoulBlockItems.ITEMS.getEntries())
                    output.accept(item.get());
            })
            .build());

    public SoulCreativeTab() {


    }

}
