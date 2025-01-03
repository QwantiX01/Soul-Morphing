package org.loaders.soul_morphing.listeners;

import net.minecraft.client.Minecraft;
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

import static org.loaders.soul_morphing.Soul_morphing.MODID;
import static org.loaders.soul_morphing.util.Souls.getTotalBonus;

@EventBusSubscriber(modid = MODID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.GAME)
public class GameClientListener {
    @SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent.Pre event) {
        Player player = Minecraft.getInstance().player;
        Level level = Minecraft.getInstance().level;
        if (player == null) {
            return;
        }

        int totalBonus = getTotalBonus(player);

        int currentBonus = player.getPersistentData().getInt("spiritium_armor_bonus");

        if (totalBonus != currentBonus) {
            Souls.increaseMaxSouls(player, totalBonus - currentBonus);
            player.getPersistentData().putInt("spiritium_armor_bonus", totalBonus);
        }

        if (Souls.getSouls(player) > Souls.getMaxSouls(player)) {
            Souls.setSouls(player, Souls.getMaxSouls(player));
        }

    }

    private static long lastTick = 0;

    @SubscribeEvent
    public static void onLevelTick(LevelTickEvent.Post event) {
        Player player = Minecraft.getInstance().player;
        if (player == null) {
            return;
        }

        long tick = event.getLevel().getGameTime();
        int regenerationSpeedTicks = Souls.getTotalSoulsRegeneration(player);
        if (tick % (60 - (regenerationSpeedTicks * 10L)) == 0 && tick != lastTick) {
            Souls.addSouls(player, 1);
            lastTick = tick;
        }

    }

}
