package com.canemonster15.marketeconomy;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class MarketEcoBid implements CommandExecutor{

	MarketEconomy plugin;
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		
		if(cmd.getName().equalsIgnoreCase("bid")){
			if(!sender.hasPermission("marketeco.bid")){
				sender.sendMessage(plugin.prefix + "Insufficient Permission!");
			}else{
				plugin.bids.add(sender.getName());
				
			}
		}
		
		return false;
	}

}
