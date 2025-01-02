package org.loaders.soul_morphing.blocks.animated.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.loaders.soul_morphing.blocks.animated.EternityVaultMode;
import org.loaders.soul_morphing.init.SoulBlocksEntities;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.util.GeckoLibUtil;
import software.bernie.geckolib.util.RenderUtil;

import static org.loaders.soul_morphing.blocks.animated.EternityVaultMode.*;


public class EternityVaultBlockEntity extends BlockEntity implements GeoAnimatable {
    public int souls;
    public int mode;
    public static final RawAnimation OUTCOME_ANIM = RawAnimation.begin().thenLoop("0");
    public static final RawAnimation INCOME_ANIM = RawAnimation.begin().thenLoop("1");
    public static final RawAnimation IDLE_ANIM = RawAnimation.begin().thenLoop("2");

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
        this.mode = tag.getInt("mode");
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

    public void setMode(EternityVaultMode mode) {
        this.mode = switch (mode) {
            case OUTCOME -> 0;
            case INCOME -> 1;
            case IDLE -> 2;
        };
        this.setChanged();
    }


    public EternityVaultMode getMode() {
        switch (mode) {
            case 0 -> {
                return OUTCOME;
            }
            case 1 -> {
                return INCOME;
            }
            default -> {
                return IDLE;
            }
        }

    }

    public void flipMode() {
        this.mode = (this.mode + 1) % 3;
        this.setChanged();
    }

    // DFRTGVYBUHNIJKJMOJNHBUGFVFCTFDRXERXCTYVUBIOK<KMGHYVFJHFTGVUJTFGITUYFIKIBUFYIBFUYHGFIUBHGYFGIBUHIFBGHK


    protected <E extends EternityVaultBlockEntity> PlayState deployAnimController(final AnimationState<E> state) {
        switch (this.mode) {
            case 0 -> state.setAnimation(OUTCOME_ANIM);
            case 1 -> state.setAnimation(INCOME_ANIM);
            case 2 -> state.setAnimation(IDLE_ANIM);
        }
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "deploy", 0, this::deployAnimController));
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

