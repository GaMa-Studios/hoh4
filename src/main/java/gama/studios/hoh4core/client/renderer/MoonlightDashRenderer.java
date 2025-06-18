package gama.studios.hoh4core.client.renderer;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import gama.studios.hoh4core.entity.MoonlightDashEntity;
import gama.studios.hoh4core.client.model.Modelbladerush;

import com.mojang.math.Axis;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class MoonlightDashRenderer extends EntityRenderer<MoonlightDashEntity> {
	private static final ResourceLocation texture = new ResourceLocation("hoh_4_core:textures/entities/blue_bladerush.png");
	private final Modelbladerush model;

	public MoonlightDashRenderer(EntityRendererProvider.Context context) {
		super(context);
		model = new Modelbladerush(context.bakeLayer(Modelbladerush.LAYER_LOCATION));
	}

	@Override
	public void render(MoonlightDashEntity entityIn, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource bufferIn, int packedLightIn) {
		VertexConsumer vb = bufferIn.getBuffer(RenderType.entityCutout(this.getTextureLocation(entityIn)));
		poseStack.pushPose();
		poseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTicks, entityIn.yRotO, entityIn.getYRot()) - 90));
		poseStack.mulPose(Axis.ZP.rotationDegrees(90 + Mth.lerp(partialTicks, entityIn.xRotO, entityIn.getXRot())));
		model.renderToBuffer(poseStack, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
		poseStack.popPose();
		super.render(entityIn, entityYaw, partialTicks, poseStack, bufferIn, packedLightIn);
	}

	@Override
	public ResourceLocation getTextureLocation(MoonlightDashEntity entity) {
		return texture;
	}
}
