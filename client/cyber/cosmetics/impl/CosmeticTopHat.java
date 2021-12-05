package client.cyber.cosmetics.impl;

import client.cyber.cosmetics.CosmeticBase;
import client.cyber.cosmetics.CosmeticController;
import client.cyber.cosmetics.CosmeticModelBase;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class CosmeticTopHat extends CosmeticBase {
    private final ModelTopHat modelTopHat;
    private static final ResourceLocation TEXTURE = new ResourceLocation("cyber/hat.png");

    public CosmeticTopHat(RenderPlayer renderPlayer) {
        super(renderPlayer);
        modelTopHat = new ModelTopHat(renderPlayer);
    }

    @Override
    public void render(AbstractClientPlayer player, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float headYaw, float headPitch, float scale) {
        if(CosmeticController.shouldRenderTopHat(player)){
            GlStateManager.pushMatrix();
            playerRenderer.bindTexture(TEXTURE);
            if(player.isSneaking()){
                GL11.glTranslated(0, 0.225D, 0);
            }
            float[] color = CosmeticController.getTopHatColor(player);
            GL11.glColor3f(color[0], color[1], color[2]);
            modelTopHat.render(player, limbSwing, limbSwingAmount, partialTicks, ageInTicks, headYaw, headPitch, scale);
            GL11.glColor3f(1, 1, 1);
            GL11.glPopMatrix();
        }
    }

    private class ModelTopHat extends CosmeticModelBase {
        private ModelRenderer rim;
        private ModelRenderer pointy;
        public ModelTopHat(RenderPlayer player) {
            super(player);
            rim = new ModelRenderer(playerModel, 0, 0);
            rim.addBox(-5.5F, -9F, -5.5F, 11, 2, 11);
            pointy = new ModelRenderer(playerModel, 0, 13);
            pointy.addBox(-3.5F, -17F, -3.5F, 7, 8, 7);
        }

        public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float headYaw, float headPitch, float scale) {
            rim.rotateAngleX = playerModel.bipedHead.rotateAngleX;
            rim.rotateAngleY = playerModel.bipedHead.rotateAngleY;
            rim.rotationPointX = 0.0F;
            rim.rotationPointY = 0.0F;
            rim.render(scale);

            pointy.rotateAngleX = playerModel.bipedHead.rotateAngleX;
            pointy.rotateAngleY = playerModel.bipedHead.rotateAngleY;
            pointy.rotationPointX = 0.0F;
            pointy.rotationPointY = 0.0F;
            pointy.render(scale);
        }
    }
}
