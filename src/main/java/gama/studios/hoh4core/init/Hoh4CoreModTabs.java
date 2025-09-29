
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package gama.studios.hoh4core.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import gama.studios.hoh4core.Hoh4CoreMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class Hoh4CoreModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Hoh4CoreMod.MODID);
	public static final RegistryObject<CreativeModeTab> HOH_4 = REGISTRY.register("hoh_4",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.hoh_4_core.hoh_4")).icon(() -> new ItemStack(Blocks.AMETHYST_CLUSTER)).displayItems((parameters, tabData) -> {
				tabData.accept(Hoh4CoreModItems.MOONLIGHT_SWORD.get());
				tabData.accept(Hoh4CoreModItems.PRIMORDIAL_POWER_TALISMAN_CHESTPLATE.get());
			}).build());

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
			tabData.accept(Hoh4CoreModItems.MOOLIGHTSWORDHALFWORKED.get());
		}
	}
}
