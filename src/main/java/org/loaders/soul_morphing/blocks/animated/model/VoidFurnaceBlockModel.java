package org.loaders.soul_morphing.blocks.animated.model;

import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import org.loaders.soul_morphing.blocks.animated.entity.VoidFurnaceBlockEntity;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;

import static org.loaders.soul_morphing.Soul_morphing.MODID;

public class VoidFurnaceBlockModel extends GeoModel<VoidFurnaceBlockEntity> {
    @Override
    public ResourceLocation getModelResource(VoidFurnaceBlockEntity animatable, @Nullable GeoRenderer<VoidFurnaceBlockEntity> renderer) {
        return ResourceLocation.parse(MODID + ":geo/void_furnace.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(VoidFurnaceBlockEntity animatable, @Nullable GeoRenderer<VoidFurnaceBlockEntity> renderer) {
        return ResourceLocation.parse(MODID + ":textures/block/void_furnace.png");

    }

    @Override
    public ResourceLocation getAnimationResource(VoidFurnaceBlockEntity animatable) {
        return ResourceLocation.parse(MODID + ":animations/void_furnace.animation.json");
    }
}