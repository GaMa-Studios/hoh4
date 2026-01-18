
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
				tabData.accept(Hoh4CoreModBlocks.MARBLE_BLOCK.get().asItem());
				tabData.accept(Hoh4CoreModBlocks.MARBLE_TILE.get().asItem());
				tabData.accept(Hoh4CoreModBlocks.MARBLE_BLOCK_CHISELED.get().asItem());
				tabData.accept(Hoh4CoreModBlocks.MARBLE_BLOCK_CHISELED_ALT.get().asItem());
				tabData.accept(Hoh4CoreModBlocks.MARBLE_PILLAR.get().asItem());
				tabData.accept(Hoh4CoreModBlocks.MARBLECOLLUMN.get().asItem());
				tabData.accept(Hoh4CoreModItems.PRIMORDIAL_POWER_TALISMAN_CHESTPLATE.get());
				tabData.accept(Hoh4CoreModItems.MOONLIGHT_SWORD.get());
				tabData.accept(Hoh4CoreModItems.MOOLIGHTSWORDHALFWORKED.get());
				tabData.accept(Hoh4CoreModItems.MOONLIGHSWORDBROKEN.get());
				tabData.accept(Hoh4CoreModItems.MOON_SHARP.get());
				tabData.accept(Hoh4CoreModBlocks.JUNGLE_COLLUMN.get().asItem());
				tabData.accept(Hoh4CoreModBlocks.OAK_COLLUMN.get().asItem());
				tabData.accept(Hoh4CoreModBlocks.MANGROOVE_COLLUMN.get().asItem());
				tabData.accept(Hoh4CoreModBlocks.ACACIA_COLLUMN.get().asItem());
				tabData.accept(Hoh4CoreModBlocks.BIRCH_COLLUMN.get().asItem());
				tabData.accept(Hoh4CoreModBlocks.CHERRY_COLLUMN.get().asItem());
				tabData.accept(Hoh4CoreModBlocks.CRIMSON_COLLUMN.get().asItem());
				tabData.accept(Hoh4CoreModBlocks.DARK_OAK_COLLUMN.get().asItem());
				tabData.accept(Hoh4CoreModBlocks.SPRUCE_COLLUMN.get().asItem());
				tabData.accept(Hoh4CoreModBlocks.WARPED_COLLUMN.get().asItem());
				tabData.accept(Hoh4CoreModBlocks.MARBLE_STAIRS.get().asItem());
				tabData.accept(Hoh4CoreModBlocks.MARBLE_SLAB.get().asItem());
				tabData.accept(Hoh4CoreModItems.CRYSTAL_SPAWN_EGG.get());
			}).build());
}
