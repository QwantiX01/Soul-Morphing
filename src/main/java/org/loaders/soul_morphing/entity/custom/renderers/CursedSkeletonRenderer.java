package org.loaders.soul_morphing.entity.custom.renderers;

import static org.loaders.soul_morphing.Soul_morphing.MODID;

import javax.annotation.Nonnull;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.loaders.soul_morphing.entity.custom.CursedSkeletonEntity;
import org.loaders.soul_morphing.entity.custom.models.CursedSkeletonModel;
import org.loaders.soul_morphing.entity.custom.renderers.states.CursedSkeletonRenderState;

public class CursedSkeletonRenderer
    extends MobRenderer<
        CursedSkeletonEntity,
        CursedSkeletonRenderState,
        CursedSkeletonModel<CursedSkeletonRenderState>> {

  public CursedSkeletonRenderer(
      EntityRendererProvider.Context context,
      CursedSkeletonModel<CursedSkeletonRenderState> model,
      float p_174306_) {
    super(
        context,
        new CursedSkeletonModel<>(context.bakeLayer(CursedSkeletonModel.LAYER_LOCATION)),
        p_174306_);
  }

  @Override
  public ResourceLocation getTextureLocation(
      @Nonnull CursedSkeletonRenderState cursedSkeletonRenderState) {
    return ResourceLocation.fromNamespaceAndPath(MODID, "textures/entity/cursed_skeleton.png");
  }

  @Override
  public CursedSkeletonRenderState createRenderState() {
    return new CursedSkeletonRenderState();
  }

  public void extractRenderState(
      @Nonnull CursedSkeletonEntity cursedSkeletonEntity,
      @Nonnull CursedSkeletonRenderState renderState,
      float v) {
    super.extractRenderState(cursedSkeletonEntity, renderState, v);
    renderState.walkAnimationState.copyFrom(CursedSkeletonEntity.WALK_ANIMATION_STATE);
    renderState.idleAnimationState.copyFrom(CursedSkeletonEntity.IDLE_ANIMATION_STATE);
    renderState.attackAnimationState.copyFrom(CursedSkeletonEntity.ATTACK_ANIMATION_STATE);
  }
}
