
package gama.studios.hoh4core.client.particle;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.client.particle.TextureSheetParticle;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.multiplayer.ClientLevel;

import gama.studios.hoh4core.procedures.InkRainParticleExpiryConditionProcedure;

@OnlyIn(Dist.CLIENT)
public class InkRainParticle extends TextureSheetParticle {
	public static InkRainParticleProvider provider(SpriteSet spriteSet) {
		return new InkRainParticleProvider(spriteSet);
	}

	public static class InkRainParticleProvider implements ParticleProvider<SimpleParticleType> {
		private final SpriteSet spriteSet;

		public InkRainParticleProvider(SpriteSet spriteSet) {
			this.spriteSet = spriteSet;
		}

		public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
			return new InkRainParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
		}
	}

	private final SpriteSet spriteSet;

	protected InkRainParticle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet) {
		super(world, x, y, z);
		this.spriteSet = spriteSet;
		this.setSize(0.2f, 0.2f);
		this.quadSize *= 1.5f;
		this.lifetime = (int) Math.max(1, 0 + (this.random.nextInt(40000) - 20000));
		this.gravity = 1f;
		this.hasPhysics = true;
		this.xd = vx * 0;
		this.yd = vy * 0;
		this.zd = vz * 0;
		this.pickSprite(spriteSet);
	}

	@Override
	public ParticleRenderType getRenderType() {
		return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
	}

	@Override
	public void tick() {
		super.tick();
		Level world = this.level;
		if (InkRainParticleExpiryConditionProcedure.execute(world, onGround))
			this.remove();
	}
}
