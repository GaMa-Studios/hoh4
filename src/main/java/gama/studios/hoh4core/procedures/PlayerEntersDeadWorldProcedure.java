package gama.studios.hoh4core.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

import gama.studios.hoh4core.network.Hoh4CoreModVariables;
import gama.studios.hoh4core.init.Hoh4CoreModBlocks;
import gama.studios.hoh4core.Hoh4CoreMod;

@Mod.EventBusSubscriber
public class PlayerEntersDeadWorldProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level());
		}
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		if ((world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD)) == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("hoh_4_core:death_world"))
				&& Hoh4CoreModVariables.MapVariables.get(world).deathworld == false) {
			world.setBlock(BlockPos.containing(0, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, 0, 0) + 1, 0), Hoh4CoreModBlocks.BACK_CRYSTAL.get().defaultBlockState(), 3);
			Hoh4CoreMod.queueServerWork(1, () -> {
				Hoh4CoreModVariables.MapVariables.get(world).deathworld = true;
				Hoh4CoreModVariables.MapVariables.get(world).syncData(world);
			});
		}
	}
}
