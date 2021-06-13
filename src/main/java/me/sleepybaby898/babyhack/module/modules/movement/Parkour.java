package me.sleepybaby898.babyhack.module.modules.movement;


import org.lwjgl.input.Keyboard;

import me.sleepybaby898.babyhack.module.Category;
import me.sleepybaby898.babyhack.module.Module;
import net.minecraft.client.Minecraft;

public class Parkour extends Module {
	
	private Minecraft mc = Minecraft.getMinecraft();
	
	public Parkour() {
		super("parkour", Keyboard.KEY_NONE, Category.MOVEMENT);
	}
	
	@Override
	public void update() {
		if(mc.player.onGround && !mc.player.isSneaking() && !mc.gameSettings.keyBindSneak.isPressed() && !mc.gameSettings.keyBindJump.isPressed() && mc.world.getCollisionBoxes(mc.player, mc.player.getEntityBoundingBox().offset(0.0, -0.5, 0.0).expand(-0.001, 0.0, -0.001)).isEmpty()) {
            mc.player.jump();
		}
	}
	
}
 