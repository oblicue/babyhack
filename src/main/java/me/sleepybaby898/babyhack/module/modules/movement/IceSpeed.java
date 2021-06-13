package me.sleepybaby898.babyhack.module.modules.movement;

import org.lwjgl.input.Keyboard;

import me.sleepybaby898.babyhack.module.Category;
import me.sleepybaby898.babyhack.module.Module;
import me.sleepybaby898.babyhack.setting.settings.SettingDouble;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;

public class IceSpeed extends Module {
	
	SettingDouble speed;
	
	public IceSpeed() {
		super("icespeed", Keyboard.KEY_NONE, Category.MOVEMENT);
		speed = this.register("Speed", 1.1D, 0.98D, 1.5D);
	}
	
	@SuppressWarnings("deprecation")
	public void update() {
		if(Minecraft.getMinecraft().player == null) {
			return;
		}
		
		Blocks.ICE.slipperiness = (float) speed.getValue();
		Blocks.PACKED_ICE.slipperiness = (float) speed.getValue();
        Blocks.FROSTED_ICE.slipperiness = (float) speed.getValue();
	}
	
	@SuppressWarnings("deprecation")
	public void onDisable() {
		Blocks.ICE.slipperiness = 0.98F;
		Blocks.PACKED_ICE.slipperiness = 0.98F;
		Blocks.FROSTED_ICE.slipperiness = 0.98F;
	}
	
	
}
