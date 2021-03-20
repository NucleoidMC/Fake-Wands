package io.github.haykam821.fakewands;

import com.sk89q.worldedit.command.tool.DistanceWand;
import com.sk89q.worldedit.command.tool.NavigationWand;
import com.sk89q.worldedit.command.tool.SelectionWand;

import io.github.haykam821.fakewands.item.WandItem;
import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Main implements ModInitializer {
	private static final String MOD_ID = "fakewands";

	private static final Identifier DISTANCE_WAND_ID = new Identifier(MOD_ID, "distance_wand");
	public static final WandItem DISTANCE_WAND = new WandItem(Items.IRON_AXE, new DistanceWand());

	private static final Identifier NAVIGATION_WAND_ID = new Identifier(MOD_ID, "navigation_wand");
	public static final WandItem NAVIGATION_WAND = new WandItem(Items.COMPASS, new NavigationWand());

	private static final Identifier SELECTION_WAND_ID = new Identifier(MOD_ID, "selection_wand");
	public static final WandItem SELECTION_WAND = new WandItem(Items.WOODEN_AXE, new SelectionWand());

	@Override
	public void onInitialize() {
		Registry.register(Registry.ITEM, DISTANCE_WAND_ID, DISTANCE_WAND);
		Registry.register(Registry.ITEM, NAVIGATION_WAND_ID, NAVIGATION_WAND);
		Registry.register(Registry.ITEM, SELECTION_WAND_ID, SELECTION_WAND);
	}

	public static WandItem getWandItem(String id) {
		if (id.equals(DISTANCE_WAND_ID.toString())) return DISTANCE_WAND;
		if (id.equals(NAVIGATION_WAND_ID.toString())) return NAVIGATION_WAND;
		if (id.equals(SELECTION_WAND_ID.toString())) return SELECTION_WAND;
		return null;
	}
}