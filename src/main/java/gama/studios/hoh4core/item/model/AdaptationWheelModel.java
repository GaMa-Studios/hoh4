package gama.studios.hoh4core.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import gama.studios.hoh4core.item.AdaptationWheelItem;

public class AdaptationWheelModel extends GeoModel<AdaptationWheelItem> {
	@Override
	public ResourceLocation getAnimationResource(AdaptationWheelItem object) {
		return new ResourceLocation("hoh_4_core", "animations/adaptation_wheel_armor.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(AdaptationWheelItem object) {
		return new ResourceLocation("hoh_4_core", "geo/adaptation_wheel_armor.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(AdaptationWheelItem object) {
		return new ResourceLocation("hoh_4_core", "textures/item/adaptation_wheel.png");
	}
}
