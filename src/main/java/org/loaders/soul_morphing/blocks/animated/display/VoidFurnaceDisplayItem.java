package org.loaders.soul_morphing.blocks.animated.display;

import static org.loaders.soul_morphing.blocks.animated.entity.VoidFurnaceBlockEntity.BURNING_ANIM;

import java.util.function.Consumer;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import org.loaders.soul_morphing.blocks.animated.renderer.VoidFurnaceDisplayItemRenderer;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

public class VoidFurnaceDisplayItem extends BlockItem implements GeoItem {
  private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

  public VoidFurnaceDisplayItem(Block block, Properties settings) {
    super(block, settings);
  }

  private PlayState predicate(AnimationState<VoidFurnaceDisplayItem> event) {
    event.getController().setAnimation(BURNING_ANIM);
    return PlayState.CONTINUE;
  }

  @Override
  public void createGeoRenderer(Consumer<GeoRenderProvider> consumer) {
    consumer.accept(
        new GeoRenderProvider() {
          private VoidFurnaceDisplayItemRenderer renderer;

          @Override
          public BlockEntityWithoutLevelRenderer getGeoItemRenderer() {
            if (this.renderer == null) this.renderer = new VoidFurnaceDisplayItemRenderer();
            return this.renderer;
          }
        });
  }

  @Override
  public void registerControllers(AnimatableManager.ControllerRegistrar data) {
    data.add(new AnimationController<>(this, "controller", 0, this::predicate));
  }

  @Override
  public AnimatableInstanceCache getAnimatableInstanceCache() {
    return this.cache;
  }
}
