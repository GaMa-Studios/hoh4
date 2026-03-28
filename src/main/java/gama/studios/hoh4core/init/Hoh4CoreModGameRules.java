
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package gama.studios.hoh4core.init;

import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.GameRules;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class Hoh4CoreModGameRules {
	public static final GameRules.Key<GameRules.BooleanValue> DEBUG_MODE = GameRules.register("debugMode", GameRules.Category.UPDATES, GameRules.BooleanValue.create(false));
}
