package org.loaders.soul_morphing.blocks.animated.model;

import static org.loaders.soul_morphing.Soul_morphing.MODID;

import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import org.loaders.soul_morphing.blocks.animated.display.VoidFurnaceDisplayItem;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;

public class VoidFurnaceDisplayModel extends GeoModel<VoidFurnaceDisplayItem> {

  @Override
  public ResourceLocation getModelResource(
      VoidFurnaceDisplayItem animatable, @Nullable GeoRenderer<VoidFurnaceDisplayItem> renderer) {
    return ResourceLocation.parse(MODID + ":geo/void_furnace.geo.json");
  }

  @Override
  public ResourceLocation getTextureResource(
      VoidFurnaceDisplayItem animatable, @Nullable GeoRenderer<VoidFurnaceDisplayItem> renderer) {
    return ResourceLocation.parse(MODID + ":textures/block/void_furnace.png");
  }

  @Override
  public ResourceLocation getAnimationResource(VoidFurnaceDisplayItem animatable) {
    return ResourceLocation.parse(MODID + ":animations/void_furnace.animation.json");
  }
}
