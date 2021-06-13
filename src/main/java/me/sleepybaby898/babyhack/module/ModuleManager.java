package me.sleepybaby898.babyhack.module;

import java.util.ArrayList;

import org.lwjgl.input.Keyboard;

import me.sleepybaby898.babyhack.module.modules.client.ClickGUIModule;
import me.sleepybaby898.babyhack.module.modules.client.DiscordPresence;
import me.sleepybaby898.babyhack.module.modules.client.Excuse;
import me.sleepybaby898.babyhack.module.modules.client.Rickroll;
import me.sleepybaby898.babyhack.module.modules.combat.AutoArmour;
import me.sleepybaby898.babyhack.module.modules.combat.AutoTotem;
import me.sleepybaby898.babyhack.module.modules.combat.HoleTP;
import me.sleepybaby898.babyhack.module.modules.combat.KillAura;
import me.sleepybaby898.babyhack.module.modules.movement.BunnyHop;
import me.sleepybaby898.babyhack.module.modules.movement.Flight;
import me.sleepybaby898.babyhack.module.modules.movement.IceSpeed;
import me.sleepybaby898.babyhack.module.modules.movement.NoFall;
import me.sleepybaby898.babyhack.module.modules.movement.Parkour;
import me.sleepybaby898.babyhack.module.modules.movement.Sprint;
import me.sleepybaby898.babyhack.module.modules.movement.Step;
import me.sleepybaby898.babyhack.module.modules.player.AirJump;
import me.sleepybaby898.babyhack.module.modules.player.GiveBedrock;
import me.sleepybaby898.babyhack.module.modules.player.Jesus;
import me.sleepybaby898.babyhack.module.modules.player.Velocity;
import me.sleepybaby898.babyhack.module.modules.render.Fullbright;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;

public class ModuleManager {
	
	public ArrayList<Module> modules;
	
	public ModuleManager() {
		modules = new ArrayList<Module>();
		MinecraftForge.EVENT_BUS.register(this);
		init();
	}
	
	public void init() {
		modules.add(new Step());
		modules.add(new Jesus());
		modules.add(new NoFall());
		modules.add(new BunnyHop());
		modules.add(new Flight());
		modules.add(new Sprint());
		modules.add(new Fullbright());
		modules.add(new Velocity());
		modules.add(new ClickGUIModule());
		modules.add(new DiscordPresence());
		modules.add(new KillAura());
		modules.add(new AutoArmour());
		modules.add(new Rickroll());
		modules.add(new GiveBedrock());
		modules.add(new HoleTP());
		modules.add(new Parkour());
		modules.add(new AirJump());
		modules.add(new IceSpeed());
		modules.add(new Excuse());
		modules.add(new AutoTotem());
	}
	
	public ArrayList<Module> getModules() {
		return modules;
	}
	
	public Module getModule(String name)  {
		for(Module m : modules) {
			if(m.getName().equalsIgnoreCase(name)) {
				return m;
			}
		}
		return null;
	}
	
	public ArrayList<Module> getModsInCategory(Category cat) {
		ArrayList<Module> mods = new ArrayList<Module>();
		for(Module m : modules) {
			if(m.getCategory() == cat) {
				mods.add(m);
			}
		}
		return mods;
	}
	
	@SubscribeEvent
	public void onKey(KeyInputEvent event) {
		if(Keyboard.getEventKeyState()) {
			for(Module m : modules) {
				if(m.getKey() == Keyboard.getEventKey()) {
					m.toggle();
				}
			}
		}
	}
	
	@SubscribeEvent
	public void onTick(ClientTickEvent event) {
		for(Module m : modules) {
			if(m.isToggled()) {
				m.update();
			}
		}
	}
	
	@SubscribeEvent
	public void onRender(RenderWorldLastEvent event) {
		for(Module m : modules) {
			if(m.isToggled()) {
				m.render();
			}
		}
	}
	
}
