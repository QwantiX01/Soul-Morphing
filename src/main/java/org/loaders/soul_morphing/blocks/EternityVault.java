package org.loaders.soul_morphing.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;
import org.loaders.soul_morphing.util.Souls;

import java.util.HashMap;

import static org.loaders.soul_morphing.Soul_morphing.MODID;


public class EternityVault extends BaseEntityBlock {
    private static final VoxelShape SHAPE = BaseEntityBlock.box(0, 0, 0, 16, 16, 16);
    public static final IntegerProperty SOULS_COUNT = IntegerProperty.create("souls_count", 0, 500);

    protected EternityVault() {
        super(BlockBehaviour.Properties.of()
                .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse(String.format("%s:%s", MODID, "eternity_vault"))))
                .noOcclusion()
        );

        this.registerDefaultState(this.getStateDefinition().any().setValue(SOULS_COUNT, 1));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(SOULS_COUNT);
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        System.out.println(state.getValue(SOULS_COUNT));
        state.setValue(SOULS_COUNT,  state.getValue(SOULS_COUNT) + 1);
        if (entity instanceof Player player)
            if (player.isShiftKeyDown() && Souls.trySubtractSouls(player, 1) && state.getValue(SOULS_COUNT) + 1 <= 500) {
                state.setValue(SOULS_COUNT,  1);
            } else if (state.getValue(SOULS_COUNT) - 1 >= 0 && Souls.getSouls(player) + 1 <= Souls.getMaxSouls(player)) {
                state.setValue(SOULS_COUNT, state.getValue(SOULS_COUNT) - 1);
                Souls.addSouls(player, 1);
            }
    }


    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    protected RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return null;
    }


    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return null;
    }
}

