package org.loaders.soul_morphing.blocks.animated.renderer;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import org.loaders.soul_morphing.blocks.animated.display.VoidFurnaceDisplayItem;
import org.loaders.soul_morphing.blocks.animated.model.VoidFurnaceDisplayModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class VoidFurnaceDisplayItemRenderer extends GeoItemRenderer<VoidFurnaceDisplayItem> {
  public VoidFurnaceDisplayItemRenderer() {
    super(new VoidFurnaceDisplayModel());
  }

  @Override
  public RenderType getRenderType(
      VoidFurnaceDisplayItem animatable,
      ResourceLocation texture,
      MultiBufferSource bufferSource,
      float partialTick) {
    return RenderType.entityTranslucent(getTextureLocation(animatable));
  }
}
