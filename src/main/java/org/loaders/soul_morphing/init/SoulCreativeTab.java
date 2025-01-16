package org.loaders.soul_morphing.init;

import static org.loaders.soul_morphing.Soul_morphing.MODID;

import java.util.function.Supplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredRegister;

public class SoulCreativeTab {
  public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
      DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

  @SuppressWarnings("unused")
  private static final Supplier<CreativeModeTab> SOUL_CREATIVE_TAB =
      CREATIVE_MODE_TABS.register(
          "soul_morphing_tab",
          () ->
              CreativeModeTab.builder()
                  .title(Component.translatable("itemGroup." + MODID + ".soul_morphing_tab"))
                  .icon(() -> new ItemStack(SoulItems.SPIRITIUM_INGOT.get()))
                  .displayItems(
                      (itemDisplayParameters, output) -> {
                        for (var item : SoulItems.ITEMS.getEntries()) output.accept(item.get());
                      })
                  .build());
}
