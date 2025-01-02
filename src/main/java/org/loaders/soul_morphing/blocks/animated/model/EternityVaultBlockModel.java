package org.loaders.soul_morphing.blocks.animated.model;

import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import org.loaders.soul_morphing.blocks.animated.entity.EternityVaultBlockEntity;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;

import static org.loaders.soul_morphing.Soul_morphing.MODID;

public class EternityVaultBlockModel extends GeoModel<EternityVaultBlockEntity> {
    @Override
    public ResourceLocation getModelResource(EternityVaultBlockEntity animatable, @Nullable GeoRenderer<EternityVaultBlockEntity> renderer) {
        return ResourceLocation.parse(MODID + ":geo/eternity_vault.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EternityVaultBlockEntity animatable, @Nullable GeoRenderer<EternityVaultBlockEntity> renderer) {
        return ResourceLocation.parse(MODID + ":textures/block/eternity_vault.png");

    }

    @Override
    public ResourceLocation getAnimationResource(EternityVaultBlockEntity animatable) {
        return ResourceLocation.parse(MODID + ":animations/eternity_vault.animation.json");
    }
}