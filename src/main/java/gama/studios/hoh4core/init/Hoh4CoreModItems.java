
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package gama.studios.hoh4core.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.Item;

import gama.studios.hoh4core.item.MoonlightSwordItem;
import gama.studios.hoh4core.Hoh4CoreMod;

public class Hoh4CoreModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, Hoh4CoreMod.MODID);
	public static final RegistryObject<Item> MOONLIGHT_SWORD = REGISTRY.register("moonlight_sword", () -> new MoonlightSwordItem());
	// Start of user code block custom items
	// End of user code block custom items
}
