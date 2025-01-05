package org.loaders.soul_morphing.entity.custom;

import net.minecraft.core.particles.ParticleTypes;
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

import javax.annotation.Nullable;

@OnlyIn(value = Dist.CLIENT, _interface = ItemSupplier.class)
public class SinnerHeavySphereEntity extends AbstractArrow implements ItemSupplier {

    public static final ItemStack PROJECTILE_ITEM = new ItemStack(Blocks.AIR);
    private int knockback = 0;

    public SinnerHeavySphereEntity(EntityType<? extends SinnerHeavySphereEntity> type, Level world) {
        super(type, world);
    }

    public SinnerHeavySphereEntity(EntityType<? extends SinnerHeavySphereEntity> type, double x, double y, double z, Level world, @Nullable ItemStack firedFromWeapon) {
        super(type, x, y, z, world, PROJECTILE_ITEM, firedFromWeapon);
    }

    public SinnerHeavySphereEntity(EntityType<? extends SinnerHeavySphereEntity> type, LivingEntity entity, Level world, @Nullable ItemStack firedFromWeapon) {
        super(type, entity, world, PROJECTILE_ITEM, firedFromWeapon);
    }

    public static SinnerHeavySphereEntity shoot(Level world, LivingEntity entity, RandomSource source) {
        return shoot(world, entity, source, 1f, 5, 5);
    }

    public static SinnerHeavySphereEntity shoot(Level world, LivingEntity entity, RandomSource source, float pullingPower) {
        return shoot(world, entity, source, pullingPower, 5, 5);
    }

    public static SinnerHeavySphereEntity shoot(Level world, LivingEntity entity, RandomSource random, float power, double damage, int knockback) {
        SinnerHeavySphereEntity entityarrow = new SinnerHeavySphereEntity(SoulEntities.SINNER_HEAVY_SHPERE.get(), entity, world, null);
        entityarrow.shoot(entity.getViewVector(1).x, entity.getViewVector(1).y, entity.getViewVector(1).z, power * 2, 0);
        entityarrow.setSilent(true);
        entityarrow.setCritArrow(false);
        entityarrow.setBaseDamage(damage);
        entityarrow.setKnockback(knockback);
        world.addFreshEntity(entityarrow);
        return entityarrow;
    }

    public static SinnerHeavySphereEntity shoot(LivingEntity entity, LivingEntity target) {
        SinnerHeavySphereEntity entityarrow = new SinnerHeavySphereEntity(SoulEntities.SINNER_HEAVY_SHPERE.get(), entity, entity.level(), null);
        double dx = target.getX() - entity.getX();
        double dy = target.getY() + target.getEyeHeight() - 1.1;
        double dz = target.getZ() - entity.getZ();
        entityarrow.shoot(dx, dy - entityarrow.getY() + Math.hypot(dx, dz) * 0.2F, dz, 1f * 2, 12.0F);
        entityarrow.setSilent(true);
        entityarrow.setBaseDamage(5);
        entityarrow.setKnockback(5);
        entityarrow.setCritArrow(false);
        entity.level().addFreshEntity(entityarrow);
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
    protected void doPostHurtEffects(LivingEntity entity) {
        super.doPostHurtEffects(entity);
        entity.setArrowCount(entity.getArrowCount() - 1);
    }

    public void setKnockback(int knockback) {
        this.knockback = knockback;
    }

    @Override
    protected void doKnockback(LivingEntity entity, DamageSource damageSource) {
        if (knockback > 0.0) {
            double d1 = Math.max(0.0, 1.0 - entity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
            Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
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
            for (int sphereRadius = 0; sphereRadius < 10; sphereRadius++) {
                int particles = 50;
                for (int i = 0; i < particles; i++) {
                    double phi = random.nextDouble() * 2 * Math.PI;
                    double theta = random.nextDouble() * Math.PI;
                    double x = Math.sin(theta) * Math.cos(phi) * sphereRadius;
                    double y = Math.sin(theta) * Math.sin(phi) * sphereRadius;
                    double z = Math.cos(theta) * sphereRadius;
                    double baseX = this.getX();
                    double baseY = this.getY() + 1.0;
                    double baseZ = this.getZ();
                    double velocityX = x / sphereRadius * 0.1;
                    double velocityY = y / sphereRadius * 0.1;
                    double velocityZ = z / sphereRadius * 0.1;
                    serverLevel.sendParticles(
                            ParticleTypes.FLAME,
                            baseX + x,
                            baseY + y,
                            baseZ + z,
                            1, // particle count
                            velocityX,
                            velocityY,
                            velocityZ,
                            0.02 // speed
                    );
                }

            }
//            serverLevel.sendParticles(
//                    ParticleTypes.FLAME,
//                    this.getX(),
//                    this.getY(),
//                    this.getZ(),
//                    7,
//                    0.1,
//                    0.1,
//                    0.1,
//                    0.02
//            );
        }
        if (this.isInGround())
            this.discard();
    }
}