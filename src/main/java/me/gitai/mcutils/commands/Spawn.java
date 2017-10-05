package me.gitai.mcutils.commands;

import me.gitai.mcutils.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Gitai.me(i@gitai.me) on 10/5/17.
 */
public class Spawn implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if(!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "This plugin is for players only!");
            return true;
        }
        Player player = (Player)sender;
        if (command.getName().equalsIgnoreCase("spawn")) {
            player.teleport(player.getWorld().getSpawnLocation());
        }
        return true;
    }
}
