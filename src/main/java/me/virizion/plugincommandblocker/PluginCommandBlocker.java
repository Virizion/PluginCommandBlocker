package me.virizion.plugincommandblocker;

import java.util.Map;
import java.util.TreeMap;

import org.bukkit.ChatColor;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.plugin.java.JavaPlugin;

import me.virizion.plugincommandblocker.commands.PluginCommandBlockerCommand;
import me.virizion.plugincommandblocker.listeners.PluginCommandListener;

public class PluginCommandBlocker extends JavaPlugin
{

	private Map<String, String> blockedCommands = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

	@Override
	public void onEnable()
	{
		saveDefaultConfig();
		getConfig().options().copyDefaults(true);
		saveConfig();
		
		ConfigurationSection blockedCommandsSection = getConfig().getConfigurationSection("blocked-commands");
		blockedCommandsSection.getKeys(false).forEach(command -> this.blockedCommands.put(command, ChatColor.translateAlternateColorCodes('&', blockedCommandsSection.getString(command))));
		
		getServer().getPluginManager().registerEvents(new PluginCommandListener(this), this);
		getCommand("plugincommandblocker").setExecutor(new PluginCommandBlockerCommand(this));
	}

	public boolean isCommandBlocked(String command)
	{
		return this.blockedCommands.containsKey(command);
	}

	public String getBlockMessage(String command)
	{
		return this.blockedCommands.get(command);
	}

}
