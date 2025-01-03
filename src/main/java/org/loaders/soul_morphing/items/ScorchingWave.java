package org.loaders.soul_morphing.items;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.loaders.soul_morphing.util.Souls;

import java.util.List;
import java.util.Optional;

import static org.loaders.soul_morphing.Soul_morphing.MODID;
import static org.loaders.soul_morphing.init.SoulItems.ITEMS;

public class ScorchingWave extends Item {
    public ScorchingWave(Properties properties) {
        super(properties
                .setId(ResourceKey.create(ITEMS.getRegistryKey(), ResourceLocation.fromNamespaceAndPath(MODID, "scorching_wave")))
                .stacksTo(1)
                .useCooldown(5));
    }

    private static final RandomSource random = RandomSource.create();
    private static float sphereRadius = 0.0f;
    private static final float MAX_RADIUS = 10.0f; // Match the area size
    private static final float EXPANSION_RATE = 0.5f;
    private static boolean isExpanding = false;

    private void spawnExpandingFireSphere(Level level, BlockPos pos, Player player) {
        if (level instanceof ServerLevel serverLevel) {
            if (!isExpanding) {
                sphereRadius = 0.0f;
                isExpanding = true;
            }

            int particles = 50;
            for (int i = 0; i < particles; i++) {
                double phi = random.nextDouble() * 2 * Math.PI;
                double theta = random.nextDouble() * Math.PI;
                double x = Math.sin(theta) * Math.cos(phi) * sphereRadius;
                double y = Math.sin(theta) * Math.sin(phi) * sphereRadius;
                double z = Math.cos(theta) * sphereRadius;
                double baseX = player.getX();
                double baseY = player.getY() + 1.0;
                double baseZ = player.getZ();
                double velocityX = x / sphereRadius * 0.1;
                double velocityY = y / sphereRadius * 0.1;
                double velocityZ = z / sphereRadius * 0.1;
                serverLevel.sendParticles(
                        ParticleTypes.FLAME,
                        baseX + x,
                        baseY + y,
                        baseZ + z,
                        1,
                        velocityX,
                        velocityY,
                        velocityZ,
                        0.02
                );
            }
            sphereRadius += EXPANSION_RATE;
            if (sphereRadius >= MAX_RADIUS) {
                isExpanding = false;
                sphereRadius = 0.0f;
            }
        }
    }

    @Override
    public @NotNull InteractionResult use(Level level, @NotNull Player player, @NotNull InteractionHand hand) {
        boolean enoughSouls = Souls.trySubtractSouls(player, 8);
        if (!enoughSouls)
            return InteractionResult.PASS;

        player.playSound(new SoundEvent(ResourceLocation.withDefaultNamespace("block.beacon.activate"), Optional.of(10f)));
        player.startUsingItem(hand);

        // Spawn particles and continue expanding for multiple ticks
        spawnExpandingFireSphere(level, player.blockPosition(), player);

        int area = 10; //Blocks
        List<Entity> entities = level.getEntities(player, new AABB(
                player.getX() - area, player.getY() - area, player.getZ() - area,
                player.getX() + area, player.getY() + area, player.getZ() + area
        ));

        for (Entity entity : entities) {
            if (entity instanceof Projectile || entity instanceof Enemy) {
                entity.setRemainingFireTicks(600);
                entity.hurt(entity.damageSources().playerAttack(player), 8);
            }
        }

        return super.use(level, player, hand);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, level, entity, slot, selected);
        if (isExpanding && entity instanceof Player player) {
            spawnExpandingFireSphere(level, player.blockPosition(), player);
        }
    }
}
