package me.sleepybaby898.babyhack.setting;

import me.sleepybaby898.babyhack.module.Module;

public class Setting {
	public String name;
	public Module mod;
	public Type type;
	
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Module getMod() {
		return mod;
	}
	public void setMod(Module mod) {
		this.mod = mod;
	}
	
	public enum Type {
		BOOLEAN,
		DOUBLE,
		INTEGER,
		MODE;
	}
}


