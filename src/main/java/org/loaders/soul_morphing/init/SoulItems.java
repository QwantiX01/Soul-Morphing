package org.loaders.soul_morphing.init;

import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.loaders.soul_morphing.blocks.animated.display.EternityVaultDisplayItem;
import org.loaders.soul_morphing.blocks.animated.display.VoidFurnaceDisplayItem;
import org.loaders.soul_morphing.items.CursedBone;
import org.loaders.soul_morphing.items.MistAmulet;
import org.loaders.soul_morphing.items.ScorchingWave;
import org.loaders.soul_morphing.items.armor.SpiritiumBoots;
import org.loaders.soul_morphing.items.armor.SpiritiumChestplate;
import org.loaders.soul_morphing.items.armor.SpiritiumHelmet;
import org.loaders.soul_morphing.items.armor.SpiritiumLeggings;
import org.loaders.soul_morphing.items.tools.SoulMorphist;
import org.loaders.soul_morphing.items.tools.SpiritiumMultitool;

import static org.loaders.soul_morphing.Soul_morphing.MODID;
import static org.loaders.soul_morphing.init.data.ToolMaterials.SPIRITIUM_MATERIAL;


public class SoulItems {
    // =============================================== REGISTRY ========================================================

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);

    private static DeferredHolder<Item, Item> registerItem(final String id) {
        return ITEMS.registerItem(id, properties -> new Item(properties.setId(ResourceKey.create(ITEMS.getRegistryKey(), ResourceLocation.fromNamespaceAndPath(MODID, id)))));
    }


    // ============================================  ORE & INGOTS  =====================================================

    public static final DeferredItem<BlockItem> SPIRITIUM_ORE = ITEMS.registerSimpleBlockItem("spiritium_ore", SoulBlocks.SPIRITIUM_ORE, new Item.Properties());
    public static final DeferredItem<BlockItem> SPIRITIUM_BLOCK = ITEMS.registerSimpleBlockItem(SoulBlocks.SPIRITIUM_BLOCK);
    public static final DeferredHolder<Item, Item> SPIRITIUM_INGOT = registerItem("spiritium_ingot");
    public static final DeferredHolder<Item, Item> RAW_SPIRITIUM = registerItem("raw_spiritium");
    public static final DeferredHolder<Item, Item> SPIRITIUM_NUGGET = registerItem("spiritium_nugget");


    public static final DeferredItem<BlockItem> ASH_ORE = ITEMS.registerSimpleBlockItem(SoulBlocks.ASH_ORE);
    public static final DeferredItem<BlockItem> ASH_BLOCK = ITEMS.registerSimpleBlockItem(SoulBlocks.ASH_BLOCK);
    public static final DeferredHolder<Item, Item> ASH_INGOT = registerItem("ash_ingot");
    public static final DeferredHolder<Item, Item> RAW_ASH = registerItem("raw_ash");
    public static final DeferredHolder<Item, Item> ASH_NUGGET = registerItem("ash_nugget");

    // ============================================== MATERIALS ========================================================

    public static final DeferredHolder<Item, Item> DUSK_SOUL = registerItem("dusk_soul");


    // ======================================== FUNCTIONAL BLOCK ITEMS =================================================

    public static final DeferredItem<BlockItem> SOUL_FURNACE = ITEMS.register("void_furnace", () -> new VoidFurnaceDisplayItem(SoulBlocks.VOID_FURNACE.get(), new Item.Properties().setId(ResourceKey.create(ITEMS.getRegistryKey(), ResourceLocation.fromNamespaceAndPath(MODID, "void_furnace")))));
    public static final DeferredItem<BlockItem> ETERNITY_VAULT = ITEMS.register("eternity_vault", () -> new EternityVaultDisplayItem(SoulBlocks.ETERNITY_VAULT.get(), new Item.Properties().setId(ResourceKey.create(ITEMS.getRegistryKey(), ResourceLocation.fromNamespaceAndPath(MODID, "eternity_vault")))));


    // ================================================ TOOLS ==========================================================

    public static final DeferredHolder<Item, Item> MIST_AMULET
            = ITEMS.registerItem("mist_amulet", properties -> new MistAmulet());
    public static final DeferredHolder<Item, Item> SCORCHING_WAVE
            = ITEMS.registerItem("scorching_wave", ScorchingWave::new);
    public static final DeferredHolder<Item, SwordItem> SOUL_MORPHIST //Sword
            = ITEMS.registerItem("soul_morphist", props -> new SoulMorphist());
    public static final DeferredHolder<Item, DiggerItem> SPIRITIUM_MULTITOOL
            = ITEMS.registerItem("spiritium_multitool", props -> new SpiritiumMultitool());
    public static final DeferredHolder<Item, PickaxeItem> SPIRITIUM_PICKAXE =
            ITEMS.registerItem("spiritium_pickaxe", props -> new PickaxeItem(SPIRITIUM_MATERIAL, 0, -2.8f, new Item.Properties().setId(ResourceKey.create(ITEMS.getRegistryKey(), ResourceLocation.fromNamespaceAndPath(MODID, "spiritium_pickaxe")))));
    public static final DeferredHolder<Item, AxeItem> SPIRITIUM_AXE =
            ITEMS.registerItem("spiritium_axe", props -> new AxeItem(SPIRITIUM_MATERIAL, 0, -2.8f, new Item.Properties().setId(ResourceKey.create(ITEMS.getRegistryKey(), ResourceLocation.fromNamespaceAndPath(MODID, "spiritium_axe")))));
    public static final DeferredHolder<Item, ShovelItem> SPIRITIUM_SHOVEL =
            ITEMS.registerItem("spiritium_shovel", props -> new ShovelItem(SPIRITIUM_MATERIAL, 0, -2.8f, new Item.Properties().setId(ResourceKey.create(ITEMS.getRegistryKey(), ResourceLocation.fromNamespaceAndPath(MODID, "spiritium_shovel")))));
    public static final DeferredHolder<Item, HoeItem> SPIRITIUM_HOE =
            ITEMS.registerItem("spiritium_hoe", props -> new HoeItem(SPIRITIUM_MATERIAL, 0, -2.8f, new Item.Properties().setId(ResourceKey.create(ITEMS.getRegistryKey(), ResourceLocation.fromNamespaceAndPath(MODID, "spiritium_hoe")))));


    public static final DeferredItem<ArmorItem> SPIRITIUM_HELMET = ITEMS.registerItem("spiritium_helmet", SpiritiumHelmet::new);
    public static final DeferredItem<ArmorItem> SPIRITIUM_CHESTPLATE = ITEMS.registerItem("spiritium_chestplate", SpiritiumChestplate::new);
    public static final DeferredItem<ArmorItem> SPIRITIUM_LEGGINGS = ITEMS.registerItem("spiritium_leggings", SpiritiumLeggings::new);
    public static final DeferredItem<ArmorItem> SPIRITIUM_BOOTS = ITEMS.registerItem("spiritium_boots", SpiritiumBoots::new);

    public static final DeferredItem<Item> CURSED_BONE = ITEMS.registerItem("cursed_bone", CursedBone::new);
}
