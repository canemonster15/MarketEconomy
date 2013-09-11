package com.canemonster15.marketeconomy;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class MarketEconomy extends JavaPlugin{
	
	public final Logger log = Logger.getLogger("Minecraft");
	public String prefix = ChatColor.BLUE + "[MarketEconomy] ";
	public File playersFile;
	public File companyFile;
	public File configFile;
	public FileConfiguration config;
	public FileConfiguration players;
	public FileConfiguration company;
	public HashSet<String>  bids = new HashSet<String>();
	public HashSet<String> offers = new HashSet<String>();

	
	public void onEnable(){
		log.info("################################");
		log.info("#                              #");
		log.info("#         MarketEconomy        #");
		log.info("#             v0.1             #");
		log.info("#                              #");
		log.info("################################");
		log.info("#                              #");
		log.info("#            Enabled           #");
		log.info("#                              #");
		log.info("################################");
		this.getServer().getPluginManager().registerEvents(new MarketEcoListener(), this);
		this.getConfig().options().copyDefaults(true);
		this.getConfig().addDefault("Start Money", 100);
		this.getCommand("pay").setExecutor(new MarketEcoPay());
		this.getCommand("c").setExecutor(new MarketEcoCompany());
		this.getCommand("company").setExecutor(new MarketEcoCompany());
		this.getCommand("money").setExecutor(new MarketEcoMoney());
		playersFile = new File(getDataFolder(), "players.yml");
		companyFile = new File(getDataFolder(), "companies.yml");
		configFile = new File(getDataFolder(), "config.yml");
		try{
			firstRun();
		}catch(Exception e){
			e.printStackTrace();
		}
		config = new YamlConfiguration();
		players = new YamlConfiguration();
		company = new YamlConfiguration();
		loadYamls();
	}
	
	private void firstRun() throws Exception {
		if(!playersFile.exists()){
			playersFile.getParentFile().mkdirs();
			copy(getResource("players.yml"), playersFile);
		}
		if(!companyFile.exists()){
			companyFile.getParentFile().mkdirs();
			copy(getResource("company.yml"), companyFile);
		}
		if(!configFile.exists()){
			configFile.getParentFile().mkdirs();
			copy(getResource("config.yml"), configFile);
		}
	}
	
	public void copy(InputStream in, File file){
		try{
			OutputStream out = new FileOutputStream(file);
			byte[] buf = new byte[1024];
			int len;
			while((len=in.read(buf))>0){
	            out.write(buf,0,len);
	        }
	        out.close();
	        in.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void saveYamls(){
		try{
			config.save(configFile);
			players.save(playersFile);
			company.save(companyFile);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void loadYamls(){
		try{
			config.load(configFile);
			players.load(playersFile);
			company.load(companyFile);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void onDisable(){
		log.info("################################");
		log.info("#                              #");
		log.info("#         MarketEconomy        #");
		log.info("#             v0.1             #");
		log.info("#                              #");
		log.info("################################");
		log.info("#                              #");
		log.info("#           Disabled           #");
		log.info("#                              #");
		log.info("################################");
		this.saveConfig();
		saveYamls();
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		return false;
	}
}
