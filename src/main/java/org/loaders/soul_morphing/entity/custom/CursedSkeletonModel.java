package org.loaders.soul_morphing.entity.custom;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.AnimationUtils;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

import static org.loaders.soul_morphing.Soul_morphing.MODID;

public class CursedSkeletonModel<T extends CursedSkeletonRenderState> extends EntityModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(MODID, "cursed_skeleton"), "main");
    private final ModelPart Body;
    private final ModelPart waist;
    private final ModelPart rightleg;
    private final ModelPart leftleg;
    private final ModelPart head;
    private final ModelPart lefthand;
    private final ModelPart righthand;
    private final ModelPart stick;

    public CursedSkeletonModel(ModelPart root) {
        super(root);
        this.Body = root.getChild("Body");
        this.waist = root.getChild("waist");
        this.rightleg = root.getChild("rightleg");
        this.leftleg = root.getChild("leftleg");
        this.head = root.getChild("head");
        this.lefthand = root.getChild("lefthand");
        this.righthand = root.getChild("righthand");
        this.stick = root.getChild("stick");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 16).addBox(-4.0F, -4.0F, -2.0F, 8.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 0.0F, 0.1309F, 0.0F, 0.0F));

        PartDefinition waist = partdefinition.addOrReplaceChild("waist", CubeListBuilder.create().texOffs(32, 0).addBox(-4.0F, -1.0F, -2.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 11.0F, 0.0F));

        PartDefinition rightleg = partdefinition.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(16, 29).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 12.0F, 0.0F));

        PartDefinition leftleg = partdefinition.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(32, 6).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 12.0F, 0.0F));

        PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -7.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, -2.0F));

        PartDefinition lefthand = partdefinition.addOrReplaceChild("lefthand", CubeListBuilder.create().texOffs(24, 16).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 22.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, -2.0F, 0.0F));

        PartDefinition righthand = partdefinition.addOrReplaceChild("righthand", CubeListBuilder.create().texOffs(0, 29).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 22.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, -2.0F, 0.0F));

        PartDefinition stick = partdefinition.addOrReplaceChild("stick", CubeListBuilder.create().texOffs(8, 29).addBox(-1.0F, -11.0F, -1.0F, 2.0F, 16.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 5.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(T entity) {
        super.setupAnim(entity);
        this.head.yRot = entity.yRot * ((float) Math.PI / 180F);
        this.head.xRot = entity.xRot * ((float) Math.PI / 180F);

        if (entity.attackAnimationState.isStarted()) {
            this.animate(entity.attackAnimationState, CursedSkeletonAnimations.ATTACK, entity.ageInTicks, 1.0F);
        } else if (entity.idleAnimationState.isStarted()) {
            this.animate(entity.idleAnimationState, CursedSkeletonAnimations.IDLE, entity.ageInTicks, 1.0F);
        }

        this.animateWalk(CursedSkeletonAnimations.WALK, entity.walkAnimationPos, entity.walkAnimationSpeed, 1.0F, 5.0F);
    }

    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        Body.render(poseStack, vertexConsumer, packedLight, packedOverlay);
        waist.render(poseStack, vertexConsumer, packedLight, packedOverlay);
        rightleg.render(poseStack, vertexConsumer, packedLight, packedOverlay);
        leftleg.render(poseStack, vertexConsumer, packedLight, packedOverlay);
        head.render(poseStack, vertexConsumer, packedLight, packedOverlay);
        lefthand.render(poseStack, vertexConsumer, packedLight, packedOverlay);
        righthand.render(poseStack, vertexConsumer, packedLight, packedOverlay);
        stick.render(poseStack, vertexConsumer, packedLight, packedOverlay);
    }
}
