package me.sleepybaby898.babyhack.module.modules.movement;

import org.lwjgl.input.Keyboard;

import me.sleepybaby898.babyhack.module.Category;
import me.sleepybaby898.babyhack.module.Module;
import me.sleepybaby898.babyhack.setting.settings.SettingBoolean;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.network.play.client.CPacketPlayer;

public class Flight extends Module {
	Minecraft mc = Minecraft.getMinecraft();
	SettingBoolean packet;
	
	public Flight() {
		super("Fly",Keyboard.KEY_G,Category.MOVEMENT);
		packet = this.register("Packet", true);	
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
		
		mc.player.onGround = true;
		
		if(packet.getValue()) {
			mc.player.connection.sendPacket(new CPacketPlayer.Position(mc.player.posX, mc.player.posY + 0.41999998688698D, mc.player.posZ, true));
            mc.player.connection.sendPacket(new CPacketPlayer.Position(mc.player.posX, mc.player.posY + 0.7531999805211997D, mc.player.posZ, true));
            mc.player.connection.sendPacket(new CPacketPlayer.Position(mc.player.posX, mc.player.posY + 1.00133597911214D, mc.player.posZ, true));
            mc.player.connection.sendPacket(new CPacketPlayer.Position(mc.player.posX, mc.player.posY + 1.16610926093821D, mc.player.posZ, true));
		}
	}
	
}
