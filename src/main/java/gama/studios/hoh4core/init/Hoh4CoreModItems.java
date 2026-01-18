
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package gama.studios.hoh4core.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.ForgeSpawnEggItem;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import gama.studios.hoh4core.item.PrimordialPowerTalismanItem;
import gama.studios.hoh4core.item.MoonlightSwordItem;
import gama.studios.hoh4core.item.MoonlightDashItemItem;
import gama.studios.hoh4core.item.MoonlighswordbrokenItem;
import gama.studios.hoh4core.item.MoonSharpItem;
import gama.studios.hoh4core.item.MoolightswordhalfworkedItem;
import gama.studios.hoh4core.Hoh4CoreMod;

public class Hoh4CoreModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, Hoh4CoreMod.MODID);
	public static final RegistryObject<Item> MOONLIGHT_SWORD = REGISTRY.register("moonlight_sword", () -> new MoonlightSwordItem());
	public static final RegistryObject<Item> MOONLIGHT_DASH_ITEM = REGISTRY.register("moonlight_dash_item", () -> new MoonlightDashItemItem());
	public static final RegistryObject<Item> BACK_CRYSTAL = block(Hoh4CoreModBlocks.BACK_CRYSTAL);
	public static final RegistryObject<Item> PRIMORDIAL_POWER_TALISMAN_CHESTPLATE = REGISTRY.register("primordial_power_talisman_chestplate", () -> new PrimordialPowerTalismanItem.Chestplate());
	public static final RegistryObject<Item> MOOLIGHTSWORDHALFWORKED = REGISTRY.register("moolightswordhalfworked", () -> new MoolightswordhalfworkedItem());
	public static final RegistryObject<Item> MOONLIGHSWORDBROKEN = REGISTRY.register("moonlighswordbroken", () -> new MoonlighswordbrokenItem());
	public static final RegistryObject<Item> MOON_SHARP = REGISTRY.register("moon_sharp", () -> new MoonSharpItem());
	public static final RegistryObject<Item> MARBLE_BLOCK = block(Hoh4CoreModBlocks.MARBLE_BLOCK);
	public static final RegistryObject<Item> MARBLE_BLOCK_CHISELED = block(Hoh4CoreModBlocks.MARBLE_BLOCK_CHISELED);
	public static final RegistryObject<Item> MARBLE_BLOCK_CHISELED_ALT = block(Hoh4CoreModBlocks.MARBLE_BLOCK_CHISELED_ALT);
	public static final RegistryObject<Item> MARBLE_PILLAR = block(Hoh4CoreModBlocks.MARBLE_PILLAR);
	public static final RegistryObject<Item> MARBLECOLLUMN = block(Hoh4CoreModBlocks.MARBLECOLLUMN);
	public static final RegistryObject<Item> JUNGLE_COLLUMN = block(Hoh4CoreModBlocks.JUNGLE_COLLUMN);
	public static final RegistryObject<Item> OAK_COLLUMN = block(Hoh4CoreModBlocks.OAK_COLLUMN);
	public static final RegistryObject<Item> MANGROOVE_COLLUMN = block(Hoh4CoreModBlocks.MANGROOVE_COLLUMN);
	public static final RegistryObject<Item> ACACIA_COLLUMN = block(Hoh4CoreModBlocks.ACACIA_COLLUMN);
	public static final RegistryObject<Item> BIRCH_COLLUMN = block(Hoh4CoreModBlocks.BIRCH_COLLUMN);
	public static final RegistryObject<Item> CHERRY_COLLUMN = block(Hoh4CoreModBlocks.CHERRY_COLLUMN);
	public static final RegistryObject<Item> CRIMSON_COLLUMN = block(Hoh4CoreModBlocks.CRIMSON_COLLUMN);
	public static final RegistryObject<Item> DARK_OAK_COLLUMN = block(Hoh4CoreModBlocks.DARK_OAK_COLLUMN);
	public static final RegistryObject<Item> SPRUCE_COLLUMN = block(Hoh4CoreModBlocks.SPRUCE_COLLUMN);
	public static final RegistryObject<Item> WARPED_COLLUMN = block(Hoh4CoreModBlocks.WARPED_COLLUMN);
	public static final RegistryObject<Item> MARBLE_TILE = block(Hoh4CoreModBlocks.MARBLE_TILE);
	public static final RegistryObject<Item> MARBLE_SLAB = block(Hoh4CoreModBlocks.MARBLE_SLAB);
	public static final RegistryObject<Item> MARBLE_STAIRS = block(Hoh4CoreModBlocks.MARBLE_STAIRS);
	public static final RegistryObject<Item> CRYSTAL_SPAWN_EGG = REGISTRY.register("crystal_spawn_egg", () -> new ForgeSpawnEggItem(Hoh4CoreModEntities.CRYSTAL, -65332, -16711681, new Item.Properties()));

	// Start of user code block custom items
	// End of user code block custom items
	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
