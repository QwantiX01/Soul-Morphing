package org.loaders.soul_morphing.blocks.entities;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import org.loaders.soul_morphing.blocks.SoulBlocksEntities;
import org.loaders.soul_morphing.blocks.extended.animated.EternityVaultBlock;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.util.GeckoLibUtil;
import software.bernie.geckolib.util.RenderUtil;


public class EternityVaultBlockEntity extends BlockEntity implements GeoAnimatable {
    public int souls;
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public EternityVaultBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState blockState) {
        super(SoulBlocksEntities.ETERNITY_VAULT_ENTITY.get(), pos, blockState);
    }

    public EternityVaultBlockEntity(BlockPos blockPos, BlockState blockState) {
        this(SoulBlocksEntities.ETERNITY_VAULT_ENTITY.get(), blockPos, blockState);
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        this.souls = tag.getInt("souls");
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        tag.putInt("souls", this.souls);
    }

    public int getSouls() {
        return this.souls;
    }

    public void setSouls(int souls) {
        this.souls = souls;
        this.setChanged();
    }
// DFRTGVYBUHNIJKJMOJNHBUGFVFCTFDRXERXCTYVUBIOK<KMGHYVFJHFTGVUJTFGITUYFIKIBUFYIBFUYHGFIUBHGYFGIBUHIFBGHK

    private PlayState predicate(AnimationState event) {
        String animationprocedure = ("" + this.getBlockState().getValue(EternityVaultBlock.ANIMATION));
        if (animationprocedure.equals("0")) {
            return event.setAndContinue(RawAnimation.begin().thenLoop(animationprocedure));
        }
        return PlayState.STOP;
    }

    String prevAnim = "0";

    private PlayState procedurePredicate(AnimationState event) {
        String animationprocedure = ("" + this.getBlockState().getValue(EternityVaultBlock.ANIMATION));
        if (!animationprocedure.equals("0") && event.getController().getAnimationState() == AnimationController.State.STOPPED || (!animationprocedure.equals(prevAnim) && !animationprocedure.equals("0"))) {
            if (!animationprocedure.equals(prevAnim))
                event.getController().forceAnimationReset();
            event.getController().setAnimation(RawAnimation.begin().thenPlay(animationprocedure));
            if (event.getController().getAnimationState() == AnimationController.State.STOPPED) {
                if (this.getBlockState().getBlock().getStateDefinition().getProperty("animation") instanceof IntegerProperty _integerProp)
                    level.setBlock(this.getBlockPos(), this.getBlockState().setValue(_integerProp, 0), 3);
                event.getController().forceAnimationReset();
            }
        } else if (animationprocedure.equals("0")) {
            prevAnim = "0";
            return PlayState.STOP;
        }
        prevAnim = animationprocedure;
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "controller", 0, this::predicate));
        controllers.add(new AnimationController<>(this, "procedurecontroller", 0, this::procedurePredicate));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }

    @Override
    public double getTick(Object object) {
        return level != null ? RenderUtil.getCurrentTick() : 0.0D;
    }
}

