package net.jleto.mosquitos.entity.client;// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.jleto.mosquitos.entity.animations.ModAnimationDefinitions;
import net.jleto.mosquitos.entity.custom.MosquitoEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class MosquitoModel<T extends Entity> extends HierarchicalModel<T> {

	private final ModelPart root;


	private final ModelPart body;
	private final ModelPart left_wing;
	private final ModelPart right_wing;
	private final ModelPart legs;
	private final ModelPart torso;
	private final ModelPart Head;
	private final ModelPart back;
	private final ModelPart bb_main;



	public MosquitoModel(ModelPart pRoot) {


		this.root = pRoot;

		this.body = root.getChild("body");
		this.left_wing = root.getChild("left_wing");
		this.right_wing = root.getChild("right_wing");
		this.legs = root.getChild("legs");
		this.torso = root.getChild("torso");
		this.Head = root.getChild("Head");
		this.back = root.getChild("back");
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition left_wing = partdefinition.addOrReplaceChild("left_wing", CubeListBuilder.create(), PartPose.offset(1.5F, 15.0F, -3.0F));

		PartDefinition left_wing_r1 = left_wing.addOrReplaceChild("left_wing_r1", CubeListBuilder.create().texOffs(0, 18).mirror().addBox(-1.0F, -8.9F, -6.0F, 9.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.5F, 9.0F, 3.0F, 0.0F, -0.5672F, 0.0F));

		PartDefinition right_wing = partdefinition.addOrReplaceChild("right_wing", CubeListBuilder.create(), PartPose.offset(-1.5F, 15.0F, -3.0F));

		PartDefinition right_wing_r1 = right_wing.addOrReplaceChild("right_wing_r1", CubeListBuilder.create().texOffs(0, 18).addBox(-8.0F, -8.9F, -6.0F, 9.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 9.0F, 3.0F, 0.0F, 0.5672F, 0.0F));

		PartDefinition legs = partdefinition.addOrReplaceChild("legs", CubeListBuilder.create().texOffs(28, 1).addBox(-4.0F, -4.0F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(28, 1).addBox(-5.0F, -3.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(28, 1).addBox(-5.0F, -3.0F, 2.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(28, 1).addBox(-5.0F, -3.0F, 4.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(28, 1).addBox(1.0F, -3.0F, 4.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(28, 1).addBox(1.0F, -3.0F, 2.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(28, 1).addBox(1.0F, -3.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(27, 5).addBox(-1.0F, -4.0F, 4.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(27, 3).addBox(-1.0F, -4.0F, 2.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(28, 1).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(27, 3).addBox(-4.0F, -4.0F, 2.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(27, 5).addBox(-4.0F, -4.0F, 4.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, 22.0F, -3.8F));

		PartDefinition torso = partdefinition.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(6, 6).addBox(-1.5F, -4.0F, -4.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 19.0F, 0.0F));

		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -8.0F, -6.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition back = partdefinition.addOrReplaceChild("back", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition torso_r1 = back.addOrReplaceChild("torso_r1", CubeListBuilder.create().texOffs(4, 4).addBox(-1.5F, -8.0F, -1.0F, 3.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition stinger_r1 = bb_main.addOrReplaceChild("stinger_r1", CubeListBuilder.create().texOffs(23, 6).addBox(0.0F, -9.0F, -6.0F, 0.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}



	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);

		this.animate(((MosquitoEntity) entity).idleAnimationState, ModAnimationDefinitions.FLYING, ageInTicks, 1f);
		this.animate(((MosquitoEntity) entity).attackAnimationState, ModAnimationDefinitions.FLYING, ageInTicks, 1f);
		this.animateWalk(ModAnimationDefinitions.FLYING, limbSwing, limbSwingAmount, 2f, 2.5f);

	}


	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_wing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_wing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		legs.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		torso.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		back.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return this.root;
	}


}
