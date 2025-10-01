package gama.studios.hoh4core.procedures;

import net.minecraft.world.entity.Entity;

import gama.studios.hoh4core.network.Hoh4CoreModVariables;

public class SpiritForceHealingProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(Hoh4CoreModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Hoh4CoreModVariables.PlayerVariables())).SpiritForce < (entity.getCapability(Hoh4CoreModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Hoh4CoreModVariables.PlayerVariables())).SpiritForceMax) {
			{
				double _setval = Math.round(Math.random() * 15) + (entity.getCapability(Hoh4CoreModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Hoh4CoreModVariables.PlayerVariables())).SpiritForce;
				entity.getCapability(Hoh4CoreModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.SpiritForce = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else {
			{
				double _setval = (entity.getCapability(Hoh4CoreModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Hoh4CoreModVariables.PlayerVariables())).SpiritForceMax;
				entity.getCapability(Hoh4CoreModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.SpiritForce = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
