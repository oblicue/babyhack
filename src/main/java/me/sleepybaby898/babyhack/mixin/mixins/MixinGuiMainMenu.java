package me.sleepybaby898.babyhack.mixin.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import me.sleepybaby898.babyhack.Reference;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.text.TextFormatting;

@Mixin({GuiMainMenu.class})
public class MixinGuiMainMenu extends GuiScreen {
	
	@Inject(method = {"drawScreen"}, at = {@At("TAIL")}, cancellable = true)
	public void drawText(CallbackInfo ci) {
		mc.fontRenderer.drawStringWithShadow(TextFormatting.WHITE + Reference.NAME + " " + TextFormatting.GRAY + Reference.VERSION, 1, 1, -1);
		mc.fontRenderer.drawStringWithShadow(TextFormatting.WHITE + "created by " + TextFormatting.GRAY + Reference.AUTHOR, 1, mc.fontRenderer.FONT_HEIGHT + 1, -1);
	}
}
