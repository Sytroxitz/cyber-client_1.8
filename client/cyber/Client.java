package client.cyber;

import java.awt.*;

public class Client {

    public static final Client INSTANCE = new Client();
    public static final Client getInstance(){
        return INSTANCE;
    }
    private DiscordRP discordRP = new DiscordRP();

    public void init(){
        discordRP.start();
    }

    public void shutdown(){
        discordRP.shutdown();
    }

    public DiscordRP getDiscordRP(){
        return discordRP;
    }

    public static int RainbowEffect(int i, float f) {
        return Color.HSBtoRGB((float)(System.currentTimeMillis() % 20000L) / 1000.0F, 0.8F, 0.8F);
    }

}
