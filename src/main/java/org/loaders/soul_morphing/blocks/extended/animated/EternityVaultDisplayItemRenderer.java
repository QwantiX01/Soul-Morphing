package org.loaders.soul_morphing.blocks.extended.animated;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class EternityVaultDisplayItemRenderer extends GeoItemRenderer<EternityVaultDisplayItem> {
    public EternityVaultDisplayItemRenderer() {
        super(new EternityVaultDisplayModel());
    }

    @Override
    public RenderType getRenderType(EternityVaultDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityTranslucent(getTextureLocation(animatable));
    }
}