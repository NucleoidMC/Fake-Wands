package io.github.haykam821.fakewands.mixin;

import com.sk89q.worldedit.LocalSession;
import com.sk89q.worldedit.command.tool.Tool;
import com.sk89q.worldedit.world.item.ItemType;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import io.github.haykam821.fakewands.Main;
import io.github.haykam821.fakewands.item.WandItem;

@Mixin(value = LocalSession.class, remap = false)
public class LocalSessionMixin {
	@Inject(method = "getTool", at = @At("HEAD"), cancellable = true)
	private void getFakeTool(ItemType item, CallbackInfoReturnable<Tool> ci) {
		WandItem wandItem = Main.getWandItem(item.getId());
		if (wandItem != null && wandItem.getTool() != null) {
			ci.setReturnValue(wandItem.getTool());
		}
	}
}
