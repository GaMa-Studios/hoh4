// Made with Blockbench 4.12.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelbladerush<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "bladerush"), "main");
	private final ModelPart up;
	private final ModelPart down;

	public Modelbladerush(ModelPart root) {
		this.up = root.getChild("up");
		this.down = root.getChild("down");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition up = partdefinition.addOrReplaceChild("up", CubeListBuilder.create().texOffs(-4, 12).addBox(
				-8.0F, 0.0F, -4.0F, 16.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 23.5F, 2.0F));

		PartDefinition down = partdefinition.addOrReplaceChild("down", CubeListBuilder.create().texOffs(-6, 0).addBox(
				-8.0F, 0.0F, -6.0F, 16.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 2.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		up.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		down.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
	}
}