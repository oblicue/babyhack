package me.sleepybaby898.babyhack.event.events;

import me.sleepybaby898.babyhack.event.Event;
import net.minecraft.network.Packet;

@SuppressWarnings("rawtypes")
public class NetworkPacketEvent extends Event {
 
	public Packet m_Packet;
 
 
	public NetworkPacketEvent(Packet p_Packet) {
	    super();
	    m_Packet = p_Packet;
	}
 
	public Packet GetPacket() {
	   return m_Packet;
	}
 
	public Packet getPacket() {
	   return m_Packet;
	}
}