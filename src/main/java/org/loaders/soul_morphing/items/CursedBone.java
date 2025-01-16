package org.loaders.soul_morphing.items;

import static org.loaders.soul_morphing.Soul_morphing.MODID;
import static org.loaders.soul_morphing.init.SoulItems.ITEMS;

import javax.annotation.Nonnull;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.Spawner;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import org.loaders.soul_morphing.init.SoulEntities;
import org.loaders.soul_morphing.util.Souls;

public class CursedBone extends Item {
  public CursedBone(Properties properties) {
    super(
        properties.setId(
            ResourceKey.create(
                ITEMS.getRegistryKey(),
                ResourceLocation.fromNamespaceAndPath(MODID, "cursed_bone"))));
  }

  @Override
  public InteractionResult use(
      @Nonnull Level level, @Nonnull Player player, @Nonnull InteractionHand hand) {
    Souls.addSouls(player, 100);
    return super.use(level, player, hand);
  }

  @Override
  public InteractionResult useOn(@Nonnull UseOnContext context) {
    Level level = context.getLevel();
    ItemStack itemstack = context.getItemInHand();
    BlockPos blockpos = context.getClickedPos();
    BlockState blockstate = level.getBlockState(blockpos);

    if (level.getBlockEntity(blockpos) instanceof Spawner spawner) {
      spawner.setEntityId(SoulEntities.CURSED_SKELETON_ENTITY.get(), level.getRandom());
      level.sendBlockUpdated(blockpos, blockstate, blockstate, 3);
      level.gameEvent(context.getPlayer(), GameEvent.BLOCK_CHANGE, blockpos);
      itemstack.shrink(1);
      return InteractionResult.SUCCESS;
    }
    return InteractionResult.SUCCESS;
  }
}
