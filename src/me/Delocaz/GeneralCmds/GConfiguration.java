package me.Delocaz.GeneralCmds;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

public class GConfiguration extends YamlConfiguration {
	File f;
	public GConfiguration(String file) {
		f = new File(Bukkit.getPluginManager().getPlugin("GeneralCmds").getDataFolder().getPath() + "/" + file + ".yml");
		load();
	}
	public void load() {
		try {
			load(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InvalidConfigurationException e) {
			e.printStackTrace();
		}
	}
	public void save() {
		try {
			save(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
