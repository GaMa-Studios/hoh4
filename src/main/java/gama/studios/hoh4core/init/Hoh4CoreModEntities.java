
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package gama.studios.hoh4core.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import gama.studios.hoh4core.entity.RedCrystalEntity;
import gama.studios.hoh4core.entity.PurpleCrystalEntity;
import gama.studios.hoh4core.entity.MoonlightDashEntity;
import gama.studios.hoh4core.entity.InkblotchEntity;
import gama.studios.hoh4core.entity.GreenCrystalEntity;
import gama.studios.hoh4core.entity.BlueCrystalEntity;
import gama.studios.hoh4core.Hoh4CoreMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class Hoh4CoreModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Hoh4CoreMod.MODID);
	public static final RegistryObject<EntityType<MoonlightDashEntity>> MOONLIGHT_DASH = register("moonlight_dash",
			EntityType.Builder.<MoonlightDashEntity>of(MoonlightDashEntity::new, MobCategory.MISC).setCustomClientFactory(MoonlightDashEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<InkblotchEntity>> INKBLOTCH = register("inkblotch", EntityType.Builder.<InkblotchEntity>of(InkblotchEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
			.setUpdateInterval(3).setCustomClientFactory(InkblotchEntity::new).fireImmune().sized(0.2f, 0.2f));
	public static final RegistryObject<EntityType<PurpleCrystalEntity>> PURPLE_CRYSTAL = register("purple_crystal", EntityType.Builder.<PurpleCrystalEntity>of(PurpleCrystalEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(0).setUpdateInterval(3).setCustomClientFactory(PurpleCrystalEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<RedCrystalEntity>> RED_CRYSTAL = register("red_crystal", EntityType.Builder.<RedCrystalEntity>of(RedCrystalEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(0)
			.setUpdateInterval(3).setCustomClientFactory(RedCrystalEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<BlueCrystalEntity>> BLUE_CRYSTAL = register("blue_crystal", EntityType.Builder.<BlueCrystalEntity>of(BlueCrystalEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(0).setUpdateInterval(3).setCustomClientFactory(BlueCrystalEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<GreenCrystalEntity>> GREEN_CRYSTAL = register("green_crystal", EntityType.Builder.<GreenCrystalEntity>of(GreenCrystalEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(0).setUpdateInterval(3).setCustomClientFactory(GreenCrystalEntity::new).fireImmune().sized(0.6f, 1.8f));

	// Start of user code block custom entities
	// End of user code block custom entities
	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			InkblotchEntity.init();
			PurpleCrystalEntity.init();
			RedCrystalEntity.init();
			BlueCrystalEntity.init();
			GreenCrystalEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(INKBLOTCH.get(), InkblotchEntity.createAttributes().build());
		event.put(PURPLE_CRYSTAL.get(), PurpleCrystalEntity.createAttributes().build());
		event.put(RED_CRYSTAL.get(), RedCrystalEntity.createAttributes().build());
		event.put(BLUE_CRYSTAL.get(), BlueCrystalEntity.createAttributes().build());
		event.put(GREEN_CRYSTAL.get(), GreenCrystalEntity.createAttributes().build());
	}
}
