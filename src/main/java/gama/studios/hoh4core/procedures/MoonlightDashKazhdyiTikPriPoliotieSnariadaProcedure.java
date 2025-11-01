package gama.studios.hoh4core.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import gama.studios.hoh4core.Hoh4CoreMod;

public class MoonlightDashKazhdyiTikPriPoliotieSnariadaProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"fill ~-1 ~-1 ~-1 ~1 ~1 ~1 air replace water");
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"fill ~-1 ~-1 ~-1 ~1 ~1 ~1 air replace #minecraft:leaves");
		for (Entity entityiterator : world.getEntities(null, new AABB((x + 1), y, (z + 1), (x + 1), y, (z + 1)))) {
			if (entityiterator.getPersistentData().getBoolean("moon") == false) {
				entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.PLAYER_ATTACK)), 1);
			} else {
				Hoh4CoreMod.queueServerWork(10, () -> {
					entity.getPersistentData().putBoolean("moon", false);
				});
			}
		}
	}
}
