package org.loaders.soul_morphing.listeners;

import static org.loaders.soul_morphing.Soul_morphing.MODID;

import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.neoforge.network.PacketDistributor;
import org.loaders.soul_morphing.network.SoulsData;
import org.loaders.soul_morphing.util.Souls;

@EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.GAME, value = Dist.CLIENT)
public class GameClientListener {
  @SubscribeEvent
  public static void onPlayerTick(PlayerTickEvent.Pre event) {
    Player player = Minecraft.getInstance().player;
    if (player != null) {
      var playerNbt = player.getPersistentData();
      int armorBonus = Souls.getTotalBonus(player);

      if (playerNbt.getInt("soul_armor_bonus") != armorBonus) {
        playerNbt.putInt("soul_armor_bonus", armorBonus);
      }

      PacketDistributor.sendToServer(new SoulsData(Souls.getSouls(player), 20 + armorBonus));
    }
  }
}
