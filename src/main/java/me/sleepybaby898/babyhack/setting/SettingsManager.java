package me.sleepybaby898.babyhack.setting;

import java.util.ArrayList;

import me.sleepybaby898.babyhack.module.Module;

public class SettingsManager {
	public ArrayList<Setting> settings;

	public SettingsManager() {
		settings = new ArrayList<>();
	}

	public ArrayList<Setting> getSettingsInMod(Module mod) {
		ArrayList<Setting> sets = new ArrayList<>();
		for(Setting s : settings) {
			if(s.getMod() == mod) {
				sets.add(s);
			}
		}
		return sets;
	}

	public ArrayList<Setting> getSettings() {
		return settings;
	}

	public void setSettings(ArrayList<Setting> settings) {
		this.settings = settings;
	}
	
}
