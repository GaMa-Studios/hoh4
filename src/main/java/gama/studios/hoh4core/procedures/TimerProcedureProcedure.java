package gama.studios.hoh4core.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;

import javax.annotation.Nullable;

import gama.studios.hoh4core.network.Hoh4CoreModVariables;

@Mod.EventBusSubscriber
public class TimerProcedureProcedure {
	@SubscribeEvent
	public static void onWorldTick(TickEvent.LevelTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.level);
		}
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		if (!Hoh4CoreModVariables.MapVariables.get(world).isTodayCount && Hoh4CoreModVariables.MapVariables.get(world).isTimerActive) {
			Hoh4CoreModVariables.MapVariables.get(world).DayTimer = Hoh4CoreModVariables.MapVariables.get(world).DayTimer + 1;
			Hoh4CoreModVariables.MapVariables.get(world).syncData(world);
			Hoh4CoreModVariables.MapVariables.get(world).isTodayCount = true;
			Hoh4CoreModVariables.MapVariables.get(world).syncData(world);
			Hoh4CoreModVariables.MapVariables.get(world).TimerStartDay = world.dimensionType().moonPhase(world.dayTime());
			Hoh4CoreModVariables.MapVariables.get(world).syncData(world);
		}
		if (Hoh4CoreModVariables.MapVariables.get(world).TimerStartDay != world.dimensionType().moonPhase(world.dayTime())) {
			Hoh4CoreModVariables.MapVariables.get(world).isTodayCount = false;
			Hoh4CoreModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
