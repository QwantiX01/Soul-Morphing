package org.loaders.soul_morphing.hud;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import javax.annotation.Nonnull;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.items.ItemStackHandler;
import net.neoforged.neoforge.items.SlotItemHandler;
import net.neoforged.neoforge.items.wrapper.InvWrapper;
import org.loaders.soul_morphing.init.SoulMenus;

@SuppressWarnings("all")
public class VoidFurnaceGuiMenu extends AbstractContainerMenu
    implements Supplier<Map<Integer, Slot>> {
  public static final HashMap<String, Object> guistate = new HashMap<>();
  public final Level world;
  public final Player entity;
  public int x, y, z;
  private ContainerLevelAccess access = ContainerLevelAccess.NULL;
  private IItemHandler internal;
  private final Map<Integer, Slot> customSlots = new HashMap<>();
  private boolean bound = false;
  private Supplier<Boolean> boundItemMatcher = null;
  private Entity boundEntity = null;
  private BlockEntity boundBlockEntity = null;

  public VoidFurnaceGuiMenu(int id, Inventory inv, FriendlyByteBuf extraData) {
    super(SoulMenus.VOID_FURNACE_GUI.get(), id);
    this.entity = inv.player;
    this.world = inv.player.level();
    this.internal = new ItemStackHandler(3);
    BlockPos pos = null;

    if (extraData != null) {
      pos = extraData.readBlockPos();
      this.x = pos.getX();
      this.y = pos.getY();
      this.z = pos.getZ();
      access = ContainerLevelAccess.create(world, pos);

      if (pos != null) {
        if (extraData.readableBytes() == 1) { // bound to item
          byte hand = extraData.readByte();
          ItemStack itemstack =
              hand == 0 ? this.entity.getMainHandItem() : this.entity.getOffhandItem();
          this.boundItemMatcher =
              () ->
                  itemstack
                      == (hand == 0 ? this.entity.getMainHandItem() : this.entity.getOffhandItem());
          IItemHandler cap = itemstack.getCapability(Capabilities.ItemHandler.ITEM);
          if (cap != null) {
            this.internal = cap;
            this.bound = true;
          }
        } else if (extraData.readableBytes() > 1) { // bound to entity
          extraData.readByte(); // drop padding
          boundEntity = world.getEntity(extraData.readVarInt());
          if (boundEntity != null) {
            IItemHandler cap = boundEntity.getCapability(Capabilities.ItemHandler.ENTITY);
            if (cap != null) {
              this.internal = cap;
              this.bound = true;
            }
          }
        } else { // might be bound to block
          boundBlockEntity = this.world.getBlockEntity(pos);
          if (boundBlockEntity instanceof BaseContainerBlockEntity baseContainerBlockEntity) {
            this.internal = new InvWrapper(baseContainerBlockEntity);
            this.bound = true;
          }
        }
      }
    }
    this.customSlots.put(
        0,
        this.addSlot(
            new SlotItemHandler(internal, 0, 43, 41) {
              private final int slot = 0;
              private int x = VoidFurnaceGuiMenu.this.x;
              private int y = VoidFurnaceGuiMenu.this.y;
            }));
    this.customSlots.put(
        1,
        this.addSlot(
            new SlotItemHandler(internal, 1, 13, 41) {
              private final int slot = 1;
              private int x = VoidFurnaceGuiMenu.this.x;
              private int y = VoidFurnaceGuiMenu.this.y;
            }));
    this.customSlots.put(
        2,
        this.addSlot(
            new SlotItemHandler(internal, 2, 102, 41) {
              private final int slot = 2;
              private int x = VoidFurnaceGuiMenu.this.x;
              private int y = VoidFurnaceGuiMenu.this.y;

              @Override
              public boolean mayPlace(@Nonnull ItemStack stack) {
                return false;
              }
            }));

    for (int si = 0; si < 3; ++si)
      for (int sj = 0; sj < 9; ++sj)
        this.addSlot(new Slot(inv, sj + (si + 1) * 9, 8 + sj * 18, 84 + si * 18));

    for (int si = 0; si < 9; ++si) this.addSlot(new Slot(inv, si, 8 + si * 18, 142));
  }

  @Override
  public boolean stillValid(@Nonnull Player player) {
    if (this.bound) {
      if (this.boundItemMatcher != null) return this.boundItemMatcher.get();
      else if (this.boundBlockEntity != null)
        return AbstractContainerMenu.stillValid(
            this.access, player, this.boundBlockEntity.getBlockState().getBlock());
      else if (this.boundEntity != null) return this.boundEntity.isAlive();
    }
    return true;
  }

  @Override
  public ItemStack quickMoveStack(@Nonnull Player playerIn, int index) {
    ItemStack itemstack = ItemStack.EMPTY;

    Slot slot = this.slots.get(index);

    if (slot.hasItem()) {
      ItemStack slotItemStack = slot.getItem();
      itemstack = slotItemStack.copy();
      if (index < 3) {
        if (!this.moveItemStackTo(slotItemStack, 3, this.slots.size(), true))
          return ItemStack.EMPTY;
        slot.onQuickCraft(slotItemStack, itemstack);
      } else if (!this.moveItemStackTo(slotItemStack, 0, 3, false)) {
        if (index < 3 + 27) {
          if (!this.moveItemStackTo(slotItemStack, 3 + 27, this.slots.size(), true))
            return ItemStack.EMPTY;
        } else {
          if (!this.moveItemStackTo(slotItemStack, 3, 3 + 27, false)) return ItemStack.EMPTY;
        }
        return ItemStack.EMPTY;
      }
      if (slotItemStack.getCount() == 0) slot.set(ItemStack.EMPTY);
      else slot.setChanged();
      if (slotItemStack.getCount() == itemstack.getCount()) return ItemStack.EMPTY;
      slot.onTake(playerIn, slotItemStack);
    }
    return itemstack;
  }

  @Override
  protected boolean moveItemStackTo(
      @Nonnull ItemStack itemStack, int startIndex, int endIndex, boolean reverseDirection) {
    boolean flag = false;
    int i = startIndex;
    if (reverseDirection) {
      i = endIndex - 1;
    }
    if (itemStack.isStackable()) {
      // try to combine with existing stacks
      while (!itemStack.isEmpty() && (reverseDirection ? i >= startIndex : i < endIndex)) {
        Slot slot = this.slots.get(i);
        ItemStack itemstack = slot.getItem();
        if (slot.mayPlace(itemstack)
            && !itemstack.isEmpty()
            && ItemStack.isSameItemSameComponents(itemStack, itemstack)) {
          int j = itemstack.getCount() + itemStack.getCount();
          int k = slot.getMaxStackSize(itemstack);
          if (j <= k) {
            // combine into a single stack
            itemStack.setCount(0);
            itemstack.setCount(j);
            slot.set(itemstack);
            flag = true;
          } else if (itemstack.getCount() < k) {
            // split into two stacks
            itemStack.shrink(k - itemstack.getCount());
            itemstack.setCount(k);
            slot.set(itemstack);
            flag = true;
          }
        }
        if (reverseDirection) {
          i--;
        } else {
          i++;
        }
      }
    }
    if (!itemStack.isEmpty()) {
      // try to place in an empty slot
      if (reverseDirection) {
        i = endIndex - 1;
      } else {
        i = startIndex;
      }
      while (reverseDirection ? i >= startIndex : i < endIndex) {
        Slot slot1 = this.slots.get(i);
        ItemStack itemstack1 = slot1.getItem();
        if (itemstack1.isEmpty() && slot1.mayPlace(itemStack)) {
          // place in an empty slot
          int l = slot1.getMaxStackSize(itemStack);
          slot1.setByPlayer(itemStack.split(Math.min(itemStack.getCount(), l)));
          slot1.setChanged();
          flag = true;
          break;
        }
        if (reverseDirection) {
          i--;
        } else {
          i++;
        }
      }
    }
    return flag;
  }

  @Override
  public void removed(@Nonnull Player playerIn) {
    super.removed(playerIn);
    if (!bound && playerIn instanceof ServerPlayer serverPlayer) {
      if (!serverPlayer.isAlive() || serverPlayer.hasDisconnected()) {
        for (int j = 0; j < internal.getSlots(); ++j) {
          playerIn.drop(internal.getStackInSlot(j), false);
          if (internal instanceof IItemHandlerModifiable ihm)
            ihm.setStackInSlot(j, ItemStack.EMPTY);
        }
      } else {
        for (int i = 0; i < internal.getSlots(); ++i) {
          playerIn.getInventory().placeItemBackInInventory(internal.getStackInSlot(i));
          if (internal instanceof IItemHandlerModifiable ihm)
            ihm.setStackInSlot(i, ItemStack.EMPTY);
        }
      }
    }
  }

  public Map<Integer, Slot> get() {
    return customSlots;
  }
}
