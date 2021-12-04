package client.cyber;

import net.arikia.dev.drpc.DiscordEventHandlers;
import net.arikia.dev.drpc.DiscordRPC;
import net.arikia.dev.drpc.DiscordRichPresence;
import net.arikia.dev.drpc.DiscordUser;
import net.arikia.dev.drpc.callbacks.ReadyCallback;

public class DiscordRP {

    private String dev_name;
    private String vip_name;
    private boolean developer = false;
    private boolean vip = false;
    private boolean running = true;
    private long created = 0;

    public void start() {
        this.created = System.currentTimeMillis();
        DiscordEventHandlers handlers = new DiscordEventHandlers.Builder().setReadyEventHandler(new ReadyCallback() {
            @Override
            public void apply(DiscordUser discordUser) {
                System.out.println("Welcome " + discordUser.username + "#" + discordUser.discriminator + ".");
                if(discordUser.userId.equals("261103679732580352")) {
                    developer = true;
                    dev_name = "$lxy Txz";
                    update("Minecraft 1.8.8", "Starting ...");
                }else if(discordUser.userId.equals("319446206185209856") || discordUser.userId.equals("888872794614534144") || discordUser.userId.equals("469870741165441034") || discordUser.userId.equals("344134846475403267")) {
                    vip = true;
                    vip_name = discordUser.username;
                    update("Minecraft 1.8.8", "Starting ...");
                }else if(!discordUser.userId.equals("261103679732580352")) {
                    update("Minecraft 1.8.8", "Starting ...");
                }
            }
        }).build();
        DiscordRPC.discordInitialize("792565950892474408", handlers, true);
        new Thread("DiscordRPC Callback"){
            @Override
            public void run() {
                while(running){
                    DiscordRPC.discordRunCallbacks();
                }
            }
        }.start();
    }

    public void shutdown(){
        running = false;
        DiscordRPC.discordShutdown();
    }

    public void update(String firstLine, String secondLine) {
        DiscordRichPresence.Builder b = new DiscordRichPresence.Builder(secondLine);
        b.setBigImage("large", Cyber.name + " " + Cyber.version);
        if(developer){
            b.setSmallImage("small", Cyber.name + " Developer: " + dev_name);
        }
        if(vip){
            b.setSmallImage("small", Cyber.name + " VIP: " + vip_name);
        }
        b.setDetails(firstLine);
        b.setStartTimestamps(created);
        DiscordRPC.discordUpdatePresence(b.build());
    }
}
