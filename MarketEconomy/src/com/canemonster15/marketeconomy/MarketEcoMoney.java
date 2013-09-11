package com.canemonster15.marketeconomy;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class MarketEcoMoney implements CommandExecutor {

	MarketEconomy plugin;
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		
		if(cmd.getName().equalsIgnoreCase("money")){
			if(!sender.hasPermission("marketeco.money")){
				
				sender.sendMessage(plugin.prefix + "Insufficient permission!");
				
			}else{
				
				double balance = plugin.players.getDouble(sender.getName() + ".Balance");
				sender.sendMessage(plugin.prefix + "Balance: " + balance);
				
			}
		}
		
		return false;
	}

}
