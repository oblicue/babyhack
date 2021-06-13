package me.sleepybaby898.babyhack.module.modules.player;

import me.sleepybaby898.babyhack.event.events.PacketEvent;
import me.sleepybaby898.babyhack.module.Category;
import me.sleepybaby898.babyhack.module.Module;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.client.Minecraft;
import net.minecraft.network.play.server.SPacketEntityVelocity;
import net.minecraft.network.play.server.SPacketExplosion;

public class Velocity extends Module {
	public Velocity() {
		super("Velocity",0,Category.PLAYER);
	}
	
	@EventHandler
	private final Listener<PacketEvent.Receive> recieveListener = new Listener<>(event -> {
		if (event.getPacket() instanceof SPacketEntityVelocity) {
			if (((SPacketEntityVelocity) event.getPacket()).getEntityID() == Minecraft.getMinecraft().player.getEntityId()) {
				event.cancel();
				System.out.println("cancelling packet");
			}
		}
		if(event.getPacket() instanceof SPacketExplosion) {
			event.cancel();
			System.out.println("cancelling explosion packet");
		}

	});

}
