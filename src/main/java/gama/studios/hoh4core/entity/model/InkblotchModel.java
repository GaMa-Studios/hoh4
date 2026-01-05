package gama.studios.hoh4core.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import gama.studios.hoh4core.entity.InkblotchEntity;

public class InkblotchModel extends GeoModel<InkblotchEntity> {
	@Override
	public ResourceLocation getAnimationResource(InkblotchEntity entity) {
		return new ResourceLocation("hoh_4_core", "animations/ink_blotch.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(InkblotchEntity entity) {
		return new ResourceLocation("hoh_4_core", "geo/ink_blotch.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(InkblotchEntity entity) {
		return new ResourceLocation("hoh_4_core", "textures/entities/" + entity.getTexture() + ".png");
	}

}
