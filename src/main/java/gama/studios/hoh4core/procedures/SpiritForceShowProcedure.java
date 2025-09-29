package gama.studios.hoh4core.procedures;

import net.minecraft.world.entity.Entity;

import gama.studios.hoh4core.network.Hoh4CoreModVariables;

public class SpiritForceShowProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return (entity.getCapability(Hoh4CoreModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Hoh4CoreModVariables.PlayerVariables())).SpiritForce + "/"
				+ (entity.getCapability(Hoh4CoreModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Hoh4CoreModVariables.PlayerVariables())).SpiritForceMax;
	}
}
