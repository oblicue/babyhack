package me.sleepybaby898.babyhack.module.modules.player;

import org.lwjgl.input.Keyboard;

import me.sleepybaby898.babyhack.module.Category;
import me.sleepybaby898.babyhack.module.Module;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;

public class Jesus extends Module {
	Minecraft mc = Minecraft.getMinecraft();
	int tickTimer = 2;
	
	public Jesus() {
		super("Jesus",Keyboard.KEY_J,Category.PLAYER);
	}
	
	public void update() {
			// check if sneaking
			if(GameSettings.isKeyDown(mc.gameSettings.keyBindSneak))
				return;
			
			// move up in water
			if(mc.player != null) {
				if(mc.player.isInWater())
				{
					mc.player.motionY = 0.11;
					tickTimer = 0;
					return;
				}
				
				// simulate jumping out of water
				if(tickTimer == 0) {
					mc.player.motionY = 0.30;
				}
				else if(tickTimer == 1) {
					mc.player.motionY = 0;
				}
					
				tickTimer ++;
			}
			
	}
	
	public void onDisable() {
		mc.player.stepHeight = 0.5f;
	}
}
