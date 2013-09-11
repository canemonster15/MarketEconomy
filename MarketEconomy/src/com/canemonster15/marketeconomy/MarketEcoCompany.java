package com.canemonster15.marketeconomy;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class MarketEcoCompany implements CommandExecutor {
	
	MarketEconomy plugin;

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		
		if(cmd.getName().equalsIgnoreCase("c")){
			if(!sender.hasPermission("marketeco.company")){
				sender.sendMessage(plugin.prefix + "Insufficient permissions!");
			}else{
				if(args.length == 0){
					//Finish as commands Page!
				}else if(args.length == 1){
					if(args[0].equalsIgnoreCase("create")){
						sender.sendMessage(plugin.prefix + "Specify a name!");
					}
				}
			}
		}
		
		return false;
	}

}
