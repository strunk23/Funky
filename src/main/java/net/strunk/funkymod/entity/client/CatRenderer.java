package net.strunk.funkymod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.strunk.funkymod.FunkyMod;
import net.strunk.funkymod.entity.custom.CatEntity;
import org.jetbrains.annotations.NotNull;

public class CatRenderer extends MobRenderer<CatEntity, CatCustom<CatEntity>> {
    public CatRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new CatCustom<>(pContext.bakeLayer(FunkyModelLayers.CAT_CUSTOM_LAYER)), 0.4f);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull CatEntity pEntity) {
        return new ResourceLocation(FunkyMod.MOD_ID, "textures/entity/cat_custom.png");
    }

    @Override
    protected void scale(@NotNull CatEntity pLivingEntity, PoseStack pMatrixStack, float pPartialTickTime) {
        float scale = 0.9F;
        pMatrixStack.scale(scale, scale, scale);
        super.scale(pLivingEntity, pMatrixStack, pPartialTickTime);
    }
}
