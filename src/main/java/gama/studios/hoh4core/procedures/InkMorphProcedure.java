package gama.studios.hoh4core.procedures;

import virtuoel.pehkui.api.ScaleTypes;
import virtuoel.pehkui.api.ScaleType;
import virtuoel.pehkui.api.ScaleRegistries;
import virtuoel.pehkui.api.ScaleOperations;

import net.minecraft.world.entity.Entity;

import gama.studios.hoh4core.network.Hoh4CoreModVariables;

public class InkMorphProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(Hoh4CoreModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Hoh4CoreModVariables.PlayerVariables())).ink_morph == false) {
			{
				boolean _setval = true;
				entity.getCapability(Hoh4CoreModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ink_morph = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = ScaleTypes.HEIGHT.getScaleData(entity).getTargetScale();
				entity.getCapability(Hoh4CoreModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.defaultHeight = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			ScaleTypes.HEIGHT.getScaleData(entity).setTargetScale((float) ScaleOperations.SET.applyAsDouble(ScaleTypes.HEIGHT.getScaleData(entity).getTargetScale(),
					((entity.getCapability(Hoh4CoreModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Hoh4CoreModVariables.PlayerVariables())).defaultHeight / 20)));
			ScaleTypes.HEIGHT.getScaleData(entity).setPersistence(true);
			ScaleTypes.THIRD_PERSON.getScaleData(entity).setTargetScale((float) ScaleOperations.ADD.applyAsDouble(ScaleTypes.THIRD_PERSON.getScaleData(entity).getTargetScale(), 40));
		} else {
			{
				boolean _setval = false;
				entity.getCapability(Hoh4CoreModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ink_morph = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			for (final ScaleType type : ScaleRegistries.SCALE_TYPES.values()) {
				type.getScaleData(entity).setPersistence(type.getScaleData(entity).getPersistence());
				type.getScaleData(entity).resetScale();
			}
			ScaleTypes.HEIGHT.getScaleData(entity).setTargetScale((float) ScaleOperations.SET.applyAsDouble(ScaleTypes.HEIGHT.getScaleData(entity).getTargetScale(),
					((entity.getCapability(Hoh4CoreModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Hoh4CoreModVariables.PlayerVariables())).defaultHeight)));
			ScaleTypes.THIRD_PERSON.getScaleData(entity).setTargetScale((float) ScaleOperations.ADD.applyAsDouble(ScaleTypes.THIRD_PERSON.getScaleData(entity).getTargetScale(), (-40)));
		}
	}
}
