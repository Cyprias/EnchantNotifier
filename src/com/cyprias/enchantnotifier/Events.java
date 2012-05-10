package com.cyprias.enchantnotifier;

import in.mDev.MiracleM4n.mChatSuite.mChatSuite;

import java.util.Map;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.EnchantItemEvent;


public class Events implements Listener {
	private EnchantNotifier plugin;

	
	public Events(EnchantNotifier plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler(priority = EventPriority.NORMAL)
	public void onEnchantItem(EnchantItemEvent event) {
		if (event.isCancelled()) {
			return;
		}

		String enchants = "";

		for (Map.Entry<org.bukkit.enchantments.Enchantment, Integer> entry : event.getEnchantsToAdd().entrySet()) {
			enchants += entry.getKey().getName() + " " + entry.getValue() + ", ";
		}

		enchants = enchants.substring(0, enchants.length() - 2);
		String msg = String.format(plugin.config.stEnchantMessage, plugin.getDisplayName(event.getEnchanter()), event.getItem().getType().name(), enchants, event.getExpLevelCost());

		plugin.info(msg);
		plugin.permMessage("enchantnotify.notify", msg);
	}

}
