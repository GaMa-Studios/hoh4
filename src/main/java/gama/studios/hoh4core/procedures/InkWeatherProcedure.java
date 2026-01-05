package gama.studios.hoh4core.procedures;

import net.minecraft.world.level.LevelAccessor;

import gama.studios.hoh4core.network.Hoh4CoreModVariables;

public class InkWeatherProcedure {
	public static void execute(LevelAccessor world) {
		if (Hoh4CoreModVariables.WorldVariables.get(world).ink) {
			Hoh4CoreModVariables.WorldVariables.get(world).ink = false;
			Hoh4CoreModVariables.WorldVariables.get(world).syncData(world);
		} else {
			Hoh4CoreModVariables.WorldVariables.get(world).ink = true;
			Hoh4CoreModVariables.WorldVariables.get(world).syncData(world);
		}
	}
}
