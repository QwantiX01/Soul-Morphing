package org.loaders.soul_morphing.entity.custom.models;

import static org.loaders.soul_morphing.Soul_morphing.MODID;

import javax.annotation.Nonnull;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import org.loaders.soul_morphing.entity.custom.animations.InfernalBlazeAnimations;
import org.loaders.soul_morphing.entity.custom.renderers.states.InfernalBlazeRenderState;

@SuppressWarnings("unused")
public class InfernalBlazeModel<T extends InfernalBlazeRenderState> extends EntityModel<T> {
  public static final ModelLayerLocation LAYER_LOCATION =
      new ModelLayerLocation(
          ResourceLocation.fromNamespaceAndPath(MODID, "infernal_blaze"), "main");
  private final ModelPart Head;
  private final ModelPart Sticks;
  private final ModelPart Cubes;

  public InfernalBlazeModel(ModelPart root) {
    super(root);
    this.Head = root.getChild("Head");
    this.Sticks = root.getChild("Sticks");
    this.Cubes = root.getChild("Cubes");
  }

  public static LayerDefinition createBodyLayer() {
    MeshDefinition meshdefinition = new MeshDefinition();
    PartDefinition partdefinition = meshdefinition.getRoot();

    PartDefinition Head =
        partdefinition.addOrReplaceChild(
            "Head",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-4.0F, -4.0F, -3.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(24, 48)
                .addBox(-5.0F, -5.0F, -4.0F, 1.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(48, 12)
                .addBox(4.0F, -5.0F, -4.0F, 1.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(46, 48)
                .addBox(-4.0F, -5.0F, 5.0F, 8.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(46, 51)
                .addBox(-2.0F, -6.0F, -4.0F, 4.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(12, 52)
                .addBox(-4.0F, -5.0F, -4.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(18, 52)
                .addBox(2.0F, -5.0F, -4.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(12, 55)
                .addBox(3.0F, -7.0F, -4.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(52, 55)
                .addBox(-5.0F, -7.0F, -4.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(24, 40)
                .addBox(4.0F, -7.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(24, 44)
                .addBox(4.0F, -7.0F, 3.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(18, 55)
                .addBox(1.0F, -7.0F, 5.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(46, 55)
                .addBox(-3.0F, -7.0F, 5.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 52)
                .addBox(-5.0F, -7.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(6, 52)
                .addBox(-5.0F, -7.0F, 3.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
            PartPose.offset(0.0F, -13.0F, 0.0F));

    PartDefinition Sticks =
        partdefinition.addOrReplaceChild(
            "Sticks", CubeListBuilder.create(), PartPose.offset(0.0F, 2.0F, 1.0F));

    PartDefinition cube_r1 =
        Sticks.addOrReplaceChild(
            "cube_r1",
            CubeListBuilder.create()
                .texOffs(32, 0)
                .addBox(-1.0F, -2.0F, -2.0F, 4.0F, 20.0F, 4.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-10.0F, -7.0F, 0.0F, 0.0F, 0.0F, 0.1309F));

    PartDefinition cube_r2 =
        Sticks.addOrReplaceChild(
            "cube_r2",
            CubeListBuilder.create()
                .texOffs(32, 24)
                .addBox(-1.0F, -2.0F, -2.0F, 4.0F, 20.0F, 4.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.0F, -7.0F, 9.0F, 0.1309F, 0.0F, 0.0F));

    PartDefinition cube_r3 =
        Sticks.addOrReplaceChild(
            "cube_r3",
            CubeListBuilder.create()
                .texOffs(16, 16)
                .addBox(-1.0F, -2.0F, -2.0F, 4.0F, 20.0F, 4.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.0F, -7.0F, -9.0F, -0.1309F, 0.0F, 0.0F));

    PartDefinition cube_r4 =
        Sticks.addOrReplaceChild(
            "cube_r4",
            CubeListBuilder.create()
                .texOffs(0, 16)
                .addBox(-1.0F, -2.0F, -2.0F, 4.0F, 20.0F, 4.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(8.0F, -7.0F, 0.0F, 0.0F, 0.0F, -0.1309F));

    PartDefinition Cubes =
        partdefinition.addOrReplaceChild(
            "Cubes",
            CubeListBuilder.create()
                .texOffs(48, 24)
                .addBox(-3.0F, 8.0F, -18.0F, 6.0F, 6.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(48, 35)
                .addBox(-3.0F, 8.0F, 15.0F, 6.0F, 6.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(0, 40)
                .addBox(14.0F, 8.0F, -2.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(48, 0)
                .addBox(-20.0F, 8.0F, -2.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, 0.0F, -0.6109F, 0.0F));

    return LayerDefinition.create(meshdefinition, 128, 128);
  }

  @Override
  public void setupAnim(@Nonnull T entity) {
    super.setupAnim(entity);
    this.Head.yRot = entity.yRot * ((float) Math.PI / 180F);
    this.Head.xRot = entity.xRot * ((float) Math.PI / 180F);

    if (entity.attackAnimationState.isStarted()) {
      this.animate(
          entity.attackAnimationState, InfernalBlazeAnimations.attack, entity.ageInTicks, 1.0F);
    } else if (entity.idleAnimationState.isStarted()) {
      this.animate(
          entity.idleAnimationState, InfernalBlazeAnimations.attack, entity.ageInTicks, 1.0F);
    }

    this.animateWalk(
        InfernalBlazeAnimations.walk,
        entity.walkAnimationPos,
        entity.walkAnimationSpeed * 5F,
        1.0F,
        5.0F);
  }
}
