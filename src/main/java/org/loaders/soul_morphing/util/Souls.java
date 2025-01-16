package org.loaders.soul_morphing.util;

import static org.loaders.soul_morphing.init.data.SoulEnchantments.SOUL_DEFORMATION;
import static org.loaders.soul_morphing.init.data.SoulEnchantments.SOUL_REGENERATION;

import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.loaders.soul_morphing.init.data.SoulAttributes;
import org.loaders.soul_morphing.items.armor.SpiritiumBoots;
import org.loaders.soul_morphing.items.armor.SpiritiumChestplate;
import org.loaders.soul_morphing.items.armor.SpiritiumHelmet;
import org.loaders.soul_morphing.items.armor.SpiritiumLeggings;

// Send packet to server if called on client, otherwise directly add souls on server.
public class Souls {
  public static int getSouls(LivingEntity entity) {
    if (entity != null && entity.getAttributes().hasAttribute(SoulAttributes.SOULS_COUNT)) {
      AttributeInstance SoulsCountAttribute = entity.getAttribute(SoulAttributes.SOULS_COUNT);
      if (SoulsCountAttribute != null) return (int) SoulsCountAttribute.getBaseValue();
      // return (int) entity.getAttribute(SoulAttributes.SOULS_COUNT).getBaseValue();
    }
    return 0;
  }

  public static int getMaxSouls(LivingEntity entity) {
    if (entity != null && entity.getAttributes().hasAttribute(SoulAttributes.MAX_SOULS_COUNT)) {
      AttributeInstance MaxSoulsCountAttribute =
          entity.getAttribute(SoulAttributes.MAX_SOULS_COUNT);
      if (MaxSoulsCountAttribute != null) return (int) MaxSoulsCountAttribute.getBaseValue();
    }
    return 0;
  }

  public static void setMaxSouls(LivingEntity entity, int souls) {
    if (entity != null && entity.getAttributes().hasAttribute(SoulAttributes.MAX_SOULS_COUNT)) {
      AttributeInstance MaxSoulsCountAttribute =
          entity.getAttribute(SoulAttributes.MAX_SOULS_COUNT);
      if (MaxSoulsCountAttribute != null) MaxSoulsCountAttribute.setBaseValue(souls);
    }
  }

  public static void setSouls(LivingEntity entity, int souls) {
    if (entity != null && entity.getAttributes().hasAttribute(SoulAttributes.SOULS_COUNT)) {
      AttributeInstance soulsCountAttribute = entity.getAttribute(SoulAttributes.SOULS_COUNT);
      if (soulsCountAttribute != null) {
        soulsCountAttribute.setBaseValue(souls);
      }
    }
  }

  public static void addSouls(LivingEntity entity, int souls) {
    if (entity != null && entity.getAttributes().hasAttribute(SoulAttributes.SOULS_COUNT)) {
      int current = getSouls(entity);
      int maxSouls = getMaxSouls(entity);
      int newSouls = Math.min(current + souls, maxSouls);
      AttributeInstance soulsCountAttribute = entity.getAttribute(SoulAttributes.SOULS_COUNT);
      if (soulsCountAttribute != null) {
        soulsCountAttribute.setBaseValue(newSouls);
      }
    }
  }

  public static boolean trySubtractSouls(LivingEntity entity, int souls) {
    if (entity != null && entity.getAttributes().hasAttribute(SoulAttributes.SOULS_COUNT)) {
      int current = getSouls(entity);
      if (current >= souls) {
        AttributeInstance soulsCountAttribute = entity.getAttribute(SoulAttributes.SOULS_COUNT);
        if (soulsCountAttribute != null) {
          soulsCountAttribute.setBaseValue(current - souls);
        }
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

    if (headStack.getItem() instanceof SpiritiumHelmet) totalBonus += getSoulsBonus(headStack, 4);

    if (chestplateStack.getItem() instanceof SpiritiumChestplate)
      totalBonus += getSoulsBonus(chestplateStack, 8);

    if (leggingsStack.getItem() instanceof SpiritiumLeggings)
      totalBonus += getSoulsBonus(leggingsStack, 6);

    if (bootsStack.getItem() instanceof SpiritiumBoots) totalBonus += getSoulsBonus(bootsStack, 4);

    return totalBonus;
  }

  public static int getTotalSoulsRegeneration(Player player) {
    ItemStack headStack = player.getInventory().armor.get(3);
    ItemStack chestplateStack = player.getInventory().armor.get(2);
    ItemStack leggingsStack = player.getInventory().armor.get(1);
    ItemStack bootsStack = player.getInventory().armor.get(0);

    int totalBonus = 0;

    if (headStack.getItem() instanceof SpiritiumHelmet)
      totalBonus += getSoulsRegeneration(headStack);

    if (chestplateStack.getItem() instanceof SpiritiumChestplate)
      totalBonus += getSoulsRegeneration(chestplateStack);

    if (leggingsStack.getItem() instanceof SpiritiumLeggings)
      totalBonus += getSoulsRegeneration(leggingsStack);

    if (bootsStack.getItem() instanceof SpiritiumBoots)
      totalBonus += getSoulsRegeneration(bootsStack);

    return totalBonus;
  }

  public static int getSoulsRegeneration(ItemStack stack) {
    Level level = Minecraft.getInstance().level;
    if (level != null) {
      int enchantmentLevel =
          stack.getEnchantmentLevel(
              level
                  .registryAccess()
                  .lookupOrThrow(Registries.ENCHANTMENT)
                  .getOrThrow(SOUL_REGENERATION));
      return enchantmentLevel;
    } else {
      return 0;
    }
  }

  public static int getSoulsBonus(ItemStack stack, int base) {
    Level level = Minecraft.getInstance().level;
    if (level != null) {
      int enchantmentLevel =
          stack.getEnchantmentLevel(
              level
                  .registryAccess()
                  .lookupOrThrow(Registries.ENCHANTMENT)
                  .getOrThrow(SOUL_DEFORMATION));
      return base + enchantmentLevel;
    } else {
      return base;
    }
  }
}
