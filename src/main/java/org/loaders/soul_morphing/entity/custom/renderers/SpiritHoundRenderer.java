package org.loaders.soul_morphing.entity.custom.renderers;

import static org.loaders.soul_morphing.Soul_morphing.MODID;

import javax.annotation.Nonnull;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.loaders.soul_morphing.entity.custom.SpiritHoundEntity;
import org.loaders.soul_morphing.entity.custom.models.SpiritHoundModel;
import org.loaders.soul_morphing.entity.custom.renderers.states.SpiritHoundRenderState;

public class SpiritHoundRenderer
    extends MobRenderer<
        SpiritHoundEntity, SpiritHoundRenderState, SpiritHoundModel<SpiritHoundRenderState>> {

  public SpiritHoundRenderer(
      EntityRendererProvider.Context context,
      SpiritHoundModel<SpiritHoundRenderState> model,
      float p_174306_) {
    super(
        context,
        new SpiritHoundModel<>(context.bakeLayer(SpiritHoundModel.LAYER_LOCATION)),
        p_174306_);
  }

  @Override
  public ResourceLocation getTextureLocation(
      @Nonnull SpiritHoundRenderState SpiritHoundRenderState) {
    return ResourceLocation.fromNamespaceAndPath(MODID, "textures/entity/spirit_hound.png");
  }

  @Override
  public SpiritHoundRenderState createRenderState() {
    return new SpiritHoundRenderState();
  }

  public void extractRenderState(
      @Nonnull SpiritHoundEntity SpiritHoundEntity,
      @Nonnull SpiritHoundRenderState renderState,
      float v) {
    super.extractRenderState(SpiritHoundEntity, renderState, v);
    renderState.walkAnimationState.copyFrom(SpiritHoundEntity.WALK_ANIMATION_STATE);
    renderState.idleAnimationState.copyFrom(SpiritHoundEntity.IDLE_ANIMATION_STATE);
    renderState.attackAnimationState.copyFrom(SpiritHoundEntity.ATTACK_ANIMATION_STATE);
  }
}
