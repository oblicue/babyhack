package me.sleepybaby898.babyhack.module.modules.client;

import org.lwjgl.input.Keyboard;

import me.sleepybaby898.babyhack.module.Category;
import me.sleepybaby898.babyhack.module.Module;
import java.awt.Desktop;
import java.net.URI;

public class Rickroll extends Module {
	public Rickroll() {
		super("rickroll", Keyboard.KEY_NONE, Category.CLIENT);
	}
	
	public void onEnable() {
		try {
			if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
			    Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=dQw4w9WgXcQ"));
			}
		} catch (Exception e) {e.printStackTrace();}
		this.setToggled(false);
	}
	
}
