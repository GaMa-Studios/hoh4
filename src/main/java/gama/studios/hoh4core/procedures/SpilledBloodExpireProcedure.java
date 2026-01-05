package gama.studios.hoh4core.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.particles.SimpleParticleType;

import gama.studios.hoh4core.init.Hoh4CoreModParticleTypes;
import gama.studios.hoh4core.Hoh4CoreMod;

public class SpilledBloodExpireProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z, boolean onGround) {
		if (onGround) {
			Hoh4CoreMod.queueServerWork(20, () -> {
				world.addParticle((SimpleParticleType) (Hoh4CoreModParticleTypes.SPILLED_BLOOD.get()), x, y, z, 0, (-1), 0);
			});
			return true;
		}
		return false;
	}
}
