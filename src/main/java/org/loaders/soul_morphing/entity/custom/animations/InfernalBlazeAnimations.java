package org.loaders.soul_morphing.entity.custom.animations;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;

public class InfernalBlazeAnimations {
  public static final AnimationDefinition idle =
      AnimationDefinition.Builder.withLength(1.5F)
          .looping()
          .addAnimation(
              "Sticks",
              new AnimationChannel(
                  AnimationChannel.Targets.ROTATION,
                  new Keyframe(
                      0.0F,
                      KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      0.25F,
                      KeyframeAnimations.degreeVec(0.0F, -50.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      0.2917F,
                      KeyframeAnimations.degreeVec(0.0F, -57.5F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      0.3333F,
                      KeyframeAnimations.degreeVec(0.0F, -60.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      0.375F,
                      KeyframeAnimations.degreeVec(0.0F, -60.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      0.4167F,
                      KeyframeAnimations.degreeVec(0.0F, -60.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      0.4583F,
                      KeyframeAnimations.degreeVec(0.0F, -60.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      0.5F,
                      KeyframeAnimations.degreeVec(0.0F, -60.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      0.5417F,
                      KeyframeAnimations.degreeVec(0.0F, -60.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      0.5833F,
                      KeyframeAnimations.degreeVec(0.0F, -60.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      0.625F,
                      KeyframeAnimations.degreeVec(0.0F, -60.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      0.6667F,
                      KeyframeAnimations.degreeVec(0.0F, -60.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR)))
          .addAnimation(
              "Cubes",
              new AnimationChannel(
                  AnimationChannel.Targets.ROTATION,
                  new Keyframe(
                      0.0F,
                      KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      0.25F,
                      KeyframeAnimations.degreeVec(0.0F, 25.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      0.2917F,
                      KeyframeAnimations.degreeVec(0.0F, 30.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      0.3333F,
                      KeyframeAnimations.degreeVec(0.0F, 32.5F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      0.375F,
                      KeyframeAnimations.degreeVec(0.0F, 32.5F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      0.4167F,
                      KeyframeAnimations.degreeVec(0.0F, 32.5F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      0.4583F,
                      KeyframeAnimations.degreeVec(0.0F, 32.5F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      0.5F,
                      KeyframeAnimations.degreeVec(0.0F, 32.5F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      0.5417F,
                      KeyframeAnimations.degreeVec(0.0F, 32.5F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      0.5833F,
                      KeyframeAnimations.degreeVec(0.0F, 32.5F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      0.625F,
                      KeyframeAnimations.degreeVec(0.0F, 32.5F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      0.6667F,
                      KeyframeAnimations.degreeVec(0.0F, 32.5F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR)))
          .build();

  public static final AnimationDefinition walk =
      AnimationDefinition.Builder.withLength(1.25F)
          .looping()
          .addAnimation(
              "Sticks",
              new AnimationChannel(
                  AnimationChannel.Targets.ROTATION,
                  new Keyframe(
                      0.0F,
                      KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      1.25F,
                      KeyframeAnimations.degreeVec(0.0F, -360.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR)))
          .addAnimation(
              "Cubes",
              new AnimationChannel(
                  AnimationChannel.Targets.ROTATION,
                  new Keyframe(
                      0.0F,
                      KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      1.25F,
                      KeyframeAnimations.degreeVec(0.0F, 360.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR)))
          .build();

  public static final AnimationDefinition attack =
      AnimationDefinition.Builder.withLength(1.25F)
          .looping()
          .addAnimation(
              "Sticks",
              new AnimationChannel(
                  AnimationChannel.Targets.ROTATION,
                  new Keyframe(
                      0.0F,
                      KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      1.5F,
                      KeyframeAnimations.degreeVec(0.0F, -362.5F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR)))
          .addAnimation(
              "Cubes",
              new AnimationChannel(
                  AnimationChannel.Targets.ROTATION,
                  new Keyframe(
                      0.0F,
                      KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      1.5F,
                      KeyframeAnimations.degreeVec(0.0F, 360.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR)))
          .build();
}
