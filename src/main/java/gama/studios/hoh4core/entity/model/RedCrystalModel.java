package gama.studios.hoh4core.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import gama.studios.hoh4core.entity.RedCrystalEntity;

public class RedCrystalModel extends GeoModel<RedCrystalEntity> {
	@Override
	public ResourceLocation getAnimationResource(RedCrystalEntity entity) {
		return new ResourceLocation("hoh_4_core", "animations/crystall.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(RedCrystalEntity entity) {
		return new ResourceLocation("hoh_4_core", "geo/crystall.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(RedCrystalEntity entity) {
		return new ResourceLocation("hoh_4_core", "textures/entities/" + entity.getTexture() + ".png");
	}

}
