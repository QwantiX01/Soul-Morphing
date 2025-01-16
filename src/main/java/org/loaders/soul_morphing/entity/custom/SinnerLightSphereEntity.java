package org.loaders.soul_morphing.entity.custom;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.loaders.soul_morphing.init.SoulEntities;
import org.loaders.soul_morphing.init.SoulParticleTypes;

@OnlyIn(value = Dist.CLIENT, _interface = ItemSupplier.class)
public class SinnerLightSphereEntity extends AbstractArrow implements ItemSupplier {

  public static final ItemStack PROJECTILE_ITEM = new ItemStack(Blocks.AIR);
  private int knockback = 0;

  public SinnerLightSphereEntity(EntityType<? extends SinnerLightSphereEntity> type, Level world) {
    super(type, world);
  }

  public SinnerLightSphereEntity(
      EntityType<? extends SinnerLightSphereEntity> type,
      LivingEntity entity,
      Level world,
      @Nullable ItemStack firedFromWeapon) {
    super(type, entity, world, PROJECTILE_ITEM, firedFromWeapon);
  }

  public static SinnerLightSphereEntity shoot(
      Level world,
      LivingEntity entity,
      RandomSource random,
      float power,
      double damage,
      int knockback) {
    SinnerLightSphereEntity entityarrow =
        new SinnerLightSphereEntity(SoulEntities.SINNER_LIGHT_SHPERE.get(), entity, world, null);
    entityarrow.shoot(
        entity.getViewVector(1).x,
        entity.getViewVector(1).y,
        entity.getViewVector(1).z,
        power * 2,
        0);
    entityarrow.setSilent(true);
    entityarrow.setCritArrow(false);
    entityarrow.setBaseDamage(damage);
    entityarrow.setKnockback(knockback);
    world.addFreshEntity(entityarrow);
    return entityarrow;
  }

  @Override
  @OnlyIn(Dist.CLIENT)
  public ItemStack getItem() {
    return PROJECTILE_ITEM;
  }

  @Override
  protected ItemStack getDefaultPickupItem() {
    return new ItemStack(Blocks.AIR);
  }

  @Override
  protected void doPostHurtEffects(@Nonnull LivingEntity entity) {
    super.doPostHurtEffects(entity);
    entity.setArrowCount(entity.getArrowCount() - 1);
  }

  public void setKnockback(int knockback) {
    this.knockback = knockback;
  }

  @Override
  protected void doKnockback(@Nonnull LivingEntity entity, @Nonnull DamageSource damageSource) {
    if (knockback > 0.0) {
      double d1 = Math.max(0.0, 1.0 - entity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
      Vec3 vec3 =
          this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
      if (vec3.lengthSqr() > 0.0) {
        entity.push(vec3.x, 0.1, vec3.z);
      }
    }
  }

  @Override
  public void tick() {
    super.tick();
    Level level = this.level();
    if (level instanceof ServerLevel serverLevel) {
      serverLevel.sendParticles(
          SoulParticleTypes.SINN_L_PARTICLE.get(),
          this.getX(),
          this.getY(),
          this.getZ(),
          10,
          0.1,
          0.1,
          0.1,
          0.02);
    }
    if (this.isInGround()) this.discard();
  }
}
