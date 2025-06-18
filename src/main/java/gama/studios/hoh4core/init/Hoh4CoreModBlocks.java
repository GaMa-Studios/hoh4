
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package gama.studios.hoh4core.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import gama.studios.hoh4core.block.BackCrystalBlock;
import gama.studios.hoh4core.Hoh4CoreMod;

public class Hoh4CoreModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, Hoh4CoreMod.MODID);
	public static final RegistryObject<Block> BACK_CRYSTAL = REGISTRY.register("back_crystal", () -> new BackCrystalBlock());
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
