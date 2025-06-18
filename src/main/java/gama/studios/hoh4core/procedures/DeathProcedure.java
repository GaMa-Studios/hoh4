package gama.studios.hoh4core.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import javax.annotation.Nullable;

import gama.studios.hoh4core.network.Hoh4CoreModVariables;

@Mod.EventBusSubscriber
public class DeathProcedure {
	@SubscribeEvent
	public static void onPlayerRespawned(PlayerEvent.PlayerRespawnEvent event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(Hoh4CoreModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Hoh4CoreModVariables.PlayerVariables())).status == 0) {
			{
				double _setval = -1;
				entity.getCapability(Hoh4CoreModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.status = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = entity.getX();
				entity.getCapability(Hoh4CoreModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.respx = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = entity.getY();
				entity.getCapability(Hoh4CoreModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.respy = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = entity.getZ();
				entity.getCapability(Hoh4CoreModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.respz = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "/execute in hoh_4_core:death_world run tp @s 0 300 0");
				}
			}
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 512, 0));
		}
		if ((entity.getCapability(Hoh4CoreModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Hoh4CoreModVariables.PlayerVariables())).status == -1) {
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "/execute in hoh_4_core:death_world run tp @s 0 300 0");
				}
			}
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 512, 0));
		}
	}
}
