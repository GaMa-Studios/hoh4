package gama.studios.hoh4core.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import gama.studios.hoh4core.network.Hoh4CoreModVariables;

public class TimerGetDayProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (Hoh4CoreModVariables.MapVariables.get(world).isTimerActive) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("Timer is active. Today is " + Hoh4CoreModVariables.MapVariables.get(world).DayTimer + " day")), false);
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("Timer is inactive. Last counted day is " + Hoh4CoreModVariables.MapVariables.get(world).DayTimer + " day")), false);
		}
	}
}
