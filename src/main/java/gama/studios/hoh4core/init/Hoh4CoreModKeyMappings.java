
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package gama.studios.hoh4core.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import gama.studios.hoh4core.network.SpiritForceMoreMessage;
import gama.studios.hoh4core.Hoh4CoreMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class Hoh4CoreModKeyMappings {
	public static final KeyMapping SPIRIT_FORCE_MORE = new KeyMapping("key.hoh_4_core.spirit_force_more", GLFW.GLFW_KEY_O, "key.categories.gameplay") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				Hoh4CoreMod.PACKET_HANDLER.sendToServer(new SpiritForceMoreMessage(0, 0));
				SpiritForceMoreMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(SPIRIT_FORCE_MORE);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				SPIRIT_FORCE_MORE.consumeClick();
			}
		}
	}
}
