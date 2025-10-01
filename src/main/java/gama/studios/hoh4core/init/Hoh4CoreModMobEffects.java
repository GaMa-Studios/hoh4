
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package gama.studios.hoh4core.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

import gama.studios.hoh4core.potion.SpiritMobEffect;
import gama.studios.hoh4core.Hoh4CoreMod;

public class Hoh4CoreModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, Hoh4CoreMod.MODID);
	public static final RegistryObject<MobEffect> SPIRIT = REGISTRY.register("spirit", () -> new SpiritMobEffect());
}
