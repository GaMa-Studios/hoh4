package gama.studios.hoh4core.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.EntityTravelToDimensionEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import javax.annotation.Nullable;

import gama.studios.hoh4core.network.Hoh4CoreModVariables;

@Mod.EventBusSubscriber
public class ForgeGenerateProcedure {
	@SubscribeEvent
	public static void onEntityTravelToDimension(EntityTravelToDimensionEvent event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getDimension(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, ResourceKey<Level> dimension, Entity entity) {
		execute(null, world, x, y, z, dimension, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, ResourceKey<Level> dimension, Entity entity) {
		if (dimension == null || entity == null)
			return;
		double xx = 0;
		double yy = 0;
		double zz = 0;
		if (entity instanceof Player) {
			if (Hoh4CoreModVariables.MapVariables.get(world).isForgeGenerated == false) {
				if (("ResourceKey[minecraft:dimension / hoh_4_core:moon]").equals("" + dimension)) {
					xx = x;
					yy = y;
					zz = z;
					if (0.5 < Math.random()) {
						Hoh4CoreModVariables.MapVariables.get(world).forge_x = Mth.nextInt(RandomSource.create(), 100, 2000);
						Hoh4CoreModVariables.MapVariables.get(world).syncData(world);
					} else {
						Hoh4CoreModVariables.MapVariables.get(world).forge_x = Mth.nextInt(RandomSource.create(), -2000, -1000);
						Hoh4CoreModVariables.MapVariables.get(world).syncData(world);
					}
					if (0.5 < Math.random()) {
						Hoh4CoreModVariables.MapVariables.get(world).forge_z = Mth.nextInt(RandomSource.create(), 1000, 2000);
						Hoh4CoreModVariables.MapVariables.get(world).syncData(world);
					} else {
						Hoh4CoreModVariables.MapVariables.get(world).forge_z = Mth.nextInt(RandomSource.create(), -2000, -1000);
						Hoh4CoreModVariables.MapVariables.get(world).syncData(world);
					}
					Hoh4CoreModVariables.MapVariables.get(world).forge_y = Mth.nextInt(RandomSource.create(), 200, 220);
					Hoh4CoreModVariables.MapVariables.get(world).syncData(world);
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, new Vec3(Hoh4CoreModVariables.MapVariables.get(world).forge_x, Hoh4CoreModVariables.MapVariables.get(world).forge_y, Hoh4CoreModVariables.MapVariables.get(world).forge_z),
										Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								("execute positioned " + Hoh4CoreModVariables.MapVariables.get(world).forge_x + " " + Hoh4CoreModVariables.MapVariables.get(world).forge_y + " " + Hoh4CoreModVariables.MapVariables.get(world).forge_z
										+ " in hoh_4_core:moon run customsetstructure forge_of_gods"));
					Hoh4CoreModVariables.MapVariables.get(world).isForgeGenerated = true;
					Hoh4CoreModVariables.MapVariables.get(world).syncData(world);
				}
			}
		}
	}
}
