package org.loaders.soul_morphing.blocks.animated.renderer;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import org.loaders.soul_morphing.blocks.animated.display.EternityVaultDisplayItem;
import org.loaders.soul_morphing.blocks.animated.model.EternityVaultDisplayModel;
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