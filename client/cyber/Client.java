package client.cyber;

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
}
