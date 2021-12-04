package client.cyber;

import client.cyber.mods.FPS;
import org.lwjgl.opengl.Display;

public class Cyber {
    public static FPS fps = new FPS();
    public static String name = "CYBER",  version = "v0.1.11.25";

    public static void startup(){
        System.out.println("Starting " + name + " - " + version);
        Display.setTitle(name + " " + version);
    }
}
