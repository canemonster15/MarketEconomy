package com.canemonster15.marketeconomy;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class MarketEcoBid implements CommandExecutor{
	
	MarketEconomy plugin;
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		
		if(cmd.getName().equalsIgnoreCase("bid")) {
			
			if(!sender.hasPermission("marketeco.bid")) {
				sender.sendMessage(plugin.prefix + "Insufficient Permission!");
			}else {
				if(args.length == 0){
					sender.sendMessage(plugin.prefix + "Specify the amount you want to buy!");
				} else if(args.length == 1) {
					sender.sendMessage(plugin.prefix + "Specify the amount you want to buy for!");
				} else if(args.length == 2) {
					sender.sendMessage(plugin.prefix + "Bid added!");
				}
				try{
					int bidamount = Integer.parseInt(args[0]);
					double bidprice = Integer.parseInt(args[1]);
					plugin.bidname.add(sender.getName());
					plugin.bidamount.add(bidamount);
					plugin.bidprice.add(bidprice);
				}catch(NumberFormatException e) {
					e.printStackTrace();
				}
			}
			
		}
		
		return false;
	}
	

}
