package me.sleepybaby898.babyhack.module.modules.movement;


import org.lwjgl.input.Keyboard;

import me.sleepybaby898.babyhack.module.Category;
import me.sleepybaby898.babyhack.module.Module;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;

public class BunnyHop extends Module {
	
	Minecraft mc = Minecraft.getMinecraft();
	
	
	public BunnyHop() {
		super("BHop",Keyboard.KEY_B,Category.MOVEMENT);
	}
	
	public void update() {
		EntityPlayerSP player = mc.player;
		if(!player.onGround || player.isSneaking()
			|| player.isInsideOfMaterial(Material.WATER))
			return;
		player.jump();
	}
	
}
