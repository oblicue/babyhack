package me.sleepybaby898.babyhack.module.modules.combat;

import org.lwjgl.input.Keyboard;

import me.sleepybaby898.babyhack.module.Category;
import me.sleepybaby898.babyhack.module.Module;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Items;
import net.minecraft.inventory.ClickType;
import net.minecraft.item.Item;

public class AutoTotem extends Module {
	private static Minecraft mc = Minecraft.getMinecraft();
	
	
	public AutoTotem() {
		super("autototem", Keyboard.KEY_NONE, Category.COMBAT);
	}
	
	public void update() {
		if (Minecraft.getMinecraft().player == null)
			return;
		
		Item searching = Items.AIR;
		
		if (Minecraft.getMinecraft().player.getHealth() + Minecraft.getMinecraft().player.getAbsorptionAmount() <= 24.0) {
			searching = Items.TOTEM_OF_UNDYING;
		}
		
		  if (mc.player.getHeldItemOffhand().getItem() == searching)
	            return;

	        if (mc.currentScreen != null)
	            return;
		
		if(getInventoryItemSlot(searching, false) != -1) {
			moveItemToOffhand(getInventoryItemSlot(searching, false));
			return;
		}
		
		if(getInventoryItemSlot(searching, false) != -1) {
			moveItemToOffhand(getInventoryItemSlot(searching, false));
		}
		
		
		
	}
	
	public static int getInventoryItemSlot(Item item, boolean hotbar) {
		
		
        for (int i = hotbar ? 9 : 0; i < 45; i++) {
            if (Minecraft.getMinecraft().player.inventory.getStackInSlot(i).getItem() == item)
                return i;
        }

        return -1;
    }
	
	public static void moveItemToOffhand(int slot) {
        int returnSlot = -1;

        if (slot == -1)
            return;

        mc.playerController.windowClick(0, slot < 9 ? slot + 36 : slot, 0, ClickType.PICKUP, mc.player);
        mc.playerController.windowClick(0, 45, 0, ClickType.PICKUP, mc.player);

        for (int i = 0; i < 45; i++) {
            if (mc.player.inventory.getStackInSlot(i).isEmpty()) {
                returnSlot = i;
                break;
            }
        }

        if (returnSlot != -1)
            mc.playerController.windowClick(0, returnSlot < 9 ? returnSlot + 36 : returnSlot, 0, ClickType.PICKUP, mc.player);
    }
	
}
