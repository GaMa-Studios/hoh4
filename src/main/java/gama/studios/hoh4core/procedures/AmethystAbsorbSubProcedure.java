package gama.studios.hoh4core.procedures;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.FriendlyByteBuf;

import javax.annotation.Nullable;

import java.util.function.Supplier;

import gama.studios.hoh4core.network.Hoh4CoreModVariables;
import gama.studios.hoh4core.Hoh4CoreMod;

@Mod.EventBusSubscriber(value = {Dist.CLIENT})
public class AmethystAbsorbSubProcedure {
	@SubscribeEvent
	public static void onRightClick(PlayerInteractEvent.RightClickEmpty event) {
		if (event.getHand() != event.getEntity().getUsedItemHand())
			return;
		Hoh4CoreMod.PACKET_HANDLER.sendToServer(new AmethystAbsorbSubMessage());
		execute(event.getEntity());
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class AmethystAbsorbSubMessage {
		public AmethystAbsorbSubMessage() {
		}

		public AmethystAbsorbSubMessage(FriendlyByteBuf buffer) {
		}

		public static void buffer(AmethystAbsorbSubMessage message, FriendlyByteBuf buffer) {
		}

		public static void handler(AmethystAbsorbSubMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getSender().level().hasChunkAt(context.getSender().blockPosition()))
					return;
				execute(context.getSender());
			});
			context.setPacketHandled(true);
		}

		@SubscribeEvent
		public static void registerMessage(FMLCommonSetupEvent event) {
			Hoh4CoreMod.addNetworkMessage(AmethystAbsorbSubMessage.class, AmethystAbsorbSubMessage::buffer, AmethystAbsorbSubMessage::new, AmethystAbsorbSubMessage::handler);
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(Hoh4CoreModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Hoh4CoreModVariables.PlayerVariables())).SpiritForce < (entity.getCapability(Hoh4CoreModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Hoh4CoreModVariables.PlayerVariables())).SpiritForceMax) {
			if (Items.AMETHYST_SHARD == (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem()) {
				(entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).shrink(1);
				{
					double _setval = (entity.getCapability(Hoh4CoreModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Hoh4CoreModVariables.PlayerVariables())).SpiritForce + 10;
					entity.getCapability(Hoh4CoreModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.SpiritForce = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
		if ((entity.getCapability(Hoh4CoreModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Hoh4CoreModVariables.PlayerVariables())).SpiritForce > (entity.getCapability(Hoh4CoreModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Hoh4CoreModVariables.PlayerVariables())).SpiritForceMax) {
			{
				double _setval = (entity.getCapability(Hoh4CoreModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Hoh4CoreModVariables.PlayerVariables())).SpiritForce;
				entity.getCapability(Hoh4CoreModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.SpiritForce = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
