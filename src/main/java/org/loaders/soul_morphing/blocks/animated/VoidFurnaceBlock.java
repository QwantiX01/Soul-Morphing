package org.loaders.soul_morphing.blocks.animated;

import static org.loaders.soul_morphing.Soul_morphing.MODID;

import com.mojang.serialization.MapCodec;
import io.netty.buffer.Unpooled;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nonnull;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.loaders.soul_morphing.hud.VoidFurnaceGuiMenu;
import org.loaders.soul_morphing.init.SoulBlocksEntities;

public class VoidFurnaceBlock extends BaseEntityBlock {
  public static final IntegerProperty ANIMATION = IntegerProperty.create("animation", 0, 1);

  public static final MapCodec<VoidFurnaceBlock> CODEC =
      simpleCodec(properties -> new VoidFurnaceBlock());

  public @NotNull MapCodec<VoidFurnaceBlock> codec() {
    return CODEC;
  }

  public VoidFurnaceBlock() {
    super(
        Properties.of()
            .setId(
                ResourceKey.create(
                    Registries.BLOCK,
                    ResourceLocation.parse(String.format("%s:%s", MODID, "void_furnace"))))
            .noOcclusion());
  }

  @Override
  protected InteractionResult useWithoutItem(
      @Nonnull BlockState state,
      @Nonnull Level level,
      @Nonnull BlockPos pos,
      @Nonnull Player player,
      @Nonnull BlockHitResult hitResult) {
    player.openMenu(
        new MenuProvider() {
          @Override
          public Component getDisplayName() {
            return Component.literal("Eternity Vault");
          }

          @Override
          public AbstractContainerMenu createMenu(
              int id, @Nonnull Inventory inventory, @Nonnull Player player) {
            return new VoidFurnaceGuiMenu(
                id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(pos));
          }
        },
        pos);

    return InteractionResult.SUCCESS;
  }

  @Override
  protected @NotNull RenderShape getRenderShape(@Nonnull BlockState state) {
    return RenderShape.ENTITYBLOCK_ANIMATED;
  }

  @Nullable
  @Override
  public BlockEntity newBlockEntity(@Nonnull BlockPos blockPos, @Nonnull BlockState blockState) {
    return SoulBlocksEntities.VOID_FURNACE_ENTITY.get().create(blockPos, blockState);
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
  protected void tick(
      @Nonnull BlockState state,
      @Nonnull ServerLevel level,
      @Nonnull BlockPos pos,
      @Nonnull RandomSource random) {
    super.tick(state, level, pos, random);
  }
}
