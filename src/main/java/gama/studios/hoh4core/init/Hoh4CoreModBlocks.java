
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package gama.studios.hoh4core.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import gama.studios.hoh4core.block.WarpedCollumnBlock;
import gama.studios.hoh4core.block.SpruceCollumnBlock;
import gama.studios.hoh4core.block.OakCollumnBlock;
import gama.studios.hoh4core.block.MarblecollumnBlock;
import gama.studios.hoh4core.block.MarbleTileBlock;
import gama.studios.hoh4core.block.MarbleStairsBlock;
import gama.studios.hoh4core.block.MarbleSlabBlock;
import gama.studios.hoh4core.block.MarblePillarBlock;
import gama.studios.hoh4core.block.MarbleBlockChiseledBlock;
import gama.studios.hoh4core.block.MarbleBlockChiseledALTBlock;
import gama.studios.hoh4core.block.MarbleBlockBlock;
import gama.studios.hoh4core.block.MangrooveCollumnBlock;
import gama.studios.hoh4core.block.JungleCollumnBlock;
import gama.studios.hoh4core.block.DarkOakCollumnBlock;
import gama.studios.hoh4core.block.CrimsonCollumnBlock;
import gama.studios.hoh4core.block.CherryCollumnBlock;
import gama.studios.hoh4core.block.BirchCollumnBlock;
import gama.studios.hoh4core.block.BackCrystalBlock;
import gama.studios.hoh4core.block.AcaciaCollumnBlock;
import gama.studios.hoh4core.Hoh4CoreMod;

public class Hoh4CoreModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, Hoh4CoreMod.MODID);
	public static final RegistryObject<Block> BACK_CRYSTAL = REGISTRY.register("back_crystal", () -> new BackCrystalBlock());
	public static final RegistryObject<Block> MARBLE_BLOCK = REGISTRY.register("marble_block", () -> new MarbleBlockBlock());
	public static final RegistryObject<Block> MARBLE_BLOCK_CHISELED = REGISTRY.register("marble_block_chiseled", () -> new MarbleBlockChiseledBlock());
	public static final RegistryObject<Block> MARBLE_BLOCK_CHISELED_ALT = REGISTRY.register("marble_block_chiseled_alt", () -> new MarbleBlockChiseledALTBlock());
	public static final RegistryObject<Block> MARBLE_PILLAR = REGISTRY.register("marble_pillar", () -> new MarblePillarBlock());
	public static final RegistryObject<Block> MARBLECOLLUMN = REGISTRY.register("marblecollumn", () -> new MarblecollumnBlock());
	public static final RegistryObject<Block> JUNGLE_COLLUMN = REGISTRY.register("jungle_collumn", () -> new JungleCollumnBlock());
	public static final RegistryObject<Block> OAK_COLLUMN = REGISTRY.register("oak_collumn", () -> new OakCollumnBlock());
	public static final RegistryObject<Block> MANGROOVE_COLLUMN = REGISTRY.register("mangroove_collumn", () -> new MangrooveCollumnBlock());
	public static final RegistryObject<Block> ACACIA_COLLUMN = REGISTRY.register("acacia_collumn", () -> new AcaciaCollumnBlock());
	public static final RegistryObject<Block> BIRCH_COLLUMN = REGISTRY.register("birch_collumn", () -> new BirchCollumnBlock());
	public static final RegistryObject<Block> CHERRY_COLLUMN = REGISTRY.register("cherry_collumn", () -> new CherryCollumnBlock());
	public static final RegistryObject<Block> CRIMSON_COLLUMN = REGISTRY.register("crimson_collumn", () -> new CrimsonCollumnBlock());
	public static final RegistryObject<Block> DARK_OAK_COLLUMN = REGISTRY.register("dark_oak_collumn", () -> new DarkOakCollumnBlock());
	public static final RegistryObject<Block> SPRUCE_COLLUMN = REGISTRY.register("spruce_collumn", () -> new SpruceCollumnBlock());
	public static final RegistryObject<Block> WARPED_COLLUMN = REGISTRY.register("warped_collumn", () -> new WarpedCollumnBlock());
	public static final RegistryObject<Block> MARBLE_TILE = REGISTRY.register("marble_tile", () -> new MarbleTileBlock());
	public static final RegistryObject<Block> MARBLE_SLAB = REGISTRY.register("marble_slab", () -> new MarbleSlabBlock());
	public static final RegistryObject<Block> MARBLE_STAIRS = REGISTRY.register("marble_stairs", () -> new MarbleStairsBlock());
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
