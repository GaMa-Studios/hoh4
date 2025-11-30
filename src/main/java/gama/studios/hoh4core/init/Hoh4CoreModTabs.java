
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package gama.studios.hoh4core.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import gama.studios.hoh4core.Hoh4CoreMod;

public class Hoh4CoreModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Hoh4CoreMod.MODID);
	public static final RegistryObject<CreativeModeTab> HOH_4 = REGISTRY.register("hoh_4",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.hoh_4_core.hoh_4")).icon(() -> new ItemStack(Blocks.AMETHYST_CLUSTER)).displayItems((parameters, tabData) -> {
				tabData.accept(Hoh4CoreModItems.MOONLIGHT_SWORD.get());
				tabData.accept(Hoh4CoreModItems.PRIMORDIAL_POWER_TALISMAN_CHESTPLATE.get());
				tabData.accept(Hoh4CoreModItems.MOOLIGHTSWORDHALFWORKED.get());
				tabData.accept(Hoh4CoreModItems.MOONLIGHSWORDBROKEN.get());
				tabData.accept(Hoh4CoreModItems.MOON_SHARP.get());
			}).build());
}
