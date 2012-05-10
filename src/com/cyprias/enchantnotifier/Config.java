package com.cyprias.enchantnotifier;

import org.bukkit.configuration.Configuration;

public class Config {
	private EnchantNotifier plugin;
	private static Configuration config;
	
	String stEnchantMessage;
	Boolean boolUseMChatName = false;
		
	public Config(EnchantNotifier plugin) {
		this.plugin = plugin;
		config = plugin.getConfig().getRoot();
		config.options().copyDefaults(true);
		plugin.saveConfig();
		stEnchantMessage = config.getString("stEnchantMessage").replaceAll("(?i)&([a-k0-9])", "\u00A7$1");// §
		boolUseMChatName = config.getBoolean("boolUseMChatName");
		
		
		
	}
}
