package org.loaders.soul_morphing.entity.custom.renderers;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.loaders.soul_morphing.entity.custom.CursedSkeletonEntity;
import org.loaders.soul_morphing.entity.custom.IgniteSpiritEntity;
import org.loaders.soul_morphing.entity.custom.models.IgniteSpiritModel;
import org.loaders.soul_morphing.entity.custom.renderers.states.CursedSkeletonRenderState;
import org.loaders.soul_morphing.entity.custom.renderers.states.IgniteSpiritRenderState;

import static org.loaders.soul_morphing.Soul_morphing.MODID;

public class IgniteSpiritRenderer extends MobRenderer<IgniteSpiritEntity, IgniteSpiritRenderState, IgniteSpiritModel<IgniteSpiritRenderState>> {


    public IgniteSpiritRenderer(EntityRendererProvider.Context context, IgniteSpiritModel<IgniteSpiritRenderState> model, float p_174306_) {
        super(context, new IgniteSpiritModel<>(context.bakeLayer(IgniteSpiritModel.LAYER_LOCATION)), p_174306_);
    }

    @Override
    public ResourceLocation getTextureLocation(IgniteSpiritRenderState igniteSpiritRenderState) {
        return ResourceLocation.fromNamespaceAndPath(MODID, "textures/entity/ignite_spirit.png");
    }

    @Override
    public IgniteSpiritRenderState createRenderState() {
        return new IgniteSpiritRenderState();
    }

    public void extractRenderState(IgniteSpiritEntity igniteSpiritEntity, IgniteSpiritRenderState renderState, float v) {
        super.extractRenderState(igniteSpiritEntity, renderState, v);
        renderState.walkAnimationState.copyFrom(IgniteSpiritEntity.WALK_ANIMATION_STATE);
        renderState.idleAnimationState.copyFrom(IgniteSpiritEntity.IDLE_ANIMATION_STATE);
        renderState.attackAnimationState.copyFrom(IgniteSpiritEntity.ATTACK_ANIMATION_STATE);
    }

}
