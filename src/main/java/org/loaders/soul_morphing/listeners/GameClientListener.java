package org.loaders.soul_morphing.listeners;

import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import org.loaders.soul_morphing.items.armor.SpiritiumBoots;
import org.loaders.soul_morphing.items.armor.SpiritiumChestplate;
import org.loaders.soul_morphing.items.armor.SpiritiumHelmet;
import org.loaders.soul_morphing.items.armor.SpiritiumLeggings;
import org.loaders.soul_morphing.util.Souls;

import static org.loaders.soul_morphing.Soul_morphing.MODID;
import static org.loaders.soul_morphing.util.Souls.getTotalBonus;

@EventBusSubscriber(modid = MODID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.GAME)
public class GameClientListener {
    @SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent.Post event) {
        Player player = Minecraft.getInstance().player;
        if (player == null) {
            return;
        }
        int totalBonus = getTotalBonus(player);

        int currentBonus = player.getPersistentData().getInt("spiritium_armor_bonus");

        if (totalBonus != currentBonus) {
            Souls.increaseMaxSouls(player, totalBonus - currentBonus);
            player.getPersistentData().putInt("spiritium_armor_bonus", totalBonus);
        }

    }
}
