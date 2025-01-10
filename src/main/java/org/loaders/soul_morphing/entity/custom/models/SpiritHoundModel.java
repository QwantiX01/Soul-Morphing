package org.loaders.soul_morphing.entity.custom.models;


import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.loaders.soul_morphing.entity.custom.SpiritHoundEntity;
import org.loaders.soul_morphing.entity.custom.animations.IgniteSpiritEntityAnimations;
import org.loaders.soul_morphing.entity.custom.animations.SpiritHoundAnimations;
import org.loaders.soul_morphing.entity.custom.renderers.states.SpiritHoundRenderState;

import static org.loaders.soul_morphing.Soul_morphing.MODID;

public class SpiritHoundModel<T extends SpiritHoundRenderState> extends EntityModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(MODID, "spirit_hound"), "main");
    private final ModelPart head;
    private final ModelPart Lhorn;
    private final ModelPart Lhorn2;
    private final ModelPart body;
    private final ModelPart Larm;
    private final ModelPart Larm2;
    private final ModelPart particles;

    public SpiritHoundModel(ModelPart root) {
        super(root);
        this.head = root.getChild("head");
        this.Lhorn = this.head.getChild("Lhorn");
        this.Lhorn2 = this.head.getChild("Lhorn2");
        this.body = root.getChild("body");
        this.Larm = root.getChild("Larm");
        this.Larm2 = root.getChild("Larm2");
        this.particles = root.getChild("particles");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(36, 34).addBox(-4.0F, -1.0F, -12.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-5.0F, -6.0F, -6.0F, 10.0F, 9.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 5.0F, -4.0F));

        PartDefinition Lhorn = head.addOrReplaceChild("Lhorn", CubeListBuilder.create().texOffs(18, 56).addBox(2.0F, -5.0F, 4.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(24, 47).addBox(1.0F, -4.0F, 2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 56).addBox(0.0F, -3.0F, 0.0F, 3.0F, 4.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(24, 53).addBox(-2.0F, -1.0F, -1.0F, 4.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, -7.0F, -2.0F));

        PartDefinition Lhorn2 = head.addOrReplaceChild("Lhorn2", CubeListBuilder.create().texOffs(18, 59).addBox(-3.0F, -5.0F, 4.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(60, 44).addBox(-3.0F, -4.0F, 2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(62, 0).addBox(-3.0F, -3.0F, 0.0F, 3.0F, 4.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(44, 53).addBox(-2.0F, -1.0F, -1.0F, 4.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, -7.0F, -2.0F));

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 17).addBox(-2.0F, -1.2954F, -0.5837F, 4.0F, 3.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.0F, -2.0F, -0.3054F, 0.0F, 0.0F));

        PartDefinition Larm = partdefinition.addOrReplaceChild("Larm", CubeListBuilder.create().texOffs(36, 44).addBox(-3.0F, -2.0F, -5.0F, 7.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(8.0F, 12.0F, 0.0F));

        PartDefinition Larm2 = partdefinition.addOrReplaceChild("Larm2", CubeListBuilder.create().texOffs(0, 47).addBox(-5.0F, -2.0F, -3.0F, 7.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-8.0F, 12.0F, -2.0F));

        PartDefinition particles = partdefinition.addOrReplaceChild("particles", CubeListBuilder.create().texOffs(12, 41).addBox(-14.0F, -6.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(49, 12).addBox(12.0F, -5.0F, -8.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(39, 28).addBox(4.0F, 6.0F, 6.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void setupAnim(@NotNull T entity) {
        super.setupAnim(entity);
        this.head.yRot = entity.yRot * ((float) Math.PI / 180F);
        this.head.xRot = entity.xRot * ((float) Math.PI / 180F);

        if (entity.attackAnimationState.isStarted()) {
            this.animate(entity.attackAnimationState, SpiritHoundAnimations.attackAnimation, entity.ageInTicks, 1.0F);
        } else if (entity.idleAnimationState.isStarted()) {
            this.animate(entity.idleAnimationState, SpiritHoundAnimations.idleAnimation, entity.ageInTicks, 1.0F);
        }

        this.animateWalk(SpiritHoundAnimations.walkAnimation, entity.walkAnimationPos, entity.walkAnimationSpeed * 5F, 1.0F, 5.0F);
    }

}
