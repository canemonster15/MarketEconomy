package com.canemonster15.marketeconomy;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class MarketEcoOffer implements CommandExecutor {

	MarketEconomy plugin;

	public boolean onCommand(CommandSender sender, Command cmd,
			String commandLabel, String[] args) {

		if (cmd.getName().equalsIgnoreCase("offer")) {

			if (!sender.hasPermission("marketeco.offer")) {
				sender.sendMessage(plugin.prefix + "Insufficient Permission!");
			} else {
				if (args.length == 0) {
					sender.sendMessage(plugin.prefix
							+ "Specify the amount you want to sell!");
				} else if (args.length == 1) {
					sender.sendMessage(plugin.prefix
							+ "Specify the amount you want to sell for!");
				} else if (args.length == 2) {
					sender.sendMessage(plugin.prefix + "Offer added!");
				}
				try {
					int offeramount = Integer.parseInt(args[0]);
					double offerprice = Integer.parseInt(args[1]);
					plugin.offername.add(sender.getName());
					plugin.offeramount.add(offeramount);
					plugin.offerprice.add(offerprice);
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
			}

		}

		return true;
	}

}
