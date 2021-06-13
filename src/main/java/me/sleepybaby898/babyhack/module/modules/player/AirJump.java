package me.sleepybaby898.babyhack.module.modules.player;

import org.lwjgl.input.Keyboard;

import me.sleepybaby898.babyhack.module.Category;
import me.sleepybaby898.babyhack.module.Module;
import me.sleepybaby898.babyhack.setting.settings.SettingBoolean;
import net.minecraft.client.Minecraft;
import net.minecraft.network.play.client.CPacketPlayer;

public class AirJump extends Module {
	
	SettingBoolean packet;
	private Minecraft mc = Minecraft.getMinecraft();
	
	public AirJump() {
		super("airjump", Keyboard.KEY_NONE, Category.PLAYER);
		packet = this.register("Packet", true);
	}
	
	@Override
	public void update() {
		if (Minecraft.getMinecraft().player == null) {
			return;
		}
		
		mc.player.onGround = true;
		
		if(packet.getValue()) {
			mc.player.connection.sendPacket(new CPacketPlayer.Position(mc.player.posX, mc.player.posY + 0.41999998688698D, mc.player.posZ, true));
            mc.player.connection.sendPacket(new CPacketPlayer.Position(mc.player.posX, mc.player.posY + 0.7531999805211997D, mc.player.posZ, true));
            mc.player.connection.sendPacket(new CPacketPlayer.Position(mc.player.posX, mc.player.posY + 1.00133597911214D, mc.player.posZ, true));
            mc.player.connection.sendPacket(new CPacketPlayer.Position(mc.player.posX, mc.player.posY + 1.16610926093821D, mc.player.posZ, true));
		}
	}
	
	
	
}
