package org.loaders.soul_morphing.items;

import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.loaders.soul_morphing.items.custom.MistAmulet;

import static org.loaders.soul_morphing.Soul_morphing.MODID;
import static org.loaders.soul_morphing.items.ToolMaterials.SOUL_MATERIAL;


public class SoulItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);
    public static final DeferredHolder<Item, Item> DUSK_SOUL = ITEMS.registerItem("dusk_soul", properties -> new Item(properties.setId(ResourceKey.create(ITEMS.getRegistryKey(), ResourceLocation.parse(String.format("%s:%s", MODID, "dusk_soul"))))));
    public static final DeferredHolder<Item, Item> SOUL_INGOT = ITEMS.registerItem("soul_ingot", properties -> new Item(properties.setId(ResourceKey.create(ITEMS.getRegistryKey(), ResourceLocation.parse(String.format("%s:%s", MODID, "soul_ingot"))))));
    public static final DeferredHolder<Item, Item> MIST_AMULET = ITEMS.registerItem("mist_amulet", properties -> new MistAmulet(properties.setId(ResourceKey.create(ITEMS.getRegistryKey(), ResourceLocation.parse(String.format("%s:%s", MODID, "mist_amulet"))))));
    public static final DeferredHolder<Item, SwordItem> SOUL_MORPHER = ITEMS.registerItem(
            "soul_morpher_sword",
            props -> new SwordItem(
                    SOUL_MATERIAL,
                    3,
                    -2.4f,
                    props
            )
    );

    public static final DeferredHolder<Item, DiggerItem> SOUL_AIOT = ITEMS.registerItem(
            "soul_aiot",
            props -> new DiggerItem(
                    SOUL_MATERIAL,
                    Tags.Blocks.SANDS,
                    -2.4f,
                    -2.8f,
                    props
            )
    );

}
