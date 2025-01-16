package org.loaders.soul_morphing.entity.custom.animations;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;

public class IgniteSpiritEntityAnimations {
  public static final AnimationDefinition idleAnimation =
      AnimationDefinition.Builder.withLength(1.5F)
          .looping()
          .addAnimation(
              "head",
              new AnimationChannel(
                  AnimationChannel.Targets.POSITION,
                  new Keyframe(
                      0.0F,
                      KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      0.75F,
                      KeyframeAnimations.posVec(0.0F, -0.33F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      1.5F,
                      KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR)))
          .addAnimation(
              "leftArm",
              new AnimationChannel(
                  AnimationChannel.Targets.POSITION,
                  new Keyframe(
                      0.0F,
                      KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      0.8333F,
                      KeyframeAnimations.posVec(0.0F, -0.2F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      1.5F,
                      KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR)))
          .addAnimation(
              "rightArm",
              new AnimationChannel(
                  AnimationChannel.Targets.POSITION,
                  new Keyframe(
                      0.0F,
                      KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      0.8333F,
                      KeyframeAnimations.posVec(0.0F, -0.2F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      1.5F,
                      KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR)))
          .build();

  public static final AnimationDefinition walkAnimation =
      AnimationDefinition.Builder.withLength(1.0F)
          .looping()
          .addAnimation(
              "head",
              new AnimationChannel(
                  AnimationChannel.Targets.ROTATION,
                  new Keyframe(
                      0.0F,
                      KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      0.5F,
                      KeyframeAnimations.degreeVec(-10.0F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      1.0F,
                      KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR)))
          .addAnimation(
              "head",
              new AnimationChannel(
                  AnimationChannel.Targets.POSITION,
                  new Keyframe(
                      0.0F,
                      KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      0.5F,
                      KeyframeAnimations.posVec(0.0F, -0.4F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      1.0F,
                      KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR)))
          .addAnimation(
              "body",
              new AnimationChannel(
                  AnimationChannel.Targets.POSITION,
                  new Keyframe(
                      0.0F,
                      KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      0.5F,
                      KeyframeAnimations.posVec(0.0F, -0.4F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      1.0F,
                      KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR)))
          .addAnimation(
              "leftArm",
              new AnimationChannel(
                  AnimationChannel.Targets.ROTATION,
                  new Keyframe(
                      0.0F,
                      KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      0.5F,
                      KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      1.0F,
                      KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR)))
          .addAnimation(
              "leftArm",
              new AnimationChannel(
                  AnimationChannel.Targets.POSITION,
                  new Keyframe(
                      0.0F,
                      KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      0.5F,
                      KeyframeAnimations.posVec(0.0F, -0.4F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      1.0F,
                      KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR)))
          .addAnimation(
              "rightArm",
              new AnimationChannel(
                  AnimationChannel.Targets.ROTATION,
                  new Keyframe(
                      0.0F,
                      KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      0.5F,
                      KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      1.0F,
                      KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR)))
          .addAnimation(
              "rightArm",
              new AnimationChannel(
                  AnimationChannel.Targets.POSITION,
                  new Keyframe(
                      0.0F,
                      KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      0.5F,
                      KeyframeAnimations.posVec(0.0F, -0.4F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      1.0F,
                      KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR)))
          .addAnimation(
              "bottom",
              new AnimationChannel(
                  AnimationChannel.Targets.POSITION,
                  new Keyframe(
                      0.0F,
                      KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      0.5F,
                      KeyframeAnimations.posVec(0.0F, -0.4F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      1.0F,
                      KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR)))
          .build();

  public static final AnimationDefinition attackAnimation =
      AnimationDefinition.Builder.withLength(0.5F)
          .addAnimation(
              "head",
              new AnimationChannel(
                  AnimationChannel.Targets.ROTATION,
                  new Keyframe(
                      0.0F,
                      KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      0.25F,
                      KeyframeAnimations.degreeVec(-10.0F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      0.5F,
                      KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR)))
          .addAnimation(
              "leftArm",
              new AnimationChannel(
                  AnimationChannel.Targets.ROTATION,
                  new Keyframe(
                      0.0F,
                      KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      0.0833F,
                      KeyframeAnimations.degreeVec(-12.08F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      0.1667F,
                      KeyframeAnimations.degreeVec(-50.0F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      0.5F,
                      KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR)))
          .addAnimation(
              "rightArm",
              new AnimationChannel(
                  AnimationChannel.Targets.ROTATION,
                  new Keyframe(
                      0.0F,
                      KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      0.0833F,
                      KeyframeAnimations.degreeVec(-12.08F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      0.1667F,
                      KeyframeAnimations.degreeVec(-50.0F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      0.5F,
                      KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR)))
          .build();
}
