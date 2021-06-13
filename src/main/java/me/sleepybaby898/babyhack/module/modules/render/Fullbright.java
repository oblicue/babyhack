package me.sleepybaby898.babyhack.module.modules.render;

import me.sleepybaby898.babyhack.module.Category;
import me.sleepybaby898.babyhack.module.Module;
import net.minecraft.client.Minecraft;

public class Fullbright extends Module {
	public Fullbright() {
		super("FullBright",0,Category.RENDER);
	}
	
	public void update() {
		Minecraft.getMinecraft().gameSettings.gammaSetting = 100;
	}
	
	public void onDisable() {
		Minecraft.getMinecraft().gameSettings.gammaSetting = 1;
	}
}
