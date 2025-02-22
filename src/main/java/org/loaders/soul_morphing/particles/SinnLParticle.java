package org.loaders.soul_morphing.particles;

import javax.annotation.Nonnull;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;

public class SinnLParticle extends TextureSheetParticle {
  private final SpriteSet spriteSet;

  @Override
  public void tick() {
    super.tick();
    if (this.age++ >= this.lifetime) {
      this.remove();
    } else {
      this.setSpriteFromAge(this.spriteSet);
    }
  }

  public static SinnLParticleProvider provider(SpriteSet spriteSet) {
    return new SinnLParticleProvider(spriteSet);
  }

  public static class SinnLParticleProvider implements ParticleProvider<SimpleParticleType> {
    private final SpriteSet spriteSet;

    public SinnLParticleProvider(SpriteSet spriteSet) {
      this.spriteSet = spriteSet;
    }

    public Particle createParticle(
        @Nonnull SimpleParticleType typeIn,
        @Nonnull ClientLevel worldIn,
        double x,
        double y,
        double z,
        double xSpeed,
        double ySpeed,
        double zSpeed) {
      return new SinnLParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
    }
  }

  public SinnLParticle(
      ClientLevel world,
      double x,
      double y,
      double z,
      double vx,
      double vy,
      double vz,
      SpriteSet spriteSet) {
    super(world, x, y, z);
    this.spriteSet = spriteSet;
    this.setSize(1f, 1f);
    this.lifetime = 60;
    this.gravity = 0.5f;
    this.hasPhysics = true;
    this.xd = vx * 1;
    this.yd = vy * 1;
    this.zd = vz * 1;
    this.pickSprite(spriteSet);
  }

  @Override
  public ParticleRenderType getRenderType() {
    return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
  }
}
