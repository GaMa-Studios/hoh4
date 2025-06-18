package gama.studios.hoh4core.client.model.animations;

import net.minecraft.client.animation.KeyframeAnimations;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.AnimationChannel;

// Save this class in your mod and generate all required imports
/**
 * Made with Blockbench 4.12.4 Exported for Minecraft version 1.19 or later with
 * Mojang mappings
 * 
 * @author User
 */
public class bladerushAnimation {
	public static final AnimationDefinition start = AnimationDefinition.Builder.withLength(1.0F)
			.addAnimation("down",
					new AnimationChannel(AnimationChannel.Targets.SCALE, new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.0833F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 0.8F), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.125F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0381F), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.2F), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("up",
					new AnimationChannel(AnimationChannel.Targets.SCALE, new Keyframe(0.0417F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.125F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 0.8F), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.1667F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0381F), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.3F), AnimationChannel.Interpolations.LINEAR)))
			.build();
	public static final AnimationDefinition end = AnimationDefinition.Builder.withLength(0.2917F)
			.addAnimation("down",
					new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.0833F, KeyframeAnimations.posVec(0.0F, 0.0F, -8.0F), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("down",
					new AnimationChannel(AnimationChannel.Targets.SCALE, new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.2F), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.0833F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("up",
					new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0.0833F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.1667F, KeyframeAnimations.posVec(0.0F, 0.0F, -9.0F), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("up", new AnimationChannel(AnimationChannel.Targets.SCALE, new Keyframe(0.0833F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.3F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.1667F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)))
			.build();
}
