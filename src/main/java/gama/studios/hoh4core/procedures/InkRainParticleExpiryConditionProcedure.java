package gama.studios.hoh4core.procedures;

public class InkRainParticleExpiryConditionProcedure {
	public static boolean execute(boolean onGround) {
		if (onGround) {
			return true;
		}
		return false;
	}
}
