
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package gama.studios.hoh4core.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

import gama.studios.hoh4core.Hoh4CoreMod;

public class Hoh4CoreModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, Hoh4CoreMod.MODID);
	public static final RegistryObject<SimpleParticleType> INK_RAIN = REGISTRY.register("ink_rain", () -> new SimpleParticleType(false));
}
