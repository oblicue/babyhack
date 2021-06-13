package me.sleepybaby898.babyhack.module.modules.movement;

import org.lwjgl.input.Keyboard;

import me.sleepybaby898.babyhack.module.Category;
import me.sleepybaby898.babyhack.module.Module;
import net.minecraft.client.Minecraft;
import net.minecraft.network.play.client.CPacketPlayer;

public class NoFall extends Module {
	Minecraft mc = Minecraft.getMinecraft();
	public NoFall() {
		super("NoFall",Keyboard.KEY_Y,Category.MOVEMENT);
	}
	
	public void update() {
		if(mc.player.fallDistance >= 2) {
			mc.getConnection().sendPacket(new CPacketPlayer(true));
		} else {
			return;
		}
	}
	
	public void onDisable() {
		return;
	}
	
	public void onEnable() {
		mc.player.onGround = true;
		return;
	}
}
