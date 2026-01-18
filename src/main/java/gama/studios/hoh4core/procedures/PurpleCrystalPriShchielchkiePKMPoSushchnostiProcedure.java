package gama.studios.hoh4core.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import gama.studios.hoh4core.Hoh4CoreMod;

public class PurpleCrystalPriShchielchkiePKMPoSushchnostiProcedure {
	public static void execute(Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		{
			Entity _ent = sourceentity;
			if (!_ent.level().isClientSide() && _ent.getServer() != null) {
				_ent.getServer().getCommands().performPrefixedCommand(
						new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
								_ent.level().getServer(), _ent),
						("execute as @s in " + entity.getPersistentData().getString("dimension") + " run tp @s " + ("" + entity.getPersistentData().getDouble("x")) + " " + ("" + entity.getPersistentData().getDouble("y")) + " "
								+ ("" + entity.getPersistentData().getDouble("z"))));
			}
		}
		Hoh4CoreMod.LOGGER.info("execute as @s in " + entity.getPersistentData().getString("modid") + ":" + entity.getPersistentData().getString("dimension") + " run tp @s " + ("" + entity.getPersistentData().getDouble("x")) + " "
				+ ("" + entity.getPersistentData().getDouble("y")) + " " + ("" + entity.getPersistentData().getDouble("z")));
	}
}
