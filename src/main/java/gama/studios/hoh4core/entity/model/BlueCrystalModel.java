package gama.studios.hoh4core.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import gama.studios.hoh4core.entity.BlueCrystalEntity;

public class BlueCrystalModel extends GeoModel<BlueCrystalEntity> {
	@Override
	public ResourceLocation getAnimationResource(BlueCrystalEntity entity) {
		return new ResourceLocation("hoh_4_core", "animations/crystall.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(BlueCrystalEntity entity) {
		return new ResourceLocation("hoh_4_core", "geo/crystall.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BlueCrystalEntity entity) {
		return new ResourceLocation("hoh_4_core", "textures/entities/" + entity.getTexture() + ".png");
	}

}
