package gama.studios.hoh4core.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.EntityTravelToDimensionEvent;

import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.BlockPos;

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
					{
						Entity _ent = entity;
						_ent.teleportTo(Hoh4CoreModVariables.MapVariables.get(world).forge_x, Hoh4CoreModVariables.MapVariables.get(world).forge_y, Hoh4CoreModVariables.MapVariables.get(world).forge_z);
						if (_ent instanceof ServerPlayer _serverPlayer)
							_serverPlayer.connection.teleport(Hoh4CoreModVariables.MapVariables.get(world).forge_x, Hoh4CoreModVariables.MapVariables.get(world).forge_y, Hoh4CoreModVariables.MapVariables.get(world).forge_z, _ent.getYRot(),
									_ent.getXRot());
					}
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("hoh_4_core", "forge_of_gods"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x, y, z), BlockPos.containing(x, y, z),
									new StructurePlaceSettings().setRotation(Rotation.getRandom(_serverworld.random)).setMirror(Mirror.values()[_serverworld.random.nextInt(2)]).setIgnoreEntities(false), _serverworld.random, 3);
						}
					}
					Hoh4CoreModVariables.MapVariables.get(world).isForgeGenerated = true;
					Hoh4CoreModVariables.MapVariables.get(world).syncData(world);
					{
						Entity _ent = entity;
						_ent.teleportTo(xx, yy, zz);
						if (_ent instanceof ServerPlayer _serverPlayer)
							_serverPlayer.connection.teleport(xx, yy, zz, _ent.getYRot(), _ent.getXRot());
					}
				}
			}
		}
	}
}
