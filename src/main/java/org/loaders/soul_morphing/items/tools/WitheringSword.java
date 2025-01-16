package org.loaders.soul_morphing.items.tools;

import static org.loaders.soul_morphing.Soul_morphing.MODID;
import static org.loaders.soul_morphing.init.SoulItems.ITEMS;
import static org.loaders.soul_morphing.init.data.ToolMaterials.WITHERING_MATERIAL;

import javax.annotation.Nonnull;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.level.Level;
import org.loaders.soul_morphing.init.SoulParticleTypes;

public class WitheringSword extends SwordItem {

  public WitheringSword() {
    super(
        WITHERING_MATERIAL,
        1,
        -3.2F,
        new Properties()
            .setId(
                ResourceKey.create(
                    ITEMS.getRegistryKey(),
                    ResourceLocation.fromNamespaceAndPath(MODID, "withering_sword"))));
  }

  @Override
  public InteractionResult use(
      @Nonnull Level level, @Nonnull Player player, @Nonnull InteractionHand hand) {
    if (!level.isClientSide) {
      for (int i = 0; i <= 3; i++) {
        AreaEffectCloud flame =
            new AreaEffectCloud(level, player.getX(), player.getY(), player.getZ());
        flame.setOwner(player);
        flame.setRadius(2.0F);
        flame.setDuration(30);
        flame.addEffect(new MobEffectInstance(MobEffects.GLOWING, 2000));
        flame.addEffect(new MobEffectInstance(MobEffects.HARM, 200));
        flame.setWaitTime(0);
        flame.setParticle(SoulParticleTypes.WITHERING_PARTICLE.get());

        double theta = Math.toRadians(-player.getYRot());
        double offsetX = Math.sin(theta) * (i * 3 + 2);
        double offsetZ = Math.cos(theta) * (i * 3 + 2);

        double X = player.getX() + offsetX;
        double Z = player.getZ() + offsetZ;
        flame.setPos(X, player.getY(), Z);

        level.addFreshEntity(flame);
      }
    }
    player.getCooldowns().addCooldown(player.getItemInHand(hand), 40);
    return super.use(level, player, hand);
  }
}
