package gama.studios.hoh4core.procedures;

import net.minecraft.world.level.LevelAccessor;

import gama.studios.hoh4core.Hoh4CoreMod;

public class InkRainParticleExpiryConditionProcedure {
	public static boolean execute(LevelAccessor world, boolean onGround) {
		if (onGround) {
			Hoh4CoreMod.queueServerWork(20, () -> {
			});
			return true;
		}
		return false;
	}
}
