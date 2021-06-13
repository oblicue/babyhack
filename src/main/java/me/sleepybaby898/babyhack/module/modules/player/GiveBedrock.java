package me.sleepybaby898.babyhack.module.modules.player;

import org.lwjgl.input.Keyboard;

import me.sleepybaby898.babyhack.module.Category;
import me.sleepybaby898.babyhack.module.Module;
import net.minecraft.client.Minecraft;

public class GiveBedrock extends Module {
	public GiveBedrock() {
		super("givebedrock", Keyboard.KEY_NONE, Category.CLIENT);
	}
	
	public void onEnable() {
		if (Minecraft.getMinecraft().player != null) {
			Minecraft.getMinecraft().player.sendChatMessage("everyone on this server is so bad come to X:" + Math.round(Minecraft.getMinecraft().player.posX) + " Y: " + Math.round(Minecraft.getMinecraft().player.posY) + " Z: " + Math.round(Minecraft.getMinecraft().player.posZ) + " ill crystalpvp you ez");
		}
		this.setToggled(false);
	}
}
