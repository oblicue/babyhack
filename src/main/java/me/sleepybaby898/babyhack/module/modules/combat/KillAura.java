package me.sleepybaby898.babyhack.module.modules.combat;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.lwjgl.input.Keyboard;

import me.sleepybaby898.babyhack.module.Category;
import me.sleepybaby898.babyhack.module.Module;
import me.sleepybaby898.babyhack.setting.settings.SettingInteger;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;

public class KillAura extends Module {
	
	SettingInteger range;
	Minecraft mc = Minecraft.getMinecraft();
	
	public KillAura() {
		super("KillAura", Keyboard.KEY_R, Category.COMBAT);
		range = this.register("Range", 5, 1, 6);
	}
	
	public void update() {
		
		if(Minecraft.getMinecraft().player == null || Minecraft.getMinecraft().player.isDead) return;
		List<Entity> targets = Minecraft.getMinecraft().world.loadedEntityList.stream()
				.filter(entity -> entity != mc.player)
				.filter(entity -> mc.player.getDistance(entity) <= range.getValue())
				.filter(entity -> !entity.isDead)
				.sorted(Comparator.comparing(s -> mc.player.getDistance(s)))
				.collect(Collectors.toList());
		
		targets.forEach(target -> {
			attack(target);
		});
	}
	
	public void attack(Entity e) {
		if (mc.player.getCooledAttackStrength(0) >= 1 && e instanceof EntityAnimal || e instanceof EntityMob || e instanceof EntityPlayer){
			mc.playerController.attackEntity(mc.player, e);
			mc.player.swingArm(EnumHand.MAIN_HAND);
		}
	}
	
	

}
