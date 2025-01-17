package org.loaders.soul_morphing.init;

import static org.loaders.soul_morphing.Soul_morphing.MODID;
import static org.loaders.soul_morphing.init.data.ToolMaterials.SPIRITIUM_MATERIAL;

import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.loaders.soul_morphing.blocks.animated.display.EternityVaultDisplayItem;
import org.loaders.soul_morphing.blocks.animated.display.VoidFurnaceDisplayItem;
import org.loaders.soul_morphing.items.*;
import org.loaders.soul_morphing.items.armor.SpiritiumBoots;
import org.loaders.soul_morphing.items.armor.SpiritiumChestplate;
import org.loaders.soul_morphing.items.armor.SpiritiumHelmet;
import org.loaders.soul_morphing.items.armor.SpiritiumLeggings;
import org.loaders.soul_morphing.items.tools.SoulMorphist;
import org.loaders.soul_morphing.items.tools.SpiritiumMultitool;
import org.loaders.soul_morphing.items.tools.WitheringSword;
import org.loaders.soul_morphing.util.SoulBlock;
import org.loaders.soul_morphing.util.SoulMaterial;
import org.loaders.soul_morphing.util.SoulTool;

public class SoulItems {
    // =============================================== REGISTRY ========================================================

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);

    private static DeferredHolder<Item, Item> registerItem(final String id) {
        return ITEMS.registerItem(id, properties -> new Item(properties.setId(ResourceKey.create(ITEMS.getRegistryKey(), ResourceLocation.fromNamespaceAndPath(MODID, id)))));
    }

  // ============================================== MATERIALS
  @SoulMaterial
  public static final DeferredItem<BlockItem> SPIRITIUM_ORE =
      ITEMS.registerSimpleBlockItem(
          "spiritium_ore", SoulBlocks.SPIRITIUM_ORE, new Item.Properties());

  @SoulMaterial
  public static final DeferredItem<BlockItem> SPIRITIUM_BLOCK =
      ITEMS.registerSimpleBlockItem(SoulBlocks.SPIRITIUM_BLOCK);

  @SoulMaterial
  public static final DeferredHolder<Item, Item> SPIRITIUM_INGOT = registerItem("spiritium_ingot");

  @SoulMaterial
  public static final DeferredHolder<Item, Item> RAW_SPIRITIUM = registerItem("raw_spiritium");

  @SoulMaterial
  public static final DeferredHolder<Item, Item> SPIRITIUM_NUGGET =
      registerItem("spiritium_nugget");

  @SoulMaterial
  public static final DeferredItem<BlockItem> ASH_ORE =
      ITEMS.registerSimpleBlockItem(SoulBlocks.ASH_ORE);

  @SoulMaterial
  public static final DeferredItem<BlockItem> ASH_BLOCK =
      ITEMS.registerSimpleBlockItem(SoulBlocks.ASH_BLOCK);

  @SoulMaterial
  public static final DeferredHolder<Item, Item> ASH_INGOT = registerItem("ash_ingot");

  @SoulMaterial public static final DeferredHolder<Item, Item> RAW_ASH = registerItem("raw_ash");

  @SoulMaterial
  public static final DeferredHolder<Item, Item> ASH_NUGGET = registerItem("ash_nugget");

  @SoulMaterial
  public static final DeferredHolder<Item, Item> DUSK_SOUL = registerItem("dusk_soul");

  @SoulMaterial
  public static final DeferredHolder<Item, Item> SINISTER_CORE = registerItem("sinister_core");

  @SoulMaterial
  public static final DeferredHolder<Item, Item> ENDER_SHELL = registerItem("ender_shell");

  @SoulMaterial
  public static final DeferredHolder<Item, Item> IGNITED_SOUL = registerItem("ignited_soul");

  @SoulMaterial
  public static final DeferredItem<Item> CURSED_BONE =
      ITEMS.registerItem("cursed_bone", CursedBone::new);

  @SoulMaterial
  public static final DeferredHolder<Item, Item> VICIOUS_SKULL =
      ITEMS.registerItem("vicious_skull", ViciousSkull::new);

  @SoulMaterial
  public static final DeferredHolder<Item, Item> TERROR_STAR = registerItem("terror_star");

  @SoulMaterial public static final DeferredHolder<Item, Item> EBOBA = registerItem("eboba");

  // ======================================== FUNCTIONAL BLOCK ITEMS

  @SoulBlock
  public static final DeferredItem<BlockItem> SOUL_FURNACE =
      ITEMS.register(
          "void_furnace",
          () ->
              new VoidFurnaceDisplayItem(
                  SoulBlocks.VOID_FURNACE.get(),
                  new Item.Properties()
                      .setId(
                          ResourceKey.create(
                              ITEMS.getRegistryKey(),
                              ResourceLocation.fromNamespaceAndPath(MODID, "void_furnace")))));

  @SoulBlock
  public static final DeferredItem<BlockItem> ETERNITY_VAULT =
      ITEMS.register(
          "eternity_vault",
          () ->
              new EternityVaultDisplayItem(
                  SoulBlocks.ETERNITY_VAULT.get(),
                  new Item.Properties()
                      .setId(
                          ResourceKey.create(
                              ITEMS.getRegistryKey(),
                              ResourceLocation.fromNamespaceAndPath(MODID, "eternity_vault")))));

  // ================================================ TOOLS
  @SoulTool
  public static final DeferredHolder<Item, Item> MIST_AMULET =
      ITEMS.registerItem("mist_amulet", properties -> new MistAmulet());

  @SoulTool
  public static final DeferredHolder<Item, Item> _AMULET =
          ITEMS.registerItem("mist_amulet", properties -> new MistAmulet());

  @SoulTool
  public static final DeferredHolder<Item, Item> SCORCHING_WAVE =
      ITEMS.registerItem("scorching_wave", ScorchingWave::new);

  @SoulTool
  public static final DeferredHolder<Item, Item> CAGED_SOUL =
      ITEMS.registerItem("caged_soul", RegenerationAmulet::new);

  @SoulTool
  public static final DeferredHolder<Item, Item> SINNERS_STAFF =
      ITEMS.registerItem("sinners_staff", SinnerStaff::new);

  @SoulTool
  public static final DeferredHolder<Item, SwordItem> SOUL_MORPHIST // Sword
      = ITEMS.registerItem("soul_morphist", props -> new SoulMorphist());

  @SoulTool
  public static final DeferredHolder<Item, SwordItem> WITHERING_SWORD // Sword
      = ITEMS.registerItem("withering_sword", props -> new WitheringSword());

  @SoulTool
  public static final DeferredHolder<Item, DiggerItem> SPIRITIUM_MULTITOOL =
      ITEMS.registerItem("spiritium_multitool", props -> new SpiritiumMultitool());

  @SoulTool
  public static final DeferredHolder<Item, PickaxeItem> SPIRITIUM_PICKAXE =
      ITEMS.registerItem(
          "spiritium_pickaxe",
          props ->
              new PickaxeItem(
                  SPIRITIUM_MATERIAL,
                  0,
                  -2.8f,
                  new Item.Properties()
                      .setId(
                          ResourceKey.create(
                              ITEMS.getRegistryKey(),
                              ResourceLocation.fromNamespaceAndPath(MODID, "spiritium_pickaxe")))));

  @SoulTool
  public static final DeferredHolder<Item, AxeItem> SPIRITIUM_AXE =
      ITEMS.registerItem(
          "spiritium_axe",
          props ->
              new AxeItem(
                  SPIRITIUM_MATERIAL,
                  0,
                  -2.8f,
                  new Item.Properties()
                      .setId(
                          ResourceKey.create(
                              ITEMS.getRegistryKey(),
                              ResourceLocation.fromNamespaceAndPath(MODID, "spiritium_axe")))));

  @SoulTool
  public static final DeferredHolder<Item, ShovelItem> SPIRITIUM_SHOVEL =
      ITEMS.registerItem(
          "spiritium_shovel",
          props ->
              new ShovelItem(
                  SPIRITIUM_MATERIAL,
                  0,
                  -2.8f,
                  new Item.Properties()
                      .setId(
                          ResourceKey.create(
                              ITEMS.getRegistryKey(),
                              ResourceLocation.fromNamespaceAndPath(MODID, "spiritium_shovel")))));

  @SoulTool
  public static final DeferredHolder<Item, HoeItem> SPIRITIUM_HOE =
      ITEMS.registerItem(
          "spiritium_hoe",
          props ->
              new HoeItem(
                  SPIRITIUM_MATERIAL,
                  0,
                  -2.8f,
                  new Item.Properties()
                      .setId(
                          ResourceKey.create(
                              ITEMS.getRegistryKey(),
                              ResourceLocation.fromNamespaceAndPath(MODID, "spiritium_hoe")))));

  @SoulTool
  public static final DeferredItem<ArmorItem> SPIRITIUM_HELMET =
      ITEMS.registerItem("spiritium_helmet", SpiritiumHelmet::new);

  @SoulTool
  public static final DeferredItem<ArmorItem> SPIRITIUM_CHESTPLATE =
      ITEMS.registerItem("spiritium_chestplate", SpiritiumChestplate::new);

  @SoulTool
  public static final DeferredItem<ArmorItem> SPIRITIUM_LEGGINGS =
      ITEMS.registerItem("spiritium_leggings", SpiritiumLeggings::new);

  @SoulTool
  public static final DeferredItem<ArmorItem> SPIRITIUM_BOOTS =
      ITEMS.registerItem("spiritium_boots", SpiritiumBoots::new);

  // ========================================== DUNGEON BLOCK ITEMS

  @SoulBlock
  public static final DeferredHolder<Item, BlockItem> SHATTERED_DUNGEON_BRICK =
      ITEMS.registerSimpleBlockItem(
          "shattered_dungeon_brick", SoulBlocks.SHATTERED_DUNGEON_BRICK, new Item.Properties());

  @SoulBlock
  public static final DeferredHolder<Item, BlockItem> DUNGEON_SOUL_LANTERN =
      ITEMS.registerSimpleBlockItem(
          "dungeon_soul_lantern", SoulBlocks.DUNGEON_SOUL_LANTERN, new Item.Properties());

  @SoulBlock
  public static final DeferredHolder<Item, BlockItem> DUNGEON_LEAVES =
      ITEMS.registerSimpleBlockItem(
          "dungeon_leaves", SoulBlocks.DUNGEON_LEAVES, new Item.Properties());

  @SoulBlock
  public static final DeferredHolder<Item, BlockItem> DUNGEON_LAMP =
      ITEMS.registerSimpleBlockItem("dungeon_lamp", SoulBlocks.DUNGEON_LAMP, new Item.Properties());

  @SoulBlock
  public static final DeferredHolder<Item, BlockItem> DUNGEON_BRICK2 =
      ITEMS.registerSimpleBlockItem(
          "dungeon_brick2", SoulBlocks.DUNGEON_BRICK2, new Item.Properties());

  @SoulBlock
  public static final DeferredHolder<Item, BlockItem> DUNGEON_BRICK =
      ITEMS.registerSimpleBlockItem(
          "dungeon_brick", SoulBlocks.DUNGEON_BRICK, new Item.Properties());

  @SoulBlock
  public static final DeferredHolder<Item, BlockItem> DUNGEON_BOTTOM =
      ITEMS.registerSimpleBlockItem(
          "dungeon_bottom", SoulBlocks.DUNGEON_BOTTOM, new Item.Properties());

  @SoulBlock
  public static final DeferredHolder<Item, BlockItem> DAUNGEON_CRYSTAL3_ITEM =
          ITEMS.registerSimpleBlockItem(
                  "daungeon_crystal3", SoulBlocks.DAUNGEON_CRYSTAL3, new Item.Properties());

  @SoulBlock
  public static final DeferredHolder<Item, BlockItem> DUNGEON_CRYSTAL_ITEM =
          ITEMS.registerSimpleBlockItem(
                  "dungeon_crystal", SoulBlocks.DUNGEON_CRYSTAL, new Item.Properties());

  @SoulBlock
  public static final DeferredHolder<Item, BlockItem> DUNGEON_CRYSTAL2_ITEM =
          ITEMS.registerSimpleBlockItem(
                  "dungeon_crystal2", SoulBlocks.DUNGEON_CRYSTAL2, new Item.Properties());

  @SoulBlock
  public static final DeferredHolder<Item, BlockItem> DUNGEON_CRYSTAL4PNG_ITEM =
          ITEMS.registerSimpleBlockItem(
                  "dungeon_crystal4png", SoulBlocks.DUNGEON_CRYSTAL4PNG, new Item.Properties());

  @SoulBlock
  public static final DeferredHolder<Item, BlockItem> DUNGEON_CRYSTAL5PNG_ITEM =
          ITEMS.registerSimpleBlockItem(
                  "dungeon_crystal5png", SoulBlocks.DUNGEON_CRYSTAL5PNG, new Item.Properties());

  @SoulBlock
  public static final DeferredHolder<Item, BlockItem> DUNGEON_DARK_MARBLE_ITEM =
          ITEMS.registerSimpleBlockItem(
                  "dungeon_dark_marble", SoulBlocks.DUNGEON_DARK_MARBLE, new Item.Properties());

  @SoulBlock
  public static final DeferredHolder<Item, BlockItem> DUNGEON_DARK_MARBLE2_ITEM =
          ITEMS.registerSimpleBlockItem(
                  "dungeon_dark_marble2", SoulBlocks.DUNGEON_DARK_MARBLE2, new Item.Properties());

  @SoulBlock
  public static final DeferredHolder<Item, BlockItem> DUNGEON_PURPLE_LIGHT_MARBLE_ITEM =
          ITEMS.registerSimpleBlockItem(
                  "dungeon_purple_light_marble",
                  SoulBlocks.DUNGEON_PURPLE_LIGHT_MARBLE,
                  new Item.Properties());

  @SoulBlock
  public static final DeferredHolder<Item, BlockItem> DUNGEON_ROCK_ITEM =
          ITEMS.registerSimpleBlockItem("dungeon_rock", SoulBlocks.DUNGEON_ROCK, new Item.Properties());

  @SoulBlock
  public static final DeferredHolder<Item, BlockItem> DUNGEON_TERRACOTTA_ITEM =
          ITEMS.registerSimpleBlockItem(
                  "dungeon_terracotta", SoulBlocks.DUNGEON_TERRACOTTA, new Item.Properties());
}
