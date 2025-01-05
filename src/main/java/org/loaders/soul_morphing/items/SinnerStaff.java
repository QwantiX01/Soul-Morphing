package org.loaders.soul_morphing.items;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import org.loaders.soul_morphing.entity.custom.SinnerSphereEntity;
import org.loaders.soul_morphing.init.SoulEntities;

import static org.loaders.soul_morphing.Soul_morphing.MODID;
import static org.loaders.soul_morphing.init.SoulItems.ITEMS;
import static org.loaders.soul_morphing.init.SoulItems.SINNER_BALL;

public class SinnerStaff extends Item {
    private static int mode = 0;
    //Mode 0: Small/Fast/Cheap
    //Mode 1: Big/Slow/Expensive

    public SinnerStaff(Properties properties) {
        super(properties.setId(ResourceKey.create(ITEMS.getRegistryKey(), ResourceLocation.fromNamespaceAndPath(MODID, "sinners_staff"))));
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide) {
            if (player.isShiftKeyDown()) {
                changeMode();
                player.displayClientMessage(Component.literal("Mode: " + mode), true);
            }

            switch (mode) {
                case 0 -> {
                    Entity _shootFrom = player;
                    Level projectileLevel = _shootFrom.level();
                    if (!projectileLevel.isClientSide()) {
                        Projectile _entityToSpawn = new Object() {
                            public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
                                AbstractArrow entityToSpawn = new SinnerSphereEntity(SoulEntities.SINNER_SHPERE.get(), level) {
                                    @Override
                                    public byte getPierceLevel() {
                                        return piercing;
                                    }

                                    @Override
                                    protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
                                        if (knockback > 0) {
                                            super.doKnockback(livingEntity, damageSource);
                                        }
                                    }
                                };
                                entityToSpawn.setBaseDamage(damage);
                                entityToSpawn.setSilent(true);
                                return entityToSpawn;
                            }
                        }.getArrow(projectileLevel, 5, 1, (byte) 1);

                        _entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY(), _shootFrom.getZ());
                        _entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 3, 0);
                        projectileLevel.addFreshEntity(_entityToSpawn);
                    }

                    return InteractionResult.SUCCESS;
                }
                case 1 -> {
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
