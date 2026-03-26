package gama.studios.hoh4core.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import gama.studios.hoh4core.network.Hoh4CoreModVariables;

public class TimerStopProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		String output = "";
		if (Hoh4CoreModVariables.MapVariables.get(world).isTimerActive) {
			output = "Timer is inactive now";
			Hoh4CoreModVariables.MapVariables.get(world).isTimerActive = false;
			Hoh4CoreModVariables.MapVariables.get(world).syncData(world);
		} else {
			output = "Timer was inactive";
		}
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(output), false);
	}
}
