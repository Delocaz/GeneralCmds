package me.Delocaz.GeneralCmds.Commands;

import org.bukkit.command.CommandSender;

import me.Delocaz.GeneralCmds.GCommand;

public class Ping extends GCommand {
	public void execute(CommandSender sender, String[] args) {
		sender.sendMessage("Pong!");
	}
}
