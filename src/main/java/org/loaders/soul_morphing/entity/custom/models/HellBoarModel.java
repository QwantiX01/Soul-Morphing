package org.loaders.soul_morphing.entity.custom.models;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.loaders.soul_morphing.entity.custom.animations.CursedSkeletonAnimations;
import org.loaders.soul_morphing.entity.custom.renderers.states.CursedSkeletonRenderState;

import static org.loaders.soul_morphing.Soul_morphing.MODID;

public class CursedSkeletonModel<T extends CursedSkeletonRenderState> extends EntityModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(MODID, "cursed_skeleton"), "main");
    private final ModelPart Body;
    private final ModelPart waist;
    private final ModelPart rightLeg;
    private final ModelPart leftLeg;
    private final ModelPart head;
    private final ModelPart leftHand;
    private final ModelPart rightHand;
    private final ModelPart stick;

    public CursedSkeletonModel(ModelPart root) {
        super(root);
        this.Body = root.getChild("Body");
        this.waist = root.getChild("waist");
        this.rightLeg = root.getChild("rightleg");
        this.leftLeg = root.getChild("leftleg");
        this.head = root.getChild("head");
        this.leftHand = root.getChild("lefthand");
        this.rightHand = root.getChild("righthand");
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
    public void setupAnim(@NotNull T entity) {
        super.setupAnim(entity);
        this.head.yRot = entity.yRot * ((float) Math.PI / 180F);
        this.head.xRot = entity.xRot * ((float) Math.PI / 180F);

        if (entity.attackAnimationState.isStarted()) {
            this.animate(entity.attackAnimationState, CursedSkeletonAnimations.ATTACK, entity.ageInTicks, 1.0F);
        } else if (entity.idleAnimationState.isStarted()) {
            this.animate(entity.idleAnimationState, CursedSkeletonAnimations.IDLE, entity.ageInTicks, 1.0F);
        }

        this.animateWalk(CursedSkeletonAnimations.WALK, entity.walkAnimationPos, entity.walkAnimationSpeed * 5F, 1.0F, 5.0F);
    }

}
