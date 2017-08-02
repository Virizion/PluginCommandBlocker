package me.virizion.plugincommandblocker.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.google.common.base.Joiner;

import me.virizion.plugincommandblocker.PluginCommandBlocker;

public class PluginCommandBlockerCommand implements CommandExecutor
{

	private PluginCommandBlocker pluginCommandBlocker;

	public PluginCommandBlockerCommand(PluginCommandBlocker pluginCommandBlocker)
	{
		this.pluginCommandBlocker = pluginCommandBlocker;
	}

	@Override
	public boolean onCommand(CommandSender commandSender, Command command, String commandLabel, String[] args)
	{
		commandSender.sendMessage(ChatColor.GRAY.toString() + ChatColor.STRIKETHROUGH + "=====================================================");
		commandSender.sendMessage("");
		
		commandSender.sendMessage(ChatColor.BLUE + "Name: " + ChatColor.YELLOW + this.pluginCommandBlocker.getDescription().getName());
		commandSender.sendMessage(ChatColor.BLUE + "Authors: " + ChatColor.YELLOW + Joiner.on(", ").join(this.pluginCommandBlocker.getDescription().getAuthors()));
		commandSender.sendMessage(ChatColor.BLUE + "Version: " + ChatColor.YELLOW + this.pluginCommandBlocker.getDescription().getVersion());
		commandSender.sendMessage(ChatColor.BLUE + "Description: " + ChatColor.YELLOW + this.pluginCommandBlocker.getDescription().getDescription());
		
		commandSender.sendMessage("");
		commandSender.sendMessage(ChatColor.GRAY.toString() + ChatColor.STRIKETHROUGH + "=====================================================");
		
		return true;
	}

}
