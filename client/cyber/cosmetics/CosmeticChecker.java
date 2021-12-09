package client.cyber.cosmetics;

import client.cyber.Cyber;
import net.minecraft.client.entity.AbstractClientPlayer;

public class CosmeticChecker {
    public static boolean isDeveloper(AbstractClientPlayer player) {
        if(player.getName().equals("Sytroxitz")) {
            Cyber.developer = true;
            return true;
        }
        else return false;
    }
    public static boolean isVIP(AbstractClientPlayer player) {
        if(player.getName().equals("PhilTheBoss07")) {
            Cyber.vip = true;
            return true;
        }
        else return false;
    }
}
