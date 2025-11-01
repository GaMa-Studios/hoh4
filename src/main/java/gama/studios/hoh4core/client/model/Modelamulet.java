package gama.studios.hoh4core.client.model;

import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.EntityModel;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

// Made with Blockbench 4.12.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelamulet<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("hoh_4_core", "modelamulet"), "main");
	public final ModelPart ancher;
	public final ModelPart bone;

	public Modelamulet(ModelPart root) {
		this.ancher = root.getChild("ancher");
		this.bone = this.ancher.getChild("bone");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition ancher = partdefinition.addOrReplaceChild("ancher",
				CubeListBuilder.create().texOffs(0, 3).addBox(-3.0F, 0.0F, -2.01F, 6.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(-4, 0).addBox(-3.0F, 0.0F, -2.01F, 6.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 9)
						.addBox(-1.0F, 4.0F, -2.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.25F)).texOffs(6, 9).addBox(-1.0F, 4.0F, -3.01F, 2.0F, 2.0F, 1.0F, new CubeDeformation(-0.25F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition bone = ancher.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, -2.0F));
		return LayerDefinition.create(meshdefinition, 16, 16);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		ancher.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
}
