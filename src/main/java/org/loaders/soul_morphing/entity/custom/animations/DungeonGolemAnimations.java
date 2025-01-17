package org.loaders.soul_morphing.entity.custom.animations;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;

public class DungeonGolemAnimations {
  public static final AnimationDefinition attack =
      AnimationDefinition.Builder.withLength(1.5F)
          .looping()
          .addAnimation(
              "larm",
              new AnimationChannel(
                  AnimationChannel.Targets.ROTATION,
                  new Keyframe(
                      0.0F,
                      KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      0.1667F,
                      KeyframeAnimations.degreeVec(-105.0F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      0.7917F,
                      KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR)))
          .addAnimation(
              "larm2",
              new AnimationChannel(
                  AnimationChannel.Targets.ROTATION,
                  new Keyframe(
                      0.0F,
                      KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      0.1667F,
                      KeyframeAnimations.degreeVec(-105.0F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      0.7917F,
                      KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR)))
          .build();

  public static final AnimationDefinition Idle =
      AnimationDefinition.Builder.withLength(2.0F)
          .looping()
          .addAnimation(
              "Body",
              new AnimationChannel(
                  AnimationChannel.Targets.ROTATION,
                  new Keyframe(
                      0.0F,
                      KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      0.9167F,
                      KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      2.0F,
                      KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR)))
          .addAnimation(
              "Body",
              new AnimationChannel(
                  AnimationChannel.Targets.POSITION,
                  new Keyframe(
                      0.0F,
                      KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      0.75F,
                      KeyframeAnimations.posVec(0.0F, -0.4F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      1.75F,
                      KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR)))
          .addAnimation(
              "larm",
              new AnimationChannel(
                  AnimationChannel.Targets.POSITION,
                  new Keyframe(
                      0.0F,
                      KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      0.7917F,
                      KeyframeAnimations.posVec(0.0F, 0.0F, -1.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      2.0F,
                      KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR)))
          .addAnimation(
              "larm2",
              new AnimationChannel(
                  AnimationChannel.Targets.POSITION,
                  new Keyframe(
                      0.0F,
                      KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      0.7917F,
                      KeyframeAnimations.posVec(0.0F, 0.0F, -1.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      2.0F,
                      KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR)))
          .build();

  public static final AnimationDefinition walk =
      AnimationDefinition.Builder.withLength(1.5F)
          .looping()
          .addAnimation(
              "Body",
              new AnimationChannel(
                  AnimationChannel.Targets.ROTATION,
                  new Keyframe(
                      0.0F,
                      KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      0.25F,
                      KeyframeAnimations.degreeVec(2.677F, 3.9398F, 2.271F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      0.2917F,
                      KeyframeAnimations.degreeVec(2.9285F, 8.3632F, 4.6161F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      0.75F,
                      KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      1.0F,
                      KeyframeAnimations.degreeVec(2.9285F, -3.9398F, -2.271F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      1.0417F,
                      KeyframeAnimations.degreeVec(2.9285F, -8.3632F, -4.6161F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      1.5F,
                      KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR)))
          .addAnimation(
              "Body",
              new AnimationChannel(
                  AnimationChannel.Targets.POSITION,
                  new Keyframe(
                      0.0F,
                      KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      0.75F,
                      KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR)))
          .addAnimation(
              "lleg",
              new AnimationChannel(
                  AnimationChannel.Targets.ROTATION,
                  new Keyframe(
                      0.0F,
                      KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      0.25F,
                      KeyframeAnimations.degreeVec(-7.5F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      0.2917F,
                      KeyframeAnimations.degreeVec(-10.0F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      0.75F,
                      KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      1.0417F,
                      KeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      1.5F,
                      KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR)))
          .addAnimation(
              "lleg",
              new AnimationChannel(
                  AnimationChannel.Targets.POSITION,
                  new Keyframe(
                      0.0F,
                      KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      0.25F,
                      KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR)))
          .addAnimation(
              "lleg2",
              new AnimationChannel(
                  AnimationChannel.Targets.ROTATION,
                  new Keyframe(
                      0.0F,
                      KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      0.25F,
                      KeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      0.2917F,
                      KeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      0.75F,
                      KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      1.0417F,
                      KeyframeAnimations.degreeVec(-10.0F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      1.5F,
                      KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR)))
          .addAnimation(
              "lleg2",
              new AnimationChannel(
                  AnimationChannel.Targets.POSITION,
                  new Keyframe(
                      0.0F,
                      KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      1.0417F,
                      KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR)))
          .addAnimation(
              "larm",
              new AnimationChannel(
                  AnimationChannel.Targets.ROTATION,
                  new Keyframe(
                      0.0F,
                      KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      0.2917F,
                      KeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      0.75F,
                      KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      1.0F,
                      KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      1.0833F,
                      KeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      1.5F,
                      KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR)))
          .addAnimation(
              "larm",
              new AnimationChannel(
                  AnimationChannel.Targets.POSITION,
                  new Keyframe(
                      0.0F,
                      KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      0.25F,
                      KeyframeAnimations.posVec(0.0F, 0.0F, -1.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      0.2917F,
                      KeyframeAnimations.posVec(0.0F, 0.0F, -1.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      0.75F,
                      KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      1.0833F,
                      KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      1.5F,
                      KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR)))
          .addAnimation(
              "larm2",
              new AnimationChannel(
                  AnimationChannel.Targets.ROTATION,
                  new Keyframe(
                      0.0F,
                      KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      0.25F,
                      KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      0.2917F,
                      KeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      0.75F,
                      KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      1.0833F,
                      KeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      1.5F,
                      KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR)))
          .addAnimation(
              "larm2",
              new AnimationChannel(
                  AnimationChannel.Targets.POSITION,
                  new Keyframe(
                      0.0F,
                      KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      1.0F,
                      KeyframeAnimations.posVec(0.0F, 0.0F, -1.0F),
                      AnimationChannel.Interpolations.LINEAR),
                  new Keyframe(
                      1.5F,
                      KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F),
                      AnimationChannel.Interpolations.LINEAR)))
          .build();
}
