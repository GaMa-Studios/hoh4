
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package gama.studios.hoh4core.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import gama.studios.hoh4core.world.inventory.GodsAnvilGuiMenu;
import gama.studios.hoh4core.Hoh4CoreMod;

public class Hoh4CoreModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, Hoh4CoreMod.MODID);
	public static final RegistryObject<MenuType<GodsAnvilGuiMenu>> GODS_ANVIL_GUI = REGISTRY.register("gods_anvil_gui", () -> IForgeMenuType.create(GodsAnvilGuiMenu::new));
}
