package client.cyber;

import client.cyber.mods.FPS;
import client.cyber.util.SessionChanger;
import org.lwjgl.opengl.Display;

public class Cyber {
    public static FPS fps = new FPS();
    public static String name = "CYBER",  version = "v0.1.12.10"; // old version v0.1.11.25
    public static boolean developer = false;
    public static boolean vip = false;

    public static void startup(){
        SessionChanger.getInstance().setUserOffline("Sytroxitz");

        System.out.println("Starting " + name + " - " + version);
        Display.setTitle(name + " " + version);
    }
}
