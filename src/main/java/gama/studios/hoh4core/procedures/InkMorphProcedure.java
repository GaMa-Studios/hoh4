package gama.studios.hoh4core.procedures;

import net.minecraftforge.eventbus.api.Event;

public class InkMorphProcedure {
public static void execute(
Entity entity
) {
if(
entity == null
) return ;
if (==false) {ScaleTypes.HEIGHT.getScaleData(entity).setTargetScale((float) ScaleOperations.SET.applyAsDouble(ScaleTypes.HEIGHT.getScaleData(entity).getTargetScale(), (/ 20)));ScaleTypes.HEIGHT.getScaleData(entity).setPersistence(true);ScaleTypes.THIRD_PERSON.getScaleData(entity).setTargetScale((float) ScaleOperations.ADD.applyAsDouble(ScaleTypes.THIRD_PERSON.getScaleData(entity).getTargetScale(), 40));}else{for (final ScaleType type : ScaleRegistries.SCALE_TYPES.values()){
type.getScaleData(entity).setPersistence(type.getScaleData(entity).getPersistence());
type.getScaleData(entity).resetScale();
}ScaleTypes.HEIGHT.getScaleData(entity).setTargetScale((float) ScaleOperations.SET.applyAsDouble(ScaleTypes.HEIGHT.getScaleData(entity).getTargetScale(), ));ScaleTypes.THIRD_PERSON.getScaleData(entity).setTargetScale((float) ScaleOperations.ADD.applyAsDouble(ScaleTypes.THIRD_PERSON.getScaleData(entity).getTargetScale(), (-40)));}
}
}
