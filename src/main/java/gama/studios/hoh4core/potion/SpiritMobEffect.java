
package gama.studios.hoh4core.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import gama.studios.hoh4core.procedures.SpiritForceHealingProcedure;

public class SpiritMobEffect extends MobEffect {
	public SpiritMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -16729900);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		SpiritForceHealingProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
