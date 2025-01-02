package org.loaders.soul_morphing.blocks.animated.renderer;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import org.loaders.soul_morphing.blocks.animated.entity.VoidFurnaceBlockEntity;
import org.loaders.soul_morphing.blocks.animated.model.VoidFurnaceBlockModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;


public class VoidFurnaceBlockRenderer extends GeoBlockRenderer<VoidFurnaceBlockEntity> {
    public VoidFurnaceBlockRenderer() {
        super(new VoidFurnaceBlockModel());
    }

    @Override
    public RenderType getRenderType(VoidFurnaceBlockEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityTranslucent(getTextureLocation(animatable));
    }
}