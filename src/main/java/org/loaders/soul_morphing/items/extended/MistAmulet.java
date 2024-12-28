package org.loaders.soul_morphing.items.extended;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
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

public class MistAmulet extends Item {
    private static final RandomSource random = RandomSource.create();
    private static float sphereRadius = 0.0f;
    private static final float MAX_RADIUS = 10.0f; // Match the area size
    private static final float EXPANSION_RATE = 0.5f;
    private static boolean isExpanding = false;

    public MistAmulet(Properties properties) {
        super(properties
                .stacksTo(1)
                .useCooldown(5));
    }

    private void spawnExpandingFireworkSphere(Level level, BlockPos pos, Player player) {
        if (level instanceof ServerLevel serverLevel) {
            // Reset sphere if it's not expanding
            if (!isExpanding) {
                sphereRadius = 0.0f;
                isExpanding = true;
            }

            // Calculate points on sphere surface
            int particles = 50; // Number of particles per frame
            for (int i = 0; i < particles; i++) {
                // Generate points on sphere surface using spherical coordinates
                double phi = random.nextDouble() * 2 * Math.PI;
                double theta = random.nextDouble() * Math.PI;

                // Convert spherical to Cartesian coordinates
                double x = Math.sin(theta) * Math.cos(phi) * sphereRadius;
                double y = Math.sin(theta) * Math.sin(phi) * sphereRadius;
                double z = Math.cos(theta) * sphereRadius;

                // Base position (player position)
                double baseX = player.getX();
                double baseY = player.getY() + 1.0;
                double baseZ = player.getZ();

                // Calculate outward velocity for expansion effect
                double velocityX = x / sphereRadius * 0.1;
                double velocityY = y / sphereRadius * 0.1;
                double velocityZ = z / sphereRadius * 0.1;

                // Spawn particles on sphere surface
                serverLevel.sendParticles(
                        ParticleTypes.SOUL_FIRE_FLAME,
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

            // Increase sphere radius
            sphereRadius += EXPANSION_RATE;

            // Reset when reaching max radius
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
        spawnExpandingFireworkSphere(level, player.blockPosition(), player);

        int area = 10; //Blocks
        List<Entity> entities = level.getEntities(player, new AABB(
                player.getX() - area, player.getY() - area, player.getZ() - area,
                player.getX() + area, player.getY() + area, player.getZ() + area
        ));

        for (Entity entity : entities) {
            if (entity instanceof Projectile || entity instanceof Enemy) {
                Vec3 directionalVector = new Vec3(player.getX() - entity.getX(), player.getY() - entity.getY(), player.getZ() - entity.getZ());
                double distance = directionalVector.length();
                Vec3 stepVector = new Vec3((directionalVector.x / distance) * 4, (directionalVector.y / distance) * 4, (directionalVector.z / distance) * 4);
                entity.lerpMotion(stepVector.x, 0.7, stepVector.z);
            }
        }

        return super.use(level, player, hand);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, level, entity, slot, selected);

        // Continue expanding sphere effect while active
        if (isExpanding && entity instanceof Player player) {
            spawnExpandingFireworkSphere(level, player.blockPosition(), player);
        }
    }
}