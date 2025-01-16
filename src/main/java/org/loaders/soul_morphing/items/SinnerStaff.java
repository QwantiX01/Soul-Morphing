package org.loaders.soul_morphing.items;

import static org.loaders.soul_morphing.Soul_morphing.MODID;
import static org.loaders.soul_morphing.init.SoulItems.ITEMS;

import javax.annotation.Nonnull;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import org.loaders.soul_morphing.entity.custom.SinnerHeavySphereEntity;
import org.loaders.soul_morphing.entity.custom.SinnerLightSphereEntity;

public class SinnerStaff extends Item {
  private static int mode = 0;

  // Mode 0: Small/Fast/Cheap
  // Mode 1: Big/Slow/Expensive

  public SinnerStaff(Properties properties) {
    super(
        properties.setId(
            ResourceKey.create(
                ITEMS.getRegistryKey(),
                ResourceLocation.fromNamespaceAndPath(MODID, "sinners_staff"))));
  }

  @Override
  public InteractionResult use(
      @Nonnull Level level, @Nonnull Player player, @Nonnull InteractionHand hand) {
    if (!level.isClientSide) {
      if (player.isShiftKeyDown()) {
        changeMode();
        player.displayClientMessage(Component.literal("Mode: " + mode), true);
        return InteractionResult.SUCCESS;
      }

      switch (mode) {
        case 0 -> {
          Entity _shootFrom = player;
          Level projectileLevel = _shootFrom.level();
          if (!projectileLevel.isClientSide()) {
            SinnerLightSphereEntity.shoot(
                projectileLevel, player, projectileLevel.getRandom(), 2, 5, 0);
          }

          return InteractionResult.PASS;
        }
        case 1 -> {
          Level projectileLevel = player.level();
          if (!projectileLevel.isClientSide()) {
            SinnerHeavySphereEntity.shoot(
                projectileLevel, player, projectileLevel.getRandom(), 3, 20, 3);
          }
          player
              .getCooldowns()
              .addCooldown(ResourceLocation.fromNamespaceAndPath(MODID, "sinners_staff"), 0);
          return InteractionResult.PASS;
        }
      }
    }
    return super.use(level, player, hand);
  }

  private void changeMode() {
    if (mode == 0) {
      mode = 1;
    } else {
      mode = 0;
    }
  }
}
