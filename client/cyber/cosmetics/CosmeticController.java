package client.cyber.cosmetics;

import net.minecraft.client.entity.AbstractClientPlayer;

public class CosmeticController {

    // TODO: Redo with database!
    public static boolean shouldRenderTopHat(AbstractClientPlayer player){
        return true;
    }

    public static float[] getTopHatColor(AbstractClientPlayer player){
        // R G B -> Values 0 - 1 only
        return new float[] {1, 0, 1};
    }
}
