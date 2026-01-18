package gama.studios.hoh4core.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import gama.studios.hoh4core.entity.CrystalEntity;

public class CrystalModel extends GeoModel<CrystalEntity> {
	@Override
	public ResourceLocation getAnimationResource(CrystalEntity entity) {
		return new ResourceLocation("hoh_4_core", "animations/crystall.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(CrystalEntity entity) {
		return new ResourceLocation("hoh_4_core", "geo/crystall.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(CrystalEntity entity) {
		return new ResourceLocation("hoh_4_core", "textures/entities/" + entity.getTexture() + ".png");
	}

}
