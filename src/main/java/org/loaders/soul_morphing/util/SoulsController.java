package org.loaders.soul_morphing.util;

import net.minecraft.client.Minecraft;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.LevelTickEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import org.loaders.soul_morphing.items.armor.SpiritiumBoots;
import org.loaders.soul_morphing.items.armor.SpiritiumChestplate;
import org.loaders.soul_morphing.items.armor.SpiritiumHelmet;
import org.loaders.soul_morphing.items.armor.SpiritiumLeggings;

import static org.loaders.soul_morphing.Soul_morphing.MODID;

@EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.GAME)
public class SoulsController {
    public static boolean enoughSouls(LivingEntity entity, int soulsNeeded) {
        CompoundTag entityNbt = entity.getPersistentData();
        return entityNbt.getInt("soul_count") >= soulsNeeded;
    }

    public static int getSouls(LivingEntity entity) {
        CompoundTag entityNbt = entity.getPersistentData();
        return entityNbt.getInt("soul_count");
    }

    public static int getMaxSouls(LivingEntity entity) {
        CompoundTag entityNbt = entity.getPersistentData();
        return entityNbt.getInt("max_soul_count");
    }

    public static int getTotalBonus(Player player) {
        CompoundTag entityNbt = player.getPersistentData();

        ItemStack headStack = player.getInventory().armor.get(3);
        ItemStack chestplateStack = player.getInventory().armor.get(2);
        ItemStack leggingsStack = player.getInventory().armor.get(1);
        ItemStack bootsStack = player.getInventory().armor.get(0);

        int totalBonus = 0;

        if (headStack.getItem() instanceof SpiritiumHelmet)
            totalBonus += SpiritiumHelmet.getSoulsBonus(headStack);

        if (chestplateStack.getItem() instanceof SpiritiumChestplate)
            totalBonus += SpiritiumChestplate.getSoulsBonus(chestplateStack);

        if (leggingsStack.getItem() instanceof SpiritiumLeggings)
            totalBonus += SpiritiumLeggings.getSoulsBonus(leggingsStack);

        if (bootsStack.getItem() instanceof SpiritiumBoots)
            totalBonus += SpiritiumBoots.getSoulsBonus(bootsStack);

        return totalBonus;
    }

    public static int getTotalSoulsRegeneration(Player player) {
        ItemStack headStack = player.getInventory().armor.get(3);
        ItemStack chestplateStack = player.getInventory().armor.get(2);
        ItemStack leggingsStack = player.getInventory().armor.get(1);
        ItemStack bootsStack = player.getInventory().armor.get(0);

        int totalRegen = 0;

        if (headStack.getItem() instanceof SpiritiumHelmet)
            totalRegen += SpiritiumHelmet.getSoulsRegeneration(headStack);

        if (chestplateStack.getItem() instanceof SpiritiumChestplate)
            totalRegen += SpiritiumChestplate.getSoulsRegeneration(chestplateStack);

        if (leggingsStack.getItem() instanceof SpiritiumLeggings)
            totalRegen += SpiritiumLeggings.getSoulsRegeneration(leggingsStack);

        if (bootsStack.getItem() instanceof SpiritiumBoots)
            totalRegen += SpiritiumBoots.getSoulsRegeneration(bootsStack);

        return totalRegen;
    }

    public static void addSouls(LivingEntity entity, int amount) {
        CompoundTag entityNbt = entity.getPersistentData();

        int current = getSouls(entity);
        int maxSouls = getMaxSouls(entity);
        int newSouls = Math.min(current + amount, maxSouls);
        entityNbt.putInt("soul_count", newSouls);
    }

    public static boolean removeSouls(LivingEntity entity, int amount) {
        CompoundTag entityNbt = entity.getPersistentData();
        int current = getSouls(entity);
        if (getSouls(entity) - amount >= 0) {
            entityNbt.putInt("soul_count", current - amount);
            return true;
        } else {
            return false;
        }
    }

    public static void setMaxSouls(LivingEntity entity, int amount) {
        CompoundTag entityNbt = entity.getPersistentData();
        entityNbt.putInt("max_soul_count", amount);
    }

    @SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent.Pre event) {
        Player player = Minecraft.getInstance().player;
        if (player != null)
            setMaxSouls(player, 20 + getTotalBonus(player));
    }

    private static long lastTick = 0;

    @SubscribeEvent
    public static void onLevelTick(LevelTickEvent.Post event) {
        Player player = Minecraft.getInstance().player;
        if (player != null) {

            long tick = event.getLevel().getGameTime();

            int regenerationSpeedTicks = getTotalSoulsRegeneration(player);

            if (tick % (60 - (regenerationSpeedTicks * 10L)) == 0 && tick != lastTick) {
//            if (tick % (2) == 0 && tick != lastTick) {
                addSouls(player, 1);
                lastTick = tick;
            }
        }

    }
}
