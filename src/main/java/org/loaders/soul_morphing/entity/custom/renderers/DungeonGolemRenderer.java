package org.loaders.soul_morphing.entity.custom.renderers;

import static org.loaders.soul_morphing.Soul_morphing.MODID;

import javax.annotation.Nonnull;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.loaders.soul_morphing.entity.custom.DungeonGolemEntity;
import org.loaders.soul_morphing.entity.custom.models.DungeonGolemModel;
import org.loaders.soul_morphing.entity.custom.renderers.states.DungeonGolemRenderState;

public class DungeonGolemRenderer
    extends MobRenderer<
        DungeonGolemEntity, DungeonGolemRenderState, DungeonGolemModel<DungeonGolemRenderState>> {

  public DungeonGolemRenderer(
      EntityRendererProvider.Context context,
      DungeonGolemModel<DungeonGolemRenderState> model,
      float p_174306_) {
    super(
        context,
        new DungeonGolemModel<>(context.bakeLayer(DungeonGolemModel.LAYER_LOCATION)),
        p_174306_);
  }

  @Override
  public ResourceLocation getTextureLocation(
      @Nonnull DungeonGolemRenderState DungeonGolemRenderState) {
    return ResourceLocation.fromNamespaceAndPath(MODID, "textures/entity/dungeon_golem.png");
  }

  @Override
  public DungeonGolemRenderState createRenderState() {
    return new DungeonGolemRenderState();
  }

  public void extractRenderState(
      @Nonnull DungeonGolemEntity dungeonGolemEntity,
      @Nonnull DungeonGolemRenderState renderState,
      float v) {
    super.extractRenderState(dungeonGolemEntity, renderState, v);
    renderState.walkAnimationState.copyFrom(DungeonGolemEntity.WALK_ANIMATION_STATE);
    renderState.idleAnimationState.copyFrom(DungeonGolemEntity.IDLE_ANIMATION_STATE);
    renderState.attackAnimationState.copyFrom(DungeonGolemEntity.ATTACK_ANIMATION_STATE);
  }
}
