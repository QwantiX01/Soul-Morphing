package org.loaders.soul_morphing.entity.custom.models;

import static org.loaders.soul_morphing.Soul_morphing.MODID;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import javax.annotation.Nonnull;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import org.loaders.soul_morphing.entity.custom.animations.CursedSkeletonAnimations;
import org.loaders.soul_morphing.entity.custom.animations.DungeonGolemAnimations;
import org.loaders.soul_morphing.entity.custom.renderers.states.CursedSkeletonRenderState;
import org.loaders.soul_morphing.entity.custom.renderers.states.DungeonGolemRenderState;

@SuppressWarnings("unused")
public class DungeonGolemModel<T extends DungeonGolemRenderState> extends EntityModel<T> {
  public static final ModelLayerLocation LAYER_LOCATION =
      new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(MODID, "dungeon_golem"), "main");
  private final ModelPart Body;
  private final ModelPart lleg;
  private final ModelPart lleg2;
  private final ModelPart larm;
  private final ModelPart larm2;

  public DungeonGolemModel(ModelPart root) {
    super(root);
    this.Body = root.getChild("Body");
    this.lleg = root.getChild("lleg");
    this.lleg2 = root.getChild("lleg2");
    this.larm = root.getChild("larm");
    this.larm2 = root.getChild("larm2");
  }

  public static LayerDefinition createBodyLayer() {
    MeshDefinition meshdefinition = new MeshDefinition();
    PartDefinition partdefinition = meshdefinition.getRoot();

    PartDefinition Body =
        partdefinition.addOrReplaceChild(
            "Body",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-4.0F, -23.0F, -2.0F, 8.0F, 27.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(44, 0)
                .addBox(4.0F, -23.0F, -2.0F, 9.0F, 10.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(44, 16)
                .addBox(-13.0F, -23.0F, -2.0F, 9.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, 7.0F, 0.0F, 0.4363F, 0.0F, 0.0F));

    PartDefinition lleg =
        partdefinition.addOrReplaceChild(
            "lleg",
            CubeListBuilder.create()
                .texOffs(16, 35)
                .addBox(-2.0F, -3.0F, -2.0F, 4.0F, 20.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(56, 32)
                .addBox(-3.0F, 11.0F, -3.0F, 6.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)),
            PartPose.offset(6.0F, 6.0F, 0.0F));

    PartDefinition lleg2 =
        partdefinition.addOrReplaceChild(
            "lleg2",
            CubeListBuilder.create()
                .texOffs(36, 35)
                .addBox(-2.0F, -3.0F, -2.0F, 4.0F, 21.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(56, 47)
                .addBox(-3.0F, 11.0F, -3.0F, 6.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)),
            PartPose.offset(-6.0F, 6.0F, 0.0F));

    PartDefinition larm =
        partdefinition.addOrReplaceChild(
            "larm",
            CubeListBuilder.create()
                .texOffs(28, 0)
                .addBox(-2.0F, -1.0F, -2.0F, 4.0F, 31.0F, 4.0F, new CubeDeformation(0.0F)),
            PartPose.offset(8.0F, -6.0F, -5.0F));

    PartDefinition larm2 =
        partdefinition.addOrReplaceChild(
            "larm2",
            CubeListBuilder.create()
                .texOffs(0, 33)
                .addBox(-2.0F, -1.0F, -2.0F, 4.0F, 31.0F, 4.0F, new CubeDeformation(0.0F)),
            PartPose.offset(-8.0F, -6.0F, -5.0F));

    return LayerDefinition.create(meshdefinition, 128, 128);
  }

  @Override
  public void setupAnim(@Nonnull T entity) {
    super.setupAnim(entity);
    if (entity.attackAnimationState.isStarted()) {
      this.animate(
          entity.attackAnimationState, DungeonGolemAnimations.attack, entity.ageInTicks, 1.0F);
    } else if (entity.idleAnimationState.isStarted()) {
      this.animate(entity.idleAnimationState, DungeonGolemAnimations.Idle, entity.ageInTicks, 1.0F);
    }

    this.animateWalk(
        DungeonGolemAnimations.walk,
        entity.walkAnimationPos,
        entity.walkAnimationSpeed * 5F,
        1.0F,
        5.0F);
  }
}
