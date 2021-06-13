package me.sleepybaby898.babyhack.module.modules.client;

import java.security.SecureRandom;
import java.util.Random;

import org.lwjgl.input.Keyboard;

import me.sleepybaby898.babyhack.module.Category;
import me.sleepybaby898.babyhack.module.Module;
import net.minecraft.client.Minecraft;

public class Excuse extends Module {
	
	private Minecraft mc = Minecraft.getMinecraft();
	
	public Excuse() {
		super("excuse", Keyboard.KEY_NONE, Category.CLIENT);
	}
	
	public void onEnable() {
		String[] excuses = {"my ca didnt work", "im not using a hacked client", "my internet cut out", "my cat ran across my keyboard", "i started yesterday", "i got hacked midway through", "my grandma just died", "im on mobile", "my brother was playing", "my holetp didnt work", "my autototem bugged out", "sorry my mum came into the room", "im testing a custom client sorry", "i had to go afk", "im not using ca", "my surround broke", "i forgot to turn on my ca"};
		
		Random rand = new SecureRandom();
		
		String message = excuses[rand.nextInt(excuses.length)];
		
		mc.player.sendChatMessage(message);
		this.toggled = false;
	}
}
