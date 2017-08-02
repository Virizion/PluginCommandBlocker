package me.virizion.plugincommandblocker.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import me.virizion.plugincommandblocker.PluginCommandBlocker;

public class PluginCommandListener implements Listener
{

	private PluginCommandBlocker pluginCommandBlocker;

	public PluginCommandListener(PluginCommandBlocker pluginCommandBlocker)
	{
		this.pluginCommandBlocker = pluginCommandBlocker;
	}

	@EventHandler
	public void onPlayerCommandPreProcess(PlayerCommandPreprocessEvent event)
	{
		String command = event.getMessage().split(" ", 2)[0];
		
		if (this.pluginCommandBlocker.isCommandBlocked(command))
		{
			event.setCancelled(true);
			event.getPlayer().sendMessage(this.pluginCommandBlocker.getBlockMessage(command));
		}
	}

}
