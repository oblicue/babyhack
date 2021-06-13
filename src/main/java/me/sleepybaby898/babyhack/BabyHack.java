package me.sleepybaby898.babyhack;

import org.lwjgl.opengl.Display;

import me.sleepybaby898.babyhack.gui.ClickGUI;
import me.sleepybaby898.babyhack.module.ModuleManager;
import me.sleepybaby898.babyhack.setting.SettingsManager;
import me.zero.alpine.EventManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION)
public class BabyHack {
	
	@Instance
	public static BabyHack instance = new BabyHack();
	public static final EventManager EVENT_BUS = new EventManager();
	
	public ModuleManager moduleManager;
	public SettingsManager settingsManager;
	
	public ClickGUI clickGUI;
	
	@EventHandler
	public void init(FMLPreInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(instance);
		settingsManager = new SettingsManager();
		moduleManager = new ModuleManager();
		
		clickGUI = new ClickGUI();
		Display.setTitle("babyhack " + Reference.VERSION);
	}
}
