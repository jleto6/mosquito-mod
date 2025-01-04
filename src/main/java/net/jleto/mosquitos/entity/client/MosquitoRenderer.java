package net.jleto.mosquitos.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.jleto.mosquitos.Mosquitos;
import net.jleto.mosquitos.entity.custom.MosquitoEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class MosquitoRenderer extends MobRenderer<MosquitoEntity, MosquitoModel<MosquitoEntity>> {
    public MosquitoRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new MosquitoModel<>(pContext.bakeLayer(ModModelLayers.MOSQUITO_LAYER)), .5f);
    }

    @Override
    public ResourceLocation getTextureLocation(MosquitoEntity pEntity) {
        return new ResourceLocation(Mosquitos.MODID, "textures/entity/mosquito.png");
    }

    @Override
    public void render(MosquitoEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()) {
            pMatrixStack.scale(0.5f, 0.5f, 0.5f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
