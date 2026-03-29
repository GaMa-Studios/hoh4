package gama.studios.hoh4core.procedures;

import software.bernie.geckolib.animatable.GeoItem;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import javax.annotation.Nullable;

import gama.studios.hoh4core.network.Hoh4CoreModVariables;
import gama.studios.hoh4core.item.AdaptationWheelItem;
import gama.studios.hoh4core.init.Hoh4CoreModItems;
import gama.studios.hoh4core.init.Hoh4CoreModGameRules;
import gama.studios.hoh4core.Hoh4CoreMod;

@Mod.EventBusSubscriber
public class AdaptationWheelTimerProcedure {
	@SubscribeEvent
	public static void onEntityTick(LivingEvent.LivingTickEvent event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double random100 = 0;
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == Hoh4CoreModItems.ADAPTATION_WHEEL_HELMET.get()) {
			if (260 <= (entity.getCapability(Hoh4CoreModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Hoh4CoreModVariables.PlayerVariables())).adpatationWheelTimer) {
				{
					double _setval = 0;
					entity.getCapability(Hoh4CoreModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.adpatationWheelTimer = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() instanceof AdaptationWheelItem armor && armor instanceof GeoItem)
					(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().putString("geckoAnim", "adaptaion.wheel.rotate");
				entity.getPersistentData().putDouble("random100", (Mth.nextInt(RandomSource.create(), 1, 100)));
				if (world.getLevelData().getGameRules().getBoolean(Hoh4CoreModGameRules.DEBUG_MODE)) {
					Hoh4CoreMod.LOGGER.info("random110 of adaptation wheel is " + entity.getPersistentData().getDouble("random100"));
				}
				Hoh4CoreMod.queueServerWork(60, () -> {
					if (20 >= entity.getPersistentData().getDouble("random100")) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 190, 1));
					} else {
						if (40 >= entity.getPersistentData().getDouble("random100")) {
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 190, 1));
						} else {
							if (60 >= entity.getPersistentData().getDouble("random100")) {
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 190, 1));
							} else {
								if (80 >= entity.getPersistentData().getDouble("random100")) {
									if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 190, 1));
								} else {
									if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 190, 1));
								}
							}
						}
					}
				});
			} else {
				{
					double _setval = 1 + (entity.getCapability(Hoh4CoreModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Hoh4CoreModVariables.PlayerVariables())).adpatationWheelTimer;
					entity.getCapability(Hoh4CoreModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.adpatationWheelTimer = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}
}
