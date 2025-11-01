package gama.studios.hoh4core.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;

import gama.studios.hoh4core.network.Hoh4CoreModVariables;
import gama.studios.hoh4core.init.Hoh4CoreModEntities;
import gama.studios.hoh4core.entity.MoonlightDashEntity;

public class MoonlightSwordPriShchielchkiePKMProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(Hoh4CoreModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Hoh4CoreModVariables.PlayerVariables())).SpiritForce >= 200) {
			entity.getPersistentData().putBoolean("moon", true);
			if (world instanceof ServerLevel projectileLevel) {
				Projectile _entityToSpawn = new Object() {
					public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
						AbstractArrow entityToSpawn = new MoonlightDashEntity(Hoh4CoreModEntities.MOONLIGHT_DASH.get(), level);
						entityToSpawn.setOwner(shooter);
						entityToSpawn.setBaseDamage(damage);
						entityToSpawn.setKnockback(knockback);
						entityToSpawn.setSilent(true);
						entityToSpawn.setPierceLevel(piercing);
						return entityToSpawn;
					}
				}.getArrow(projectileLevel, entity, 36, 1, (byte) 10);
				_entityToSpawn.setPos((entity.getX()), (entity.getY() + 1.5), (entity.getZ()));
				_entityToSpawn.shoot((entity.getLookAngle().x), (entity.getLookAngle().y), (entity.getLookAngle().z), 1, 0);
				projectileLevel.addFreshEntity(_entityToSpawn);
			}
			{
				double _setval = (entity.getCapability(Hoh4CoreModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Hoh4CoreModVariables.PlayerVariables())).SpiritForce - 200;
				entity.getCapability(Hoh4CoreModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.SpiritForce = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
