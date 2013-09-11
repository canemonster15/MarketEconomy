package com.canemonster15.marketeconomy;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MarketEcoPay implements CommandExecutor {
	
	MarketEconomy plugin;

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		
		if(cmd.getName().equalsIgnoreCase("pay")){
			
			if(!sender.hasPermission("marketeco.pay")){
				sender.sendMessage(plugin.prefix + "Insufficient Permission!");
			}else{
				
				if(args.length == 0){
					
					sender.sendMessage(plugin.prefix + "Specify a player!");
					
				}else if(args.length == 1){
					
					sender.sendMessage(plugin.prefix + "Specify a player!");
					
				}else if(args.length == 2){
					
					String tplayer = args[0];
					Player targetPlayer = Bukkit.getServer().getPlayer(tplayer);
					if(tplayer == null){
						sender.sendMessage(plugin.prefix + "Player not found.");
					}else{
						
						try{
							
							double amount = Double.parseDouble(args[1]);
							double newamount1 = plugin.players.getDouble(sender.getName() + ".Balance") - amount;
							double newamount2 = plugin.players.getDouble(targetPlayer.getName() + ".Balance") + amount;
							plugin.players.set(sender.getName() + ".Balance", newamount1);
							plugin.players.set(targetPlayer.getName() + ".Balance", newamount2);
							sender.sendMessage(plugin.prefix + amount + " received from " + sender.getName());
							targetPlayer.sendMessage(plugin.prefix + amount + " sent to " + targetPlayer.getName());
							
						}catch(NumberFormatException e){
							e.printStackTrace();
						}
						
					}
					
				}
				
			}
			
		}
		
		return false;
	}

}
