package org.loaders.soul_morphing.entity.custom.models;

import static org.loaders.soul_morphing.Soul_morphing.MODID;

import javax.annotation.Nonnull;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.loaders.soul_morphing.entity.custom.animations.DeevourerAnimations;
import org.loaders.soul_morphing.entity.custom.renderers.states.DeevourerRenderState;

@SuppressWarnings("unused")
public class DeevourerModel<T extends DeevourerRenderState> extends EntityModel<T> {
  public static final ModelLayerLocation LAYER_LOCATION =
      new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(MODID, "devourer"), "main");
  private final ModelPart body;
  private final ModelPart lleg;
  private final ModelPart rleg;
  private final ModelPart larm;
  private final ModelPart rarm;

  public DeevourerModel(ModelPart root) {
    super(root);
    this.body = root.getChild("body");
    this.lleg = root.getChild("lleg");
    this.rleg = root.getChild("rleg");
    this.larm = root.getChild("larm");
    this.rarm = root.getChild("rarm");
  }

  public static LayerDefinition createBodyLayer() {
    MeshDefinition meshdefinition = new MeshDefinition();
    PartDefinition partdefinition = meshdefinition.getRoot();

    PartDefinition body =
        partdefinition.addOrReplaceChild(
            "body",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-5.0F, -7.0F, -4.0F, 9.0F, 13.0F, 7.0F, new CubeDeformation(0.0F)),
            PartPose.offset(0.0F, 6.0F, 0.0F));

    PartDefinition lleg =
        partdefinition.addOrReplaceChild(
            "lleg",
            CubeListBuilder.create()
                .texOffs(0, 20)
                .addBox(-2.0F, -1.0F, -3.0F, 4.0F, 14.0F, 5.0F, new CubeDeformation(0.0F)),
            PartPose.offset(3.0F, 11.0F, 0.0F));

    PartDefinition rleg =
        partdefinition.addOrReplaceChild(
            "rleg",
            CubeListBuilder.create()
                .texOffs(18, 20)
                .addBox(-2.0F, -1.0F, -3.0F, 4.0F, 14.0F, 5.0F, new CubeDeformation(0.0F)),
            PartPose.offset(-4.0F, 11.0F, 0.0F));

    PartDefinition larm =
        partdefinition.addOrReplaceChild(
            "larm",
            CubeListBuilder.create()
                .texOffs(32, 0)
                .addBox(-2.0F, -1.0F, -3.0F, 5.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)),
            PartPose.offset(6.0F, 1.0F, 0.0F));

    PartDefinition rarm =
        partdefinition.addOrReplaceChild(
            "rarm",
            CubeListBuilder.create()
                .texOffs(36, 13)
                .addBox(-2.0F, -1.0F, -3.0F, 5.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)),
            PartPose.offset(-8.0F, 1.0F, 0.0F));

    return LayerDefinition.create(meshdefinition, 64, 64);
  }

  @Override
  public void setupAnim(@Nonnull T entity) {
    super.setupAnim(entity);
    if (entity.attackAnimationState.isStarted()) {
      this.animate(
          entity.attackAnimationState,
          DeevourerAnimations.attackAnimation,
          entity.ageInTicks,
          1.0F);
    } else if (entity.idleAnimationState.isStarted()) {
      this.animate(
          entity.idleAnimationState, DeevourerAnimations.idleAnimation, entity.ageInTicks, 1.0F);
    }

    this.animateWalk(
        DeevourerAnimations.walkAnimation,
        entity.walkAnimationPos,
        entity.walkAnimationSpeed * 5F,
        1.0F,
        5.0F);
  }
}
