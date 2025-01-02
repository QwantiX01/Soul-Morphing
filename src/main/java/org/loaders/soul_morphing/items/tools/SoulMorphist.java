package org.loaders.soul_morphing.items.tools;

import net.minecraft.core.HolderSet;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.item.enchantment.Repairable;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import org.loaders.soul_morphing.init.SoulItems;

import java.util.*;

import static org.loaders.soul_morphing.Soul_morphing.MODID;
import static org.loaders.soul_morphing.init.SoulItems.ITEMS;
import static org.loaders.soul_morphing.init.ToolMaterials.SPIRITIUM_MATERIAL;


public class SoulMorphist extends SwordItem {

    public SoulMorphist() {
        super(SPIRITIUM_MATERIAL, 1, 1,
                new Properties()
                        .setId(ResourceKey.create(ITEMS.getRegistryKey(), ResourceLocation.fromNamespaceAndPath(MODID, "soul_morphist")))
        );
    }

}
