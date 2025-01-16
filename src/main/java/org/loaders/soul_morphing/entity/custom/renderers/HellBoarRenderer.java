package org.loaders.soul_morphing.entity.custom.renderers;

import static org.loaders.soul_morphing.Soul_morphing.MODID;

import javax.annotation.Nonnull;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.loaders.soul_morphing.entity.custom.HellBoarEntity;
import org.loaders.soul_morphing.entity.custom.models.HellBoarModel;
import org.loaders.soul_morphing.entity.custom.renderers.states.HellBoarRenderState;

public class HellBoarRenderer
    extends MobRenderer<HellBoarEntity, HellBoarRenderState, HellBoarModel<HellBoarRenderState>> {

  public HellBoarRenderer(
      EntityRendererProvider.Context context,
      HellBoarModel<HellBoarRenderState> model,
      float p_174306_) {
    super(context, new HellBoarModel<>(context.bakeLayer(HellBoarModel.LAYER_LOCATION)), p_174306_);
  }

  @Override
  public ResourceLocation getTextureLocation(@Nonnull HellBoarRenderState HellBoarRenderState) {
    return ResourceLocation.fromNamespaceAndPath(MODID, "textures/entity/hellboar.png");
  }

  @Override
  public HellBoarRenderState createRenderState() {
    return new HellBoarRenderState();
  }

  public void extractRenderState(
      @Nonnull HellBoarEntity hellBoarEntity, @Nonnull HellBoarRenderState renderState, float v) {
    super.extractRenderState(hellBoarEntity, renderState, v);
    renderState.walkAnimationState.copyFrom(HellBoarEntity.WALK_ANIMATION_STATE);
    renderState.idleAnimationState.copyFrom(HellBoarEntity.IDLE_ANIMATION_STATE);
    renderState.attackAnimationState.copyFrom(HellBoarEntity.ATTACK_ANIMATION_STATE);
  }
}
