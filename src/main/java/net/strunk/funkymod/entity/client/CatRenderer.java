package net.strunk.funkymod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.strunk.funkymod.FunkyMod;
import net.strunk.funkymod.entity.custom.CatEntity;

public class CatRenderer extends MobRenderer<CatEntity, CatCustom<CatEntity>> {
    public CatRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new CatCustom<>(pContext.bakeLayer(FunkyModelLayers.CAT_CUSTOM_LAYER)), 2f);
    }

    @Override
    public ResourceLocation getTextureLocation(CatEntity pEntity) {
        return new ResourceLocation(FunkyMod.MOD_ID, "textures/entity/cat_custom.png");
    }
}
