package org.loaders.soul_morphing.entity.custom;

import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;


public class SpiritHoundEntity extends Monster {
    public static final AnimationState IDLE_ANIMATION_STATE = new AnimationState();
    public static final AnimationState WALK_ANIMATION_STATE = new AnimationState();
    public static final AnimationState ATTACK_ANIMATION_STATE = new AnimationState();
    public static int animationTimeout = 0;

    public SpiritHoundEntity(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier.@NotNull Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.FOLLOW_RANGE, 35.0)
                .add(Attributes.MOVEMENT_SPEED, 0.16F)
                .add(Attributes.ATTACK_DAMAGE, 4.3)
                .add(Attributes.ATTACK_SPEED, 2.0)
                .add(Attributes.ARMOR, 2.0);
    }

    @Override
    public void aiStep() {
        super.aiStep();
    }

    public void setupAnimations() {
        if (attackAnim > 0 && !ATTACK_ANIMATION_STATE.isStarted()) {
            ATTACK_ANIMATION_STATE.start(this.tickCount);
        }else if (attackAnim == 0 && ATTACK_ANIMATION_STATE.isStarted()) {
            ATTACK_ANIMATION_STATE.stop();
        }
        else if (walkAnimation.isMoving() || attackAnim > 0) {
            IDLE_ANIMATION_STATE.stop();
        } else {
            IDLE_ANIMATION_STATE.startIfStopped(this.tickCount);
        }
    }

    @Override
    public void tick() {
        super.tick();
        if (this.level().isClientSide()) {
            setupAnimations();
        }
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();

        this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this).setAlertOthers(this.getClass()));
        this.targetSelector.addGoal(0, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(0, new MeleeAttackGoal(this, 1, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, false));

    }

}
