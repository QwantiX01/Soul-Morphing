package org.loaders.soul_morphing.misc;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.loaders.soul_morphing.blocks.SoulBlockItems;
import org.loaders.soul_morphing.items.SoulItems;

import java.util.function.Supplier;

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
