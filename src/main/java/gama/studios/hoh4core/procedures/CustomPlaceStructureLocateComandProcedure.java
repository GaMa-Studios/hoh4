package gama.studios.hoh4core.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.arguments.MessageArgument;
import net.minecraft.commands.CommandSourceStack;

import gama.studios.hoh4core.network.Hoh4CoreModVariables;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;

public class CustomPlaceStructureLocateComandProcedure {
	public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		if (("forge_of_gods").equals((new Object() {
			public String getMessage() {
				try {
					return MessageArgument.getMessage(arguments, "structure").getString();
				} catch (CommandSyntaxException ignored) {
					return "";
				}
			}
		}).getMessage())) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal((Hoh4CoreModVariables.MapVariables.get(world).forge_x + " " + Hoh4CoreModVariables.MapVariables.get(world).forge_y + " " + Hoh4CoreModVariables.MapVariables.get(world).forge_z)), false);
		}
	}
}
