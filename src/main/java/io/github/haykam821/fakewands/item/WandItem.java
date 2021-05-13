package io.github.haykam821.fakewands.item;

import com.sk89q.worldedit.command.tool.Tool;

import eu.pb4.polymer.item.VirtualItem;
import net.minecraft.item.Item;

public class WandItem extends Item implements VirtualItem {
	private final Item proxy;
	private final Tool tool;

	public WandItem(Item proxy, Tool tool, Item.Settings settings) {
		super(settings);

		this.proxy = proxy;
		this.tool = tool;
	}

	public WandItem(Item proxy, Tool tool) {
		this(proxy, tool, new Item.Settings().maxCount(1));
	}

	public Tool getTool() {
		return this.tool;
	}

	@Override
	public Item getVirtualItem() {
		return this.proxy;
	}
}