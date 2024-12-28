package org.loaders.soul_morphing.blocks.extended.animated;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import org.loaders.soul_morphing.blocks.entities.EternityVaultBlockEntity;
import software.bernie.geckolib.renderer.GeoBlockRenderer;


public class EternityVaultBlockRenderer extends GeoBlockRenderer<EternityVaultBlockEntity> {
    public EternityVaultBlockRenderer() {
        super(new EternityVaultBlockModel());
    }

    @Override
    public RenderType getRenderType(EternityVaultBlockEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityTranslucent(getTextureLocation(animatable));
    }
}