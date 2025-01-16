package org.loaders.soul_morphing.blocks.animated.entity;

import io.netty.buffer.Unpooled;
import java.util.stream.IntStream;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.wrapper.SidedInvWrapper;
import org.loaders.soul_morphing.hud.VoidFurnaceGuiMenu;
import org.loaders.soul_morphing.init.SoulBlocksEntities;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.util.GeckoLibUtil;
import software.bernie.geckolib.util.RenderUtil;

public class VoidFurnaceBlockEntity extends RandomizableContainerBlockEntity
    implements GeoAnimatable, WorldlyContainer {
  public static final RawAnimation IDLE_ANIM = RawAnimation.begin().thenLoop("0");
  public static final RawAnimation BURNING_ANIM = RawAnimation.begin().thenLoop("1");

  private NonNullList<ItemStack> stacks = NonNullList.withSize(3, ItemStack.EMPTY);
  private final SidedInvWrapper handler = new SidedInvWrapper(this, Direction.NORTH);

  private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

  public VoidFurnaceBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState blockState) {
    super(SoulBlocksEntities.VOID_FURNACE_ENTITY.get(), pos, blockState);
  }

  public VoidFurnaceBlockEntity(BlockPos blockPos, BlockState blockState) {
    this(SoulBlocksEntities.VOID_FURNACE_ENTITY.get(), blockPos, blockState);
  }

  @Override
  protected void loadAdditional(
      @Nonnull CompoundTag tag, @Nonnull HolderLookup.Provider registries) {
    super.loadAdditional(tag, registries);
  }

  @Override
  protected void saveAdditional(
      @Nonnull CompoundTag tag, @Nonnull HolderLookup.Provider registries) {
    super.saveAdditional(tag, registries);
  }

  @Override
  protected void setItems(@Nonnull NonNullList<ItemStack> nonNullList) {}

  @Override
  protected AbstractContainerMenu createMenu(int i, @Nonnull Inventory inventory) {
    return new VoidFurnaceGuiMenu(
        i, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(this.worldPosition));
  }

  protected <E extends VoidFurnaceBlockEntity> PlayState deployAnimController(
      final AnimationState<E> state) {
    state.setAnimation(IDLE_ANIM);
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

  @Override
  protected Component getDefaultName() {
    return Component.literal("void_furnace");
  }

  @Override
  protected NonNullList<ItemStack> getItems() {
    return this.stacks;
  }

  @Override
  public int[] getSlotsForFace(@Nonnull Direction direction) {
    return IntStream.range(0, this.getContainerSize()).toArray();
  }

  @Override
  public boolean canPlaceItemThroughFace(
      int i, @Nonnull ItemStack itemStack, @Nullable Direction direction) {
    return this.canPlaceItem(i, itemStack);
  }

  @Override
  public boolean canTakeItemThroughFace(
      int i, @Nonnull ItemStack itemStack, @Nonnull Direction direction) {
    return true;
  }

  @Override
  public int getContainerSize() {
    return stacks.size();
  }

  public SidedInvWrapper getItemHandler() {
    return handler;
  }

  @Override
  public boolean isEmpty() {
    for (ItemStack itemstack : this.stacks) if (!itemstack.isEmpty()) return false;
    return true;
  }

  @Override
  public ClientboundBlockEntityDataPacket getUpdatePacket() {
    return ClientboundBlockEntityDataPacket.create(this);
  }
}
