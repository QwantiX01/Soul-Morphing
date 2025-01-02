package org.loaders.soul_morphing.blocks.animated.model;

import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import org.loaders.soul_morphing.blocks.animated.display.EternityVaultDisplayItem;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;

import static org.loaders.soul_morphing.Soul_morphing.MODID;

public class EternityVaultDisplayModel extends GeoModel<EternityVaultDisplayItem> {

    @Override
    public ResourceLocation getModelResource(EternityVaultDisplayItem animatable, @Nullable GeoRenderer<EternityVaultDisplayItem> renderer) {
        return ResourceLocation.parse(MODID + ":geo/eternity_vault.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EternityVaultDisplayItem animatable, @Nullable GeoRenderer<EternityVaultDisplayItem> renderer) {
        return ResourceLocation.parse(MODID + ":textures/block/eternity_vault.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EternityVaultDisplayItem animatable) {
        return ResourceLocation.parse(MODID + ":animations/eternity_vault.animation.json");
    }
}