package client.cyber.mods;

import net.minecraft.client.Minecraft;

public class FPS {
    public Minecraft mc = Minecraft.getMinecraft();
    public void draw(){
        mc.fontRendererObj.drawString("FPS: " + Minecraft.getDebugFPS(), 4, 4, client.cyber.Client.RainbowEffect(0, 0));
    }
}
