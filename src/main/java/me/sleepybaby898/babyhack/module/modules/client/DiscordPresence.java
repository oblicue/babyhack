package me.sleepybaby898.babyhack.module.modules.client;

import org.lwjgl.input.Keyboard;

import me.sleepybaby898.babyhack.module.Category;
import me.sleepybaby898.babyhack.module.DiscordRP;
import me.sleepybaby898.babyhack.module.Module;

public class DiscordPresence extends Module {

	public DiscordPresence() {
		super("discordRpc", Keyboard.KEY_NONE, Category.CLIENT);
	}
	
	public void onEnable() {
		DiscordRP.startRPC();
	}
	
	public void onDisable() {
		DiscordRP.stopRPC();
	}
	
}
