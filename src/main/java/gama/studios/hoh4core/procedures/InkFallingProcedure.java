package gama.studios.hoh4core.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

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
		double x1 = 0;
		double y1 = 0;
		if (Hoh4CoreModVariables.MapVariables.get(world).ink == true) {
			if (world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z))) {
				if (Math.random() > 0.1) {
					for (int index0 = 0; index0 < (int) (Math.random() * 10); index0++) {
						y1 = Math.random() + z;
						x1 = Math.random() + x;
						if (world instanceof ServerLevel _level)
							_level.sendParticles((SimpleParticleType) (Hoh4CoreModParticleTypes.INK_PARTICLE.get()), x1, (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x1, (int) y1) + 10), y1, 5, 0,
									(world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x1, (int) y1)), 0, 0.1);
					}
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 20, 1, true, true));
				}
				if (Math.random() > 0.1) {
					for (int index1 = 0; index1 < (int) (Math.random() * 10); index1++) {
						y1 = z - Math.random();
					}
				}
				if (Math.random() > 0.1) {
					for (int index2 = 0; index2 < (int) (Math.random() * 10); index2++) {
						y1 = Math.random() * 10 + z;
						x1 = Math.random() * 10 + x;
						if (world instanceof ServerLevel _level)
							_level.sendParticles((SimpleParticleType) (Hoh4CoreModParticleTypes.INK_PARTICLE.get()), x1, (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x1, (int) y1) + 10), y1, 5, 0,
									(world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x1, (int) y1)), 0, 0.1);
					}
				}
				if (Math.random() > 0.1) {
					for (int index3 = 0; index3 < (int) (Math.random() * 10); index3++) {
						y1 = z - Math.random() * 10;
						x1 = x - Math.random() * 10;
						if (world instanceof ServerLevel _level)
							_level.sendParticles((SimpleParticleType) (Hoh4CoreModParticleTypes.INK_PARTICLE.get()), x1, (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x1, (int) y1) + 10), y1, 5, 0,
									(world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x1, (int) y1)), 0, 0.1);
					}
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 20, 1, true, true));
				}
				if (Math.random() > 0.1) {
					for (int index4 = 0; index4 < (int) (Math.random() * 10); index4++) {
						y1 = Math.random() * 5 + z;
						x1 = Math.random() * 5 + x;
						if (world instanceof ServerLevel _level)
							_level.sendParticles((SimpleParticleType) (Hoh4CoreModParticleTypes.INK_PARTICLE.get()), x1, (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x1, (int) y1) + 10), y1, 5, 0,
									(world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x1, (int) y1)), 0, 0.1);
					}
				}
				if (Math.random() > 0.1) {
					for (int index5 = 0; index5 < (int) (Math.random() * 10); index5++) {
						y1 = z - Math.random() * 5;
						x1 = x - Math.random() * 5;
						if (world instanceof ServerLevel _level)
							_level.sendParticles((SimpleParticleType) (Hoh4CoreModParticleTypes.INK_PARTICLE.get()), x1, (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x1, (int) y1) + 10), y1, 5, 0,
									(world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x1, (int) y1)), 0, 0.1);
					}
				}
				if (Math.random() > 0.1) {
					for (int index6 = 0; index6 < (int) (Math.random() * 10); index6++) {
						y1 = Math.random() * 2 + z;
						x1 = Math.random() * 2 + x;
						if (world instanceof ServerLevel _level)
							_level.sendParticles((SimpleParticleType) (Hoh4CoreModParticleTypes.INK_PARTICLE.get()), x1, (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x1, (int) y1) + 10), y1, 5, 0,
									(world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x1, (int) y1)), 0, 0.1);
					}
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 20, 1, true, true));
				}
				if (Math.random() > 0.1) {
					for (int index7 = 0; index7 < (int) (Math.random() * 10); index7++) {
						y1 = z - Math.random() * 2;
						x1 = x - Math.random() * 2;
						if (world instanceof ServerLevel _level)
							_level.sendParticles((SimpleParticleType) (Hoh4CoreModParticleTypes.INK_PARTICLE.get()), x1, (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x1, (int) y1) + 10), y1, 5, 0,
									(world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x1, (int) y1)), 0, 0.1);
					}
				}
				if (Math.random() > 0.1) {
					for (int index8 = 0; index8 < (int) (Math.random() * 10); index8++) {
						y1 = Math.random() * 8 + z;
						x1 = Math.random() * 8 + x;
						if (world instanceof ServerLevel _level)
							_level.sendParticles((SimpleParticleType) (Hoh4CoreModParticleTypes.INK_PARTICLE.get()), x1, (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x1, (int) y1) + 10), y1, 5, 0,
									(world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x1, (int) y1)), 0, 0.1);
					}
				}
				if (Math.random() > 0.1) {
					for (int index9 = 0; index9 < (int) (Math.random() * 10); index9++) {
						y1 = z - Math.random() * 8;
						x1 = x - Math.random() * 8;
						if (world instanceof ServerLevel _level)
							_level.sendParticles((SimpleParticleType) (Hoh4CoreModParticleTypes.INK_PARTICLE.get()), x1, (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x1, (int) y1) + 10), y1, 5, 0,
									(world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x1, (int) y1)), 0, 0.1);
					}
				}
			}
		}
	}
}
