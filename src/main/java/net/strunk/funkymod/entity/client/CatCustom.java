package net.strunk.funkymod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;

public class CatCustom<T extends Entity> extends HierarchicalModel<T> {
	private final ModelPart cat;

	public CatCustom(ModelPart root) {
		this.cat = root.getChild("cat");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition cat = partdefinition.addOrReplaceChild("cat", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition tail2 = cat.addOrReplaceChild("tail2", CubeListBuilder.create().texOffs(4, 15).addBox(-0.5F, 0.0F, -4.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.5F, 16.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition tail = cat.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 15).addBox(-0.5F, 0.0F, -4.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.5F, 8.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition front_right_leg = cat.addOrReplaceChild("front_right_leg", CubeListBuilder.create().texOffs(40, 0).addBox(-4.0F, 0.0F, 0.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.1F, -9.9F, -5.0F));

		PartDefinition back_left_leg = cat.addOrReplaceChild("back_left_leg", CubeListBuilder.create().texOffs(8, 13).addBox(2.0F, 0.0F, 1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.1F, -6.0F, 5.0F));

		PartDefinition back_right_leg = cat.addOrReplaceChild("back_right_leg", CubeListBuilder.create().texOffs(8, 13).addBox(-4.0F, 0.0F, 1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.1F, -6.0F, 5.0F));

		PartDefinition front_left_leg = cat.addOrReplaceChild("front_left_leg", CubeListBuilder.create().texOffs(40, 0).addBox(2.0F, 0.0F, 0.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.1F, -9.9F, -5.0F));

		PartDefinition body = cat.addOrReplaceChild("body", CubeListBuilder.create().texOffs(20, 0).addBox(-2.0F, 3.0F, -12.0F, 4.0F, 16.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.0F, -10.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition head = cat.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, 2.0F, -3.0F, 5.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 24).addBox(-1.5F, 3.98F, -4.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 10).addBox(-2.0F, 1.0F, 0.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(6, 10).addBox(1.0F, 1.0F, 0.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -9.0F, -9.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		cat.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return cat;
	}
}