package gama.studios.hoh4core.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Comparator;

import gama.studios.hoh4core.network.Hoh4CoreModVariables;
import gama.studios.hoh4core.init.Hoh4CoreModParticleTypes;

@Mod.EventBusSubscriber
public class InkFallingProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player.getX(), event.player.getY(), event.player.getZ());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z) {
		execute(null, world, x, y, z);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z) {
		double playerlimit = 0;
		if (Hoh4CoreModVariables.WorldVariables.get(world).ink == true) {
			playerlimit = 1;
			if (world.players().size() > 1) {
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(48 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						playerlimit = playerlimit + 0.33;
					}
				}
				for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), 1, 10); index0++) {
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (Hoh4CoreModParticleTypes.INK_RAIN.get()), x, (y + 10), z, Mth.nextInt(RandomSource.create(), 1, 10), 5, 1, 5, (Math.random() * 0.8));
				}
			} else {
				for (int index1 = 0; index1 < Mth.nextInt(RandomSource.create(), 1, 10); index1++) {
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (Hoh4CoreModParticleTypes.INK_RAIN.get()), x, (y + 10), z, Mth.nextInt(RandomSource.create(), 1, 10), 5, 1, 5, (Math.random() * 0.8));
				}
			}
		}
	}
}
