
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package gama.studios.hoh4core.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import gama.studios.hoh4core.item.PrimordialPowerTalismanItem;
import gama.studios.hoh4core.item.MoonlightSwordItem;
import gama.studios.hoh4core.item.MoonlightDashItemItem;
import gama.studios.hoh4core.Hoh4CoreMod;

public class Hoh4CoreModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, Hoh4CoreMod.MODID);
	public static final RegistryObject<Item> MOONLIGHT_SWORD = REGISTRY.register("moonlight_sword", () -> new MoonlightSwordItem());
	public static final RegistryObject<Item> MOONLIGHT_DASH_ITEM = REGISTRY.register("moonlight_dash_item", () -> new MoonlightDashItemItem());
	public static final RegistryObject<Item> BACK_CRYSTAL = block(Hoh4CoreModBlocks.BACK_CRYSTAL);
	public static final RegistryObject<Item> PRIMORDIAL_POWER_TALISMAN_CHESTPLATE = REGISTRY.register("primordial_power_talisman_chestplate", () -> new PrimordialPowerTalismanItem.Chestplate());

	// Start of user code block custom items
	// End of user code block custom items
	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
