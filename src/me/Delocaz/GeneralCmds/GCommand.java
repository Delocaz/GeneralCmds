package me.Delocaz.GeneralCmds;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class GCommand implements CommandExecutor, Listener {
	private String name;
	private GConfiguration cfg;
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		if (arg0 instanceof Player) {
			executePlayer((Player) arg0, arg3);
		} else {
			executeConsole((ConsoleCommandSender) arg0, arg3);			
		}
		execute(arg0, arg3);
		return true;
	}
	public void executePlayer(Player arg0, String[] arg3) {
	}
	public void executeConsole(ConsoleCommandSender arg0, String[] arg3) {
	}
	public void execute(CommandSender arg0, String[] arg3) {
	}
	public GeneralCmds getPlugin() {
		return (GeneralCmds) Bukkit.getPluginManager().getPlugin("GeneralCmds");
	}
	public void addUserData(Player p, String node, Object content) {
		GConfiguration gc = new GConfiguration("players/"+p.getName());
		gc.set(node, content);
		gc.save();
	}
	public Object getUserData(Player p, String node) {
		GConfiguration gc = new GConfiguration("players/"+p.getName());
		gc.load();
		return gc.get(node);
	}
	public GConfiguration getConfig() {
		return cfg;
	}
	public void setConfig(GConfiguration cfg) {
		this.cfg = cfg;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
}
