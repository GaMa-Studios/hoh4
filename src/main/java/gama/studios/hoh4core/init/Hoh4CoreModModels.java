
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package gama.studios.hoh4core.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import gama.studios.hoh4core.client.model.Modelbladerush;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class Hoh4CoreModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modelbladerush.LAYER_LOCATION, Modelbladerush::createBodyLayer);
	}
}
