package gama.studios.hoh4core.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import gama.studios.hoh4core.network.Hoh4CoreModVariables;

public class InkWeatherProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (Hoh4CoreModVariables.WorldVariables.get(world).ink) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"tell @a falsed");
			Hoh4CoreModVariables.WorldVariables.get(world).ink = false;
			Hoh4CoreModVariables.WorldVariables.get(world).syncData(world);
		} else {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(), "tell @a trued");
			Hoh4CoreModVariables.WorldVariables.get(world).ink = true;
			Hoh4CoreModVariables.WorldVariables.get(world).syncData(world);
		}
	}
}
