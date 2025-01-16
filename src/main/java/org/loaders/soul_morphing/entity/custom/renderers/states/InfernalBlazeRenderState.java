package org.loaders.soul_morphing.entity.custom.renderers.states;

import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.world.entity.AnimationState;

public class InfernalBlazeRenderState extends HumanoidRenderState {
    public final AnimationState idleAnimationState = new AnimationState();
    public final AnimationState attackAnimationState = new AnimationState();
    public final AnimationState walkAnimationState = new AnimationState();
}
