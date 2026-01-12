package gama.studios.hoh4core.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import gama.studios.hoh4core.entity.PurpleCrystalEntity;

public class PurpleCrystalModel extends GeoModel<PurpleCrystalEntity> {
	@Override
	public ResourceLocation getAnimationResource(PurpleCrystalEntity entity) {
		return new ResourceLocation("hoh_4_core", "animations/crystall.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(PurpleCrystalEntity entity) {
		return new ResourceLocation("hoh_4_core", "geo/crystall.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(PurpleCrystalEntity entity) {
		return new ResourceLocation("hoh_4_core", "textures/entities/" + entity.getTexture() + ".png");
	}

}
