
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package gama.studios.hoh4core.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import gama.studios.hoh4core.client.renderer.MoonlightDashRenderer;
import gama.studios.hoh4core.client.renderer.InkblotchRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class Hoh4CoreModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(Hoh4CoreModEntities.MOONLIGHT_DASH.get(), MoonlightDashRenderer::new);
		event.registerEntityRenderer(Hoh4CoreModEntities.INKBLOTCH.get(), InkblotchRenderer::new);
	}
}
