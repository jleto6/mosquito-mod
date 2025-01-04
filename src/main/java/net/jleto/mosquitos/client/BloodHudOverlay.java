package net.jleto.mosquitos.client;

import com.mojang.blaze3d.systems.RenderSystem;
import net.jleto.mosquitos.Mosquitos;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;

public class BloodHudOverlay {

    /*private static final ResourceLocation FILLED_BLOOD = new ResourceLocation(Mosquitos.MODID,
            "textures/blood/filled_blood.png");
    private static final ResourceLocation EMPTY_BLOOD = new ResourceLocation(Mosquitos.MODID,
            "textures/blood/empty_blood.png");

    public static final IGuiOverlay HUD_BLOOD = ((gui, guiGraphics, partialTick, width, height) -> {
        int x = width / 2;
        int y = height;

        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, EMPTY_BLOOD);
        for(int i = 0; i < 10; i++) {
            guiGraphics.blit(EMPTY_BLOOD,x - 2 + (i * 9), y - 54,0,0,12,12,
                    16,16);
        }

        RenderSystem.setShaderTexture(0, FILLED_BLOOD);
        for(int i = 0; i < 10; i++) {
            if(ClientBloodData.getPlayerBlood() > i) {
                guiGraphics.blit(FILLED_BLOOD,x - 2 + (i * 9),y - 54,0,0,12,12,
                        16,16);
            } else {
                break;
            }
        }
    });
*/
}

