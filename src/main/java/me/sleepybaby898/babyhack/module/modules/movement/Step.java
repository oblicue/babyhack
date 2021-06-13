package me.sleepybaby898.babyhack.module.modules.movement;

import org.lwjgl.input.Keyboard;

import me.sleepybaby898.babyhack.module.Category;
import me.sleepybaby898.babyhack.module.Module;
import me.sleepybaby898.babyhack.setting.settings.SettingDouble;
import net.minecraft.client.Minecraft;

public class Step extends Module {
	Minecraft mc = Minecraft.getMinecraft();
	
	SettingDouble height;
	
	public Step() {
		super("Step",Keyboard.KEY_I,Category.MOVEMENT);
		height = this.register("Height", 2.5, 0.5, 2.5);
	}
	
	public void update() {
		mc.player.stepHeight = (float) height.getValue();
	}
	
	public void onDisable() {
		mc.player.stepHeight = 0.5f;
	}
}
