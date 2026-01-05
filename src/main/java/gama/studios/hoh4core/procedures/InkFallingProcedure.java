package gama.studios.hoh4core.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;

import javax.annotation.Nullable;

import gama.studios.hoh4core.network.Hoh4CoreModVariables;
import gama.studios.hoh4core.init.Hoh4CoreModParticleTypes;

@Mod.EventBusSubscriber
public class InkFallingProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player.getX(), event.player.getY(), event.player.getZ(), event.player);
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double playerlimit = 0;
		if (Hoh4CoreModVariables.WorldVariables.get(world).ink) {
			for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), 1, 10); index0++) {
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (Hoh4CoreModParticleTypes.INK_RAIN.get()), x, (y + 10), z, Mth.nextInt(RandomSource.create(), 1, 10), 5, 1, 5, (Math.random() * 0.8));
			}
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 2, 1, true, false));
		}
	}
}
