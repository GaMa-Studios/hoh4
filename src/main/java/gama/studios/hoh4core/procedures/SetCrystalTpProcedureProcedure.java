package gama.studios.hoh4core.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;

import java.util.Comparator;

import gama.studios.hoh4core.entity.CrystalEntity;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class SetCrystalTpProcedureProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		Entity crystal = null;
		if (!world.getEntitiesOfClass(CrystalEntity.class, AABB.ofSize(new Vec3(x, y, z), 32, 32, 32), e -> true).isEmpty()) {
			crystal = (Entity) world.getEntitiesOfClass(CrystalEntity.class, AABB.ofSize(new Vec3(x, y, z), 32, 32, 32), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf(x, y, z)).findFirst().orElse(null);
		}
		if (!(crystal == null)) {
			crystal.getPersistentData().putDouble("x", (DoubleArgumentType.getDouble(arguments, "x")));
			crystal.getPersistentData().putDouble("y", (DoubleArgumentType.getDouble(arguments, "y")));
			crystal.getPersistentData().putDouble("z", (DoubleArgumentType.getDouble(arguments, "z")));
			crystal.getPersistentData().putString("modid", (StringArgumentType.getString(arguments, "modid")));
			crystal.getPersistentData().putString("dimension", (StringArgumentType.getString(arguments, "dimension")));
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("previous texture - " + (crystal instanceof CrystalEntity animatable ? animatable.getTexture() : "null"))), false);
			if (DoubleArgumentType.getDouble(arguments, "texture") == -1) {
				if (crystal instanceof CrystalEntity animatable)
					animatable.setTexture("cristall_red");
			} else if (DoubleArgumentType.getDouble(arguments, "texture") == 0) {
				if (crystal instanceof CrystalEntity animatable)
					animatable.setTexture("cristall_purple");
			} else if (DoubleArgumentType.getDouble(arguments, "texture") == 1) {
				if (crystal instanceof CrystalEntity animatable)
					animatable.setTexture("cristall_blue");
			} else if (DoubleArgumentType.getDouble(arguments, "texture") == 2) {
				if (crystal instanceof CrystalEntity animatable)
					animatable.setTexture("cristall_green");
			}
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("no crystal around"), false);
		}
	}
}
