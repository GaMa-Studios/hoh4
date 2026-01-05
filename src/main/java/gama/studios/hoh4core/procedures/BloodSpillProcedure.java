package gama.studios.hoh4core.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.particles.SimpleParticleType;

import javax.annotation.Nullable;

import gama.studios.hoh4core.init.Hoh4CoreModParticleTypes;
import gama.studios.hoh4core.Hoh4CoreMod;

@Mod.EventBusSubscriber
public class BloodSpillProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getBoolean("ULTRAKILL")) {
			for (int index0 = 0; index0 < 60; index0++) {
				Hoh4CoreMod.queueServerWork(Mth.nextInt(RandomSource.create(), 0, 10), () -> {
					world.addParticle((SimpleParticleType) (Hoh4CoreModParticleTypes.SPILLED_BLOOD.get()), x, (y + entity.getBbHeight() / 1.5), z, (Mth.nextDouble(RandomSource.create(), -0.5, 0.5)),
							(Mth.nextDouble(RandomSource.create(), -0.5, 0.25)), (Mth.nextDouble(RandomSource.create(), -0.5, 0.5)));
				});
			}
		}
	}
}
