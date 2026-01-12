package gama.studios.hoh4core.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.commands.CommandSourceStack;

import java.util.List;
import java.util.Comparator;

import gama.studios.hoh4core.entity.RedCrystalEntity;
import gama.studios.hoh4core.entity.PurpleCrystalEntity;
import gama.studios.hoh4core.entity.GreenCrystalEntity;
import gama.studios.hoh4core.entity.BlueCrystalEntity;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class SetCrystalTpProcedureProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (entityiterator instanceof BlueCrystalEntity || entityiterator instanceof GreenCrystalEntity || entityiterator instanceof PurpleCrystalEntity || entityiterator instanceof RedCrystalEntity) {
					entity.getPersistentData().putDouble("x", (DoubleArgumentType.getDouble(arguments, "x")));
					entity.getPersistentData().putDouble("y", (DoubleArgumentType.getDouble(arguments, "y")));
					entity.getPersistentData().putDouble("z", (DoubleArgumentType.getDouble(arguments, "z")));
					entity.getPersistentData().putString("dimension", (StringArgumentType.getString(arguments, "dimension")));
				}
			}
		}
	}
}
