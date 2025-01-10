package org.loaders.soul_morphing.entity.custom.renderers;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.loaders.soul_morphing.entity.custom.CursedSkeletonEntity;
import org.loaders.soul_morphing.entity.custom.DeevourerEntity;
import org.loaders.soul_morphing.entity.custom.models.CursedSkeletonModel;
import org.loaders.soul_morphing.entity.custom.models.DeevourerModel;
import org.loaders.soul_morphing.entity.custom.renderers.states.CursedSkeletonRenderState;
import org.loaders.soul_morphing.entity.custom.renderers.states.DeevourerRenderState;

import static org.loaders.soul_morphing.Soul_morphing.MODID;

public class DeevourerRenderer extends MobRenderer<DeevourerEntity, DeevourerRenderState, DeevourerModel<DeevourerRenderState>> {


    public DeevourerRenderer(EntityRendererProvider.Context context, DeevourerModel<DeevourerRenderState> model, float p_174306_) {
        super(context, new DeevourerModel<>(context.bakeLayer(DeevourerModel.LAYER_LOCATION)), p_174306_);
    }

    @Override
    public ResourceLocation getTextureLocation(DeevourerRenderState deevourerRenderState) {
        return ResourceLocation.fromNamespaceAndPath(MODID, "textures/entity/deevourer.png");
    }

    @Override
    public DeevourerRenderState createRenderState() {
        return new DeevourerRenderState();
    }

    public void extractRenderState(DeevourerEntity deevourerEntity, DeevourerRenderState renderState, float v) {
        super.extractRenderState(deevourerEntity, renderState, v);
        renderState.walkAnimationState.copyFrom(DeevourerEntity.WALK_ANIMATION_STATE);
        renderState.idleAnimationState.copyFrom(DeevourerEntity.IDLE_ANIMATION_STATE);
        renderState.attackAnimationState.copyFrom(DeevourerEntity.ATTACK_ANIMATION_STATE);
    }

}
