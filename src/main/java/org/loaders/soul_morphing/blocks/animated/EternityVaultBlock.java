package org.loaders.soul_morphing.blocks.animated;

import static org.loaders.soul_morphing.Soul_morphing.MODID;

import com.mojang.serialization.MapCodec;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nonnull;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.phys.BlockHitResult;
import net.neoforged.neoforge.network.PacketDistributor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.loaders.soul_morphing.blocks.animated.entity.EternityVaultBlockEntity;
import org.loaders.soul_morphing.init.SoulBlocksEntities;
import org.loaders.soul_morphing.network.SoulsData;
import org.loaders.soul_morphing.util.Souls;

public class EternityVaultBlock extends BaseEntityBlock {
  public static final IntegerProperty ANIMATION = IntegerProperty.create("animation", 0, 1);
  public static final MapCodec<EternityVaultBlock> CODEC =
      simpleCodec(properties -> new EternityVaultBlock());

  public @NotNull MapCodec<EternityVaultBlock> codec() {
    return CODEC;
  }

  public EternityVaultBlock() {
    super(
        BlockBehaviour.Properties.of()
            .setId(
                ResourceKey.create(
                    Registries.BLOCK,
                    ResourceLocation.parse(String.format("%s:%s", MODID, "eternity_vault"))))
            .noOcclusion());
  }

  @Override
  protected @NotNull RenderShape getRenderShape(@Nonnull BlockState state) {
    return RenderShape.ENTITYBLOCK_ANIMATED;
  }

  @Nullable
  @Override
  public BlockEntity newBlockEntity(@Nonnull BlockPos blockPos, @Nonnull BlockState blockState) {
    return SoulBlocksEntities.ETERNITY_VAULT_ENTITY.get().create(blockPos, blockState);
  }

  @Override
  protected void createBlockStateDefinition(
      @Nonnull StateDefinition.Builder<Block, BlockState> builder) {
    builder.add(ANIMATION);
  }

  @Override
  public List<ItemStack> getDrops(@Nonnull BlockState state, @Nonnull LootParams.Builder builder) {

    List<ItemStack> dropsOriginal = super.getDrops(state, builder);
    if (!dropsOriginal.isEmpty()) return dropsOriginal;
    return Collections.singletonList(new ItemStack(this, 1));
  }

  @Override
  protected InteractionResult useWithoutItem(
      @Nonnull BlockState state,
      @Nonnull Level level,
      @Nonnull BlockPos pos,
      @Nonnull Player player,
      @Nonnull BlockHitResult hitResult) {

    if (level.isClientSide
        && level.getBlockEntity(hitResult.getBlockPos())
            instanceof EternityVaultBlockEntity blockEntity) {
      blockEntity.flipMode();
    }
    return InteractionResult.SUCCESS;
  }

  @Override
  public void stepOn(
      @Nonnull Level level,
      @Nonnull BlockPos pos,
      @Nonnull BlockState state,
      @Nonnull Entity entity) {
    if (entity instanceof Player player) {
      if (level.isClientSide
          && level.getBlockEntity(pos) instanceof EternityVaultBlockEntity blockEntity) {
        switch (blockEntity.getMode()) {
          case INCOME -> {
            if (Souls.getSouls(player) - 1 >= 0 && blockEntity.getSouls() + 1 <= 500) {
              // Send packet to server if called on client, otherwise directly add souls on server.
              PacketDistributor.sendToServer(
                  new SoulsData(Souls.getSouls(player) - 1, Souls.getMaxSouls(player)));
              blockEntity.setSouls(blockEntity.getSouls() + 1);
            }
          }
          case OUTCOME -> {
            if (Souls.getSouls(player) + 1 <= Souls.getMaxSouls(player)
                && blockEntity.getSouls() - 1 >= 0) {
              // Send packet to server if called on client, otherwise directly add souls on server.
              PacketDistributor.sendToServer(
                  new SoulsData(Souls.getSouls(player) + 1, Souls.getMaxSouls(player)));
              blockEntity.setSouls(blockEntity.getSouls() - 1);
            }
          }
          default ->
              throw new IllegalArgumentException("Unexpected value: " + blockEntity.getMode());
        }
      }
    }
  }

  @Override
  protected void tick(
      @Nonnull BlockState state,
      @Nonnull ServerLevel level,
      @Nonnull BlockPos pos,
      @Nonnull RandomSource random) {
    super.tick(state, level, pos, random);
  }
}
