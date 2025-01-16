package org.loaders.soul_morphing.init.data;

import com.mojang.brigadier.arguments.DoubleArgumentType;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.network.chat.Component;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import net.neoforged.neoforge.network.PacketDistributor;
import org.loaders.soul_morphing.network.SoulsData;
import org.loaders.soul_morphing.util.Souls;

@EventBusSubscriber
public class SoulsCommand {

  @SubscribeEvent
  public static void registerCommand(RegisterCommandsEvent event) {
    event
        .getDispatcher()
        .register(
            Commands.literal("souls")
                .requires(s -> s.hasPermission(1))
                .then(
                    Commands.argument("entity", EntityArgument.player())
                        .then(
                            Commands.literal("get")
                                .executes(
                                    context -> {
                                      var player = context.getSource().getPlayerOrException();
                                      var entity = EntityArgument.getPlayer(context, "entity");
                                      player.sendSystemMessage(
                                          Component.literal(
                                              "Souls: "
                                                  + Souls.getSouls(entity)
                                                  + " / "
                                                  + Souls.getMaxSouls(entity)));
                                      return 1;
                                    }))
                        .then(
                            Commands.literal("set")
                                .then(
                                    Commands.argument("count", DoubleArgumentType.doubleArg(0))
                                        .executes(
                                            context -> {
                                              var player =
                                                  context.getSource().getPlayerOrException();
                                              var entity =
                                                  EntityArgument.getPlayer(context, "entity");
                                              var count =
                                                  DoubleArgumentType.getDouble(context, "count");
                                              Souls.setSouls(entity, (int) count);
                                              PacketDistributor.sendToServer(
                                                  new SoulsData(
                                                      (int) count, Souls.getMaxSouls(entity)));
                                              player.sendSystemMessage(
                                                  Component.literal(
                                                      "Souls set to " + Souls.getSouls(entity)));
                                              return 1;
                                            })))));
  }
}
