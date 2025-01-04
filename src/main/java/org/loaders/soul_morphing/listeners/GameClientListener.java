package org.loaders.soul_morphing.listeners;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.LevelTickEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import org.loaders.soul_morphing.items.armor.SpiritiumBoots;
import org.loaders.soul_morphing.items.armor.SpiritiumChestplate;
import org.loaders.soul_morphing.items.armor.SpiritiumHelmet;
import org.loaders.soul_morphing.items.armor.SpiritiumLeggings;
import org.loaders.soul_morphing.util.Souls;
import software.bernie.geckolib.util.RenderUtil;

import java.util.UUID;

import static org.loaders.soul_morphing.Soul_morphing.MODID;
import static org.loaders.soul_morphing.util.Souls.getTotalBonus;

@EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.GAME)
public class GameClientListener {
    @SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent.Pre event) {
        Player player = Minecraft.getInstance().player;
//        if (player != null) {
//            player.displayClientMessage(Component.literal(player.getName().getString() + Souls.getSouls(player)), false);
//            int totalBonus = getTotalBonus(player);
//            int currentBonus = player.getPersistentData().getInt("spiritium_armor_bonus");
//
//            if (totalBonus != currentBonus) {
//                Souls.setMaxSouls(player, 20 + totalBonus);
//                player.getPersistentData().putInt("spiritium_armor_bonus", totalBonus);
//            }
//        }
    }

    @SubscribeEvent
    public static void bob(LevelTickEvent.Pre event) {

        event.getLevel().players().forEach(player -> {
            int totalBonus = getTotalBonus(player);
            int currentBonus = player.getPersistentData().getInt("spiritium_armor_bonus");

            if (totalBonus != currentBonus) {
                Souls.setMaxSouls(player, 20 + totalBonus);
                player.getPersistentData().putInt("spiritium_armor_bonus", totalBonus);
            }
        });
    }
}
