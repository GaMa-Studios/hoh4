package gama.studios.hoh4core.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Comparator;

import gama.studios.hoh4core.network.Hoh4CoreModVariables;
import gama.studios.hoh4core.entity.InkblotchEntity;
import gama.studios.hoh4core.Hoh4CoreMod;

@Mod.EventBusSubscriber
public class InkMorphingProcedure {
	@SubscribeEvent
	public static void onEntityTick(LivingEvent.LivingTickEvent event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double rotation = 0;
		double x1 = 0;
		double y1 = 0;
		double z1 = 0;
		if (entity instanceof Player) {
			if ((entity.getCapability(Hoh4CoreModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Hoh4CoreModVariables.PlayerVariables())).ink_morph) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 60, 1, true, true));
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("tp @e[tag=" + entity.getDisplayName().getString() + "] " + entity.getDisplayName().getString()));
					}
				}
				if (entity.isInWater()) {
					Hoh4CoreMod.LOGGER.info("\u0412\u041E\u0414\u0410");
					if (Math.random() > 0.8) {
						if (Math.random() > 0.8) {
							{
								Entity _ent = entity;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
											4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "damage @s 1 minecraft:drown");
								}
							}
						}
					}
				}
			}
		}
		if (entity instanceof InkblotchEntity) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if ((entity.getPersistentData().getString("owner")).equals(entityiterator.getDisplayName().getString())) {
						rotation = entityiterator.getYRot();
						{
							Entity _ent = entity;
							_ent.setYRot((float) rotation);
							_ent.setXRot(0);
							_ent.setYBodyRot(_ent.getYRot());
							_ent.setYHeadRot(_ent.getYRot());
							_ent.yRotO = _ent.getYRot();
							_ent.xRotO = _ent.getXRot();
							if (_ent instanceof LivingEntity _entity) {
								_entity.yBodyRotO = _entity.getYRot();
								_entity.yHeadRotO = _entity.getYRot();
							}
						}
						x1 = entityiterator.getX();
						y1 = entityiterator.getY();
						z1 = entityiterator.getZ();
						if (entity instanceof Mob _entity)
							_entity.getNavigation().moveTo(x1, y1, z1, 3);
					}
				}
			}
			if (0 > entity.getDeltaMovement().y()) {
				if (entity instanceof InkblotchEntity) {
					((InkblotchEntity) entity).setAnimation("fall");
				}
			} else {
				if (entity instanceof InkblotchEntity) {
					((InkblotchEntity) entity).setAnimation("empty");
				}
			}
			if (900 > (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1)) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.HEAL, 60, 255, true, true));
			}
		}
	}
}
