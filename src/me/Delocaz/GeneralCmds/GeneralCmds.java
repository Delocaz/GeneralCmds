package me.Delocaz.GeneralCmds;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class GeneralCmds extends JavaPlugin implements Listener {
	List<GCommand> l = new ArrayList<GCommand>();
	GConfiguration cfg;
	public void onEnable() {
		InputStream f = getResource("commands.txt");
		BufferedReader reader;
		cfg = new GConfiguration("config");
		List<Class<? extends GCommand>> l = new ArrayList<Class<? extends GCommand>>();
		try {
			reader = new BufferedReader(new InputStreamReader(f));
			String text = null;
			while ((text = reader.readLine()) != null) {
				@SuppressWarnings("unchecked")
				Class<? extends GCommand> cmd = (Class<? extends GCommand>) Class.forName("me.Delocaz.GeneralCmds.Commands."+text);
				l.add(cmd);
				registerCommand(text, cmd);
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			print("Class loading failed! Disabling...");
			setEnabled(false);
			return;
		}
		getServer().getPluginManager().registerEvents(this, this);
	}
	public void print(String txt) {
		getLogger().info(txt);
	}
	public void registerCommand(String name, Class<? extends GCommand> g) {
		GCommand cmd = null;
		try {
			cmd = g.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		cmd.setName(name);
		cmd.setConfig(cfg);
		getCommand(name).setExecutor(cmd);
		getServer().getPluginManager().registerEvents(cmd, this);
	}
}
