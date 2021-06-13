package me.sleepybaby898.babyhack.module;

import java.util.ArrayList;

import me.sleepybaby898.babyhack.BabyHack;
import me.sleepybaby898.babyhack.setting.settings.SettingBoolean;
import me.sleepybaby898.babyhack.setting.settings.SettingDouble;
import me.sleepybaby898.babyhack.setting.settings.SettingInteger;
import me.sleepybaby898.babyhack.setting.settings.SettingMode;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.MinecraftForge;

public class Module {

	public String name;
	public int key;
	public Category category;
	public boolean toggled;
	Minecraft mc = Minecraft.getMinecraft();
	
	public Module(String name,  int key, Category category) {
		this.name = name;
		this.key = key;
		this.category = category;
	}
	
	public void toggle() {
		toggled = !toggled;
		
		if(toggled) {
			enable();
			if(name != "ClickGui" && name != "excuse") {
				mc.player.sendMessage(new TextComponentString(TextFormatting.DARK_GRAY + "[babyhack] " + TextFormatting.WHITE + name + " was " + TextFormatting.GREEN + "enabled."));
			}
		}
		else {
			disable();
			if(name != "ClickGui") {
				mc.player.sendMessage(new TextComponentString(TextFormatting.DARK_GRAY + "[babyhack] " + TextFormatting.WHITE + name + " was " + TextFormatting.RED + "disabled."));
			}
			
		}
		
	}
	
	public void update() {}
	public void render() {}
	
	public void enable() {
		BabyHack.EVENT_BUS.subscribe(this);
		MinecraftForge.EVENT_BUS.register(this);
		onEnable();
	}
	public void disable() {
		BabyHack.EVENT_BUS.unsubscribe(this);
		MinecraftForge.EVENT_BUS.unregister(this);
		onDisable();
	}
	public void onEnable() {
	}
	
	public void onDisable() {
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public boolean isToggled() {
		return toggled;
	}

	public void setToggled(boolean toggled) {
		this.toggled = toggled;
	}
	
	public SettingBoolean register(String name, boolean value) {
		SettingBoolean set = new SettingBoolean(name,this,value);
		BabyHack.instance.settingsManager.settings.add(set);
		return set;
	}
	
	public SettingMode register(String name, ArrayList<String> values, String value) {
		SettingMode set = new SettingMode(name,this,values,value);
		BabyHack.instance.settingsManager.settings.add(set);
		return set;
	}
	
	public SettingInteger register(String name, int value, int min, int max) {
		SettingInteger set = new SettingInteger(name,this,value,min,max);
		BabyHack.instance.settingsManager.settings.add(set);
		return set;
	}
	
	public SettingDouble register(String name, double value, double min, double max) {
		SettingDouble set = new SettingDouble(name,this,value,min,max);
		BabyHack.instance.settingsManager.settings.add(set);
		return set;
	}
	
}
