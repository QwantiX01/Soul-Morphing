package org.loaders.soul_morphing.particles;

import javax.annotation.Nonnull;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;

public class SinnHParticle extends TextureSheetParticle {
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

  public static SinnHParticleProvider provider(SpriteSet spriteSet) {
    return new SinnHParticleProvider(spriteSet);
  }

  public static class SinnHParticleProvider implements ParticleProvider<SimpleParticleType> {
    private final SpriteSet spriteSet;

    public SinnHParticleProvider(SpriteSet spriteSet) {
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
      return new SinnHParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
    }
  }

  public SinnHParticle(
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
    this.setSize(0.7f, 0.7f);
    this.lifetime = 60;
    this.gravity = 0.2f;
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
