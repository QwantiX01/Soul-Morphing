package org.loaders.soul_morphing.util;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.loaders.soul_morphing.init.SoulAttributes;
import org.loaders.soul_morphing.items.armor.SpiritiumBoots;
import org.loaders.soul_morphing.items.armor.SpiritiumChestplate;
import org.loaders.soul_morphing.items.armor.SpiritiumHelmet;
import org.loaders.soul_morphing.items.armor.SpiritiumLeggings;

public class Souls {
    public static int getSouls(LivingEntity entity) {
        if (entity != null && entity.getAttributes().hasAttribute(SoulAttributes.SOULS_COUNT)) {
            return (int) entity.getAttribute(SoulAttributes.SOULS_COUNT).getBaseValue();
        }
        return 0;
    }

    public static int getMaxSouls(LivingEntity entity) {
        if (entity != null && entity.getAttributes().hasAttribute(SoulAttributes.MAX_SOULS_COUNT)) {
            return (int) entity.getAttribute(SoulAttributes.MAX_SOULS_COUNT).getBaseValue();
        }
        return 0;
    }

    public static void increaseMaxSouls(LivingEntity entity, int souls) {
        if (entity != null && entity.getAttributes().hasAttribute(SoulAttributes.MAX_SOULS_COUNT)) {
            double current = entity.getAttribute(SoulAttributes.MAX_SOULS_COUNT).getBaseValue();
            double newMax = Math.max(20, current + souls); // Ensure minimum max souls is 20.
            entity.getAttribute(SoulAttributes.MAX_SOULS_COUNT).setBaseValue(newMax);
        }
    }

    public static void setSouls(LivingEntity entity, int souls) {
        if (entity != null && entity.getAttributes().hasAttribute(SoulAttributes.SOULS_COUNT)) {
            entity.getAttribute(SoulAttributes.SOULS_COUNT).setBaseValue(souls);
        }
    }

    public static void addSouls(LivingEntity entity, int souls) {
        if (entity != null && entity.getAttributes().hasAttribute(SoulAttributes.SOULS_COUNT)) {
            int current = getSouls(entity);
            int maxSouls = getMaxSouls(entity);
            entity.getAttribute(SoulAttributes.SOULS_COUNT).setBaseValue(Math.min(current + souls, maxSouls));
        }
    }

    public static boolean trySubtractSouls(LivingEntity entity, int souls) {
        if (entity != null && entity.getAttributes().hasAttribute(SoulAttributes.SOULS_COUNT)) {
            int current = getSouls(entity);
            if (current >= souls) {
                entity.getAttribute(SoulAttributes.SOULS_COUNT).setBaseValue(current - souls);
                return true;
            }
        }
        return false;
    }

    public static int getTotalBonus(Player player) {
        ItemStack headStack = player.getInventory().armor.get(3);
        ItemStack chestplateStack = player.getInventory().armor.get(2);
        ItemStack leggingsStack = player.getInventory().armor.get(1);
        ItemStack bootsStack = player.getInventory().armor.get(0);

        int totalBonus = 0;

        if (headStack.getItem() instanceof SpiritiumHelmet) totalBonus += SpiritiumHelmet.getSoulsBonus(headStack);

        if (chestplateStack.getItem() instanceof SpiritiumChestplate) totalBonus += SpiritiumChestplate.getSoulsBonus(chestplateStack);

        if (leggingsStack.getItem() instanceof SpiritiumLeggings) totalBonus += SpiritiumLeggings.getSoulsBonus(leggingsStack);

        if (bootsStack.getItem() instanceof SpiritiumBoots) totalBonus += SpiritiumBoots.getSoulsBonus(bootsStack);

        return totalBonus;
    }
}

