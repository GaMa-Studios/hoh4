
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package gama.studios.hoh4core.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.api.distmarker.Dist;

import gama.studios.hoh4core.client.particle.SpilledBloodParticle;
import gama.studios.hoh4core.client.particle.InkRainParticle;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class Hoh4CoreModParticles {
	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(Hoh4CoreModParticleTypes.INK_RAIN.get(), InkRainParticle::provider);
		event.registerSpriteSet(Hoh4CoreModParticleTypes.SPILLED_BLOOD.get(), SpilledBloodParticle::provider);
	}
}
