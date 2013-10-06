package com.canemonster15.marketeconomy;

import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class MarketEcoListener implements Listener{
	
	public MarketEconomy plugin;
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e){
		Player player = e.getPlayer();
		if(!plugin.players.contains(player.getName())){
			double startmoney = plugin.config.getDouble("Start Money");
			plugin.players.set(player.getName() + ".Balance", startmoney);
			player.sendMessage(plugin.prefix + "Account Created!");
		}else{
			double balance = plugin.players.getDouble(player.getName() + ".Balance");
			player.sendMessage(plugin.prefix + "Account Balance: " + balance);
		}
	}
	
	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent e){
		Player player = e.getEntity();
		Player kplayer = player.getKiller();
		double amount = plugin.players.getDouble(player.getName() + ".Balance") * 0.05;
		if(e.getEntityType() == EntityType.PLAYER){
			plugin.players.set(player.getName() + ".Balance", plugin.players.getDouble(player.getName() + ".Balance") - amount);
			player.sendMessage(plugin.prefix + "You lost " + amount + " for dying!");
			plugin.players.set(kplayer.getName() + ".Balance", plugin.players.getDouble(kplayer.getName() + ".Balance") + amount);
			kplayer.sendMessage(plugin.prefix + "You gained " + amount + " for killing " + player.getName());
		}
	}
	
}
