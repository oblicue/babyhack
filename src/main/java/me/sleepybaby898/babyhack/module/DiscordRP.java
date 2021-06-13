package me.sleepybaby898.babyhack.module;

import club.minnced.discord.rpc.DiscordEventHandlers;
import club.minnced.discord.rpc.DiscordRPC;
import club.minnced.discord.rpc.DiscordRichPresence;
import me.sleepybaby898.babyhack.Reference;
import net.minecraft.client.Minecraft;

public class DiscordRP {
	
	public static String discordID = "851365200103997451";
	private static DiscordRichPresence discordRichPresence = new DiscordRichPresence();
	private static DiscordRPC discordRPC = DiscordRPC.INSTANCE;
			
	public static void startRPC() {
		DiscordEventHandlers eventHandlers = new DiscordEventHandlers();
        eventHandlers.disconnected = ((var1, var2) -> System.out.println("Discord RPC disconnected, var1: " + var1 + ", var2: " + var2));
        discordRPC.Discord_Initialize(discordID, eventHandlers, true, null);
        
        if(Minecraft.getMinecraft().player != null && Minecraft.getMinecraft().world != null) {
        	discordRichPresence.details = Minecraft.getMinecraft().player.getName();
        }else discordRichPresence.details = "in da menus";
        
        discordRichPresence.startTimestamp = System.currentTimeMillis() / 1000L;
        discordRichPresence.largeImageKey = "logo";
        discordRichPresence.largeImageText = "babyhack on top";
        discordRichPresence.state = "babyhack on top!! (" + Reference.VERSION + ")";
        discordRPC.Discord_UpdatePresence(discordRichPresence);
	}
	
	 public static void stopRPC() {
	        discordRPC.Discord_Shutdown();
	        discordRPC.Discord_ClearPresence();
	    }
	
}
