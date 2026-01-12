package gama.studios.hoh4core.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import gama.studios.hoh4core.entity.GreenCrystalEntity;

public class GreenCrystalModel extends GeoModel<GreenCrystalEntity> {
	@Override
	public ResourceLocation getAnimationResource(GreenCrystalEntity entity) {
		return new ResourceLocation("hoh_4_core", "animations/crystall.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(GreenCrystalEntity entity) {
		return new ResourceLocation("hoh_4_core", "geo/crystall.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(GreenCrystalEntity entity) {
		return new ResourceLocation("hoh_4_core", "textures/entities/" + entity.getTexture() + ".png");
	}

}
