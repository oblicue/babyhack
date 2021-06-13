package me.sleepybaby898.babyhack.module.modules.client;

import org.lwjgl.input.Keyboard;

import me.sleepybaby898.babyhack.BabyHack;
import me.sleepybaby898.babyhack.module.Category;
import me.sleepybaby898.babyhack.module.Module;
import net.minecraft.client.Minecraft;

public class ClickGUIModule extends Module {
	public ClickGUIModule() {
		super("ClickGui",Keyboard.KEY_RSHIFT,Category.CLIENT);
	}
	
	public void onEnable() {
		Minecraft.getMinecraft().displayGuiScreen(BabyHack.instance.clickGUI);
		toggle();
	}
}
