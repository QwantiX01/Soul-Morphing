package org.loaders.soul_morphing.init;

import static org.loaders.soul_morphing.Soul_morphing.MODID;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.loaders.soul_morphing.util.SoulBlock;
import org.loaders.soul_morphing.util.SoulMaterial;
import org.loaders.soul_morphing.util.SoulTool;

public class SoulCreativeTab {
  SoulCreativeTab() {}

  public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
      DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

  @SuppressWarnings({"unused", "unchecked"})
  private static final Supplier<CreativeModeTab> SOUL_CREATIVE_TAB_MATERIALS =
      CREATIVE_MODE_TABS.register(
          "soul_morphing_materials",
          () ->
              CreativeModeTab.builder()
                  .title(Component.translatable("itemGroup." + MODID + ".soul_morphing_materials"))
                  .icon(() -> new ItemStack(SoulItems.SINISTER_CORE.get()))
                  .displayItems(
                      (itemDisplayParameters, output) -> {
                        List<Field> fieldsWithSoulBlock =
                            Arrays.stream(SoulItems.class.getDeclaredFields())
                                .filter(
                                    field ->
                                        field.isAnnotationPresent(SoulMaterial.class)
                                            && java.lang.reflect.Modifier.isStatic(
                                                field.getModifiers()))
                                .toList();

                        for (var field : fieldsWithSoulBlock) {
                          try {
                            Item item = ((DeferredHolder<Item, Item>) field.get(null)).get();
                            output.accept(item);
                          } catch (IllegalAccessException ignored) {
                              assert false;
                          }
                        }
                      })
                  .build());

  @SuppressWarnings("unchecked")
  private static final Supplier<CreativeModeTab> SOUL_CREATIVE_TAB_TOOLS =
      CREATIVE_MODE_TABS.register(
          "soul_morphing_tools",
          () ->
              CreativeModeTab.builder()
                  .title(Component.translatable("itemGroup." + MODID + ".soul_morphing_tools"))
                  .icon(() -> new ItemStack(SoulItems.WITHERING_SWORD.get()))
                  .displayItems(
                      (itemDisplayParameters, output) -> {
                        List<Field> fieldsWithSoulBlock =
                            Arrays.stream(SoulItems.class.getDeclaredFields())
                                .filter(
                                    field ->
                                        field.isAnnotationPresent(SoulTool.class)
                                            && Modifier.isStatic(field.getModifiers()))
                                .toList();

                        for (var field : fieldsWithSoulBlock) {
                          try {
                            Item item = ((DeferredHolder<Item, Item>) field.get(null)).get();
                            output.accept(item);
                          } catch (IllegalAccessException ignored) {
                              assert false;
                          }
                        }
                      })
                  .build());

  @SuppressWarnings("unchecked")
  private static final Supplier<CreativeModeTab> SOUL_CREATIVE_TAB_BLOCKS =
      CREATIVE_MODE_TABS.register(
          "soul_morphing_blocks",
          () ->
              CreativeModeTab.builder()
                  .title(Component.translatable("itemGroup." + MODID + ".soul_morphing_blocks"))
                  .icon(() -> new ItemStack(SoulItems.ETERNITY_VAULT.get()))
                  .displayItems(
                      (itemDisplayParameters, output) -> {
                        List<Field> fieldsWithSoulBlock =
                            Arrays.stream(SoulItems.class.getDeclaredFields())
                                .filter(
                                    field ->
                                        field.isAnnotationPresent(SoulBlock.class)
                                            && Modifier.isStatic(field.getModifiers()))
                                .toList();

                        for (var field : fieldsWithSoulBlock) {
                          try {
                            Item item = ((DeferredHolder<Item, Item>) field.get(null)).get();
                            output.accept(item);
                          } catch (IllegalAccessException ignored) {
                              assert false;
                          }
                        }
                      })
                  .build());
}
