package me.gitai.mcutils.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Gitai.me(i@gitai.me) on 10/5/17.
 */
public class Home implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if(!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "This plugin is for players only!");
            return true;
        }
        Player player = (Player)sender;
        Location location = player.getLocation();
        if(command.getName().equalsIgnoreCase("sethome")) {
            player.setBedSpawnLocation(location, true);
            sender.sendMessage(ChatColor.BLUE + "New home at " +
                    location.getBlockX() + "," +
                    location.getBlockY() + "," +
                    location.getBlockZ());
        } else if (command.getName().equalsIgnoreCase("home")) {
            player.teleport(player.getBedSpawnLocation());
        }
        return true;
    }
}
