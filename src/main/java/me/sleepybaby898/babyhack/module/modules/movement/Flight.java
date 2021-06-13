package me.sleepybaby898.babyhack.module.modules.movement;

import org.lwjgl.input.Keyboard;

import me.sleepybaby898.babyhack.module.Category;
import me.sleepybaby898.babyhack.module.Module;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;

public class Flight extends Module {
	Minecraft mc = Minecraft.getMinecraft();
	public Flight() {
		super("Fly",Keyboard.KEY_G,Category.MOVEMENT);
	}
	
	public void update() {
		EntityPlayerSP player = mc.player;
		
		player.capabilities.isFlying = false;
		player.motionX = 0;
		player.motionY = 0;
		player.motionZ = 0;
		player.jumpMovementFactor = 0.5f;
		
		if(mc.gameSettings.keyBindJump.isKeyDown())
				player.motionY += 0.5f;
		if(mc.gameSettings.keyBindSneak.isKeyDown())
			player.motionY -= 0.5f;
	}
	
}
