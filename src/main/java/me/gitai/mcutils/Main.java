package me.gitai.mcutils;

import me.gitai.mcutils.commands.Back;
import me.gitai.mcutils.commands.Home;
import me.gitai.mcutils.commands.Spawn;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

/**
 * Created by Gitai.me(i@gitai.me) on 10/5/17.
 */
public class Main extends JavaPlugin implements Listener {
    private static Main instance;
    public HashMap<String, Location> mDeadlocs
            = new HashMap<String, Location>();
    public Main() {
    }

    public void onEnable() {
        instance = this;
        this.getCommand("home").setExecutor(new Home());
        this.getCommand("sethome").setExecutor(new Home());
        this.getCommand("back").setExecutor(new Back());
        this.getCommand("spawn").setExecutor(new Spawn());
        Bukkit.getServer().getPluginManager().registerEvents(this, this);
        Bukkit.getConsoleSender().sendMessage("MCUtils is Running!");
    }

    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("MCUtils is Downed!");
    }

    public static Main getInstance() {
        return instance;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {

    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event){
        Bukkit.getConsoleSender().sendMessage("Dead in " + event.getEntity().getLocation().toString());
        mDeadlocs.put(
                event.getEntity().getName(),
                event.getEntity().getLocation());
    }

    @EventHandler
    public void onPlayerTeleport(PlayerTeleportEvent event){
        Bukkit.getConsoleSender().sendMessage("Teleport from " + event.getFrom());
        mDeadlocs.put(
                event.getPlayer().getName(),
                event.getFrom());
    }
}
