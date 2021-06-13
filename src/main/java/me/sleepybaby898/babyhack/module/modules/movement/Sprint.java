package me.sleepybaby898.babyhack.module.modules.movement;

import me.sleepybaby898.babyhack.module.Category;
import me.sleepybaby898.babyhack.module.Module;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;

public class Sprint extends Module {
	public Sprint() {
		super("Sprint",0,Category.MOVEMENT);
	}
	
	public void update() {
		KeyBinding.setKeyBindState(Minecraft.getMinecraft().gameSettings.keyBindSprint.getKeyCode(), true);
	}
	
	public void onDisable() {
		KeyBinding.setKeyBindState(Minecraft.getMinecraft().gameSettings.keyBindSprint.getKeyCode(), false);
	}
}
