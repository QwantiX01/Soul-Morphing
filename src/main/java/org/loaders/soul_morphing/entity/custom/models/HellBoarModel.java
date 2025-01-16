package org.loaders.soul_morphing.entity.custom.models;

import static org.loaders.soul_morphing.Soul_morphing.MODID;

import javax.annotation.Nonnull;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import org.loaders.soul_morphing.entity.custom.animations.HellBoarAnimations;
import org.loaders.soul_morphing.entity.custom.renderers.states.HellBoarRenderState;

@SuppressWarnings("unused")
public class HellBoarModel<T extends HellBoarRenderState> extends EntityModel<T> {
  public static final ModelLayerLocation LAYER_LOCATION =
      new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(MODID, "hellboar"), "main");
  private final ModelPart Body;
  private final ModelPart head;
  private final ModelPart lleg;
  private final ModelPart rleg;
  private final ModelPart larm;
  private final ModelPart rarm;

  public HellBoarModel(ModelPart root) {
    super(root);
    this.Body = root.getChild("Body");
    this.head = root.getChild("head");
    this.lleg = root.getChild("lleg");
    this.rleg = root.getChild("rleg");
    this.larm = root.getChild("larm");
    this.rarm = root.getChild("rarm");
  }

  public static LayerDefinition createBodyLayer() {
    MeshDefinition meshdefinition = new MeshDefinition();
    PartDefinition partdefinition = meshdefinition.getRoot();

    PartDefinition Body =
        partdefinition.addOrReplaceChild(
            "Body",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-8.0F, -7.0F, -2.0F, 16.0F, 15.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(50, 43)
                .addBox(-5.0F, -3.0F, -4.0F, 10.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)),
            PartPose.offset(0.0F, 7.0F, 0.0F));

    PartDefinition head =
        partdefinition.addOrReplaceChild(
            "head",
            CubeListBuilder.create()
                .texOffs(0, 24)
                .addBox(-5.0F, -7.0F, -3.0F, 10.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)),
            PartPose.offset(0.0F, 0.0F, 2.0F));

    PartDefinition lleg =
        partdefinition.addOrReplaceChild(
            "lleg",
            CubeListBuilder.create()
                .texOffs(24, 43)
                .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 9.0F, 7.0F, new CubeDeformation(0.0F)),
            PartPose.offset(4.0F, 15.0F, 2.0F));

    PartDefinition rleg =
        partdefinition.addOrReplaceChild(
            "rleg",
            CubeListBuilder.create()
                .texOffs(50, 0)
                .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 9.0F, 7.0F, new CubeDeformation(0.0F)),
            PartPose.offset(-4.0F, 15.0F, 2.0F));

    PartDefinition larm =
        partdefinition.addOrReplaceChild(
            "larm",
            CubeListBuilder.create()
                .texOffs(0, 38)
                .addBox(-2.0F, -2.0F, -4.0F, 5.0F, 12.0F, 7.0F, new CubeDeformation(0.0F)),
            PartPose.offset(10.0F, 3.0F, 3.0F));

    PartDefinition rarm =
        partdefinition.addOrReplaceChild(
            "rarm",
            CubeListBuilder.create()
                .texOffs(34, 24)
                .addBox(-2.0F, -2.0F, -4.0F, 5.0F, 12.0F, 7.0F, new CubeDeformation(0.0F)),
            PartPose.offset(-11.0F, 3.0F, 3.0F));

    return LayerDefinition.create(meshdefinition, 128, 128);
  }

  @Override
  public void setupAnim(@Nonnull T entity) {
    super.setupAnim(entity);
    this.head.yRot = entity.yRot * ((float) Math.PI / 180F);
    this.head.xRot = entity.xRot * ((float) Math.PI / 180F);

    if (entity.attackAnimationState.isStarted()) {
      this.animate(entity.attackAnimationState, HellBoarAnimations.attack, entity.ageInTicks, 1.0F);
    } else if (entity.idleAnimationState.isStarted()) {
      this.animate(entity.idleAnimationState, HellBoarAnimations.attack, entity.ageInTicks, 1.0F);
    }

    this.animateWalk(
        HellBoarAnimations.walk,
        entity.walkAnimationPos,
        entity.walkAnimationSpeed * 5F,
        1.0F,
        5.0F);
  }
}
