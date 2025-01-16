package org.loaders.soul_morphing.entity.custom.renderers;

import static org.loaders.soul_morphing.Soul_morphing.MODID;

import javax.annotation.Nonnull;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.loaders.soul_morphing.entity.custom.InfernalBlazeEntity;
import org.loaders.soul_morphing.entity.custom.models.InfernalBlazeModel;
import org.loaders.soul_morphing.entity.custom.renderers.states.InfernalBlazeRenderState;

public class InfernalBlazeRenderer
    extends MobRenderer<
        InfernalBlazeEntity,
        InfernalBlazeRenderState,
        InfernalBlazeModel<InfernalBlazeRenderState>> {

  public InfernalBlazeRenderer(
      EntityRendererProvider.Context context,
      InfernalBlazeModel<InfernalBlazeRenderState> model,
      float p_174306_) {
    super(
        context,
        new InfernalBlazeModel<>(context.bakeLayer(InfernalBlazeModel.LAYER_LOCATION)),
        p_174306_);
  }

  @Override
  public ResourceLocation getTextureLocation(
      @Nonnull InfernalBlazeRenderState InfernalBlazeRenderState) {
    return ResourceLocation.fromNamespaceAndPath(MODID, "textures/entity/infernal_blaze.png");
  }

  @Override
  public InfernalBlazeRenderState createRenderState() {
    return new InfernalBlazeRenderState();
  }

  public void extractRenderState(
      @Nonnull InfernalBlazeEntity InfernalBlazeEntity,
      @Nonnull InfernalBlazeRenderState renderState,
      float v) {
    super.extractRenderState(InfernalBlazeEntity, renderState, v);
    renderState.walkAnimationState.copyFrom(InfernalBlazeEntity.WALK_ANIMATION_STATE);
    renderState.idleAnimationState.copyFrom(InfernalBlazeEntity.IDLE_ANIMATION_STATE);
    renderState.attackAnimationState.copyFrom(InfernalBlazeEntity.ATTACK_ANIMATION_STATE);
  }
}
