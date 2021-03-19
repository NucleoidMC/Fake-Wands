package io.github.haykam821.fakewands.item;

import com.sk89q.worldedit.command.tool.Tool;

import net.minecraft.item.Item;
import xyz.nucleoid.plasmid.fake.FakeItem;

public class WandItem extends Item implements FakeItem {
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
	public Item asProxy() {
		return this.proxy;
	}
}