package com.spikeyhunter.originscommand;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;


public class Main extends JavaPlugin implements Listener {
	
    public void onEnable() {
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "OriginsCommand by SpipkeyHunter has been enabled!");
        this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        getConfig();
    }
   
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "OriginsCommand by SpipkeyHunter has been disabled!");
        getConfig().options().copyDefaults(false);
        saveDefaultConfig();
    }
   
    
      
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        Player p = (Player) s;
        String website = getConfig().getString("website");
        String store = getConfig().getString("store");
        String discord = getConfig().getString("discord");
        String towny = getConfig().getString("towny");
        String lobby = getConfig().getString("lobby");
        
        if (cmd.getName().equalsIgnoreCase("website")) {
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&lWebsite &8>> " + ChatColor.GREEN + website ));
                }
        else if (cmd.getName().equalsIgnoreCase("store")) {
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&lStore &8>> " + ChatColor.GREEN + store ));
        }
        else if (cmd.getName().equalsIgnoreCase("lobby")) {
            ByteArrayDataOutput out = ByteStreams.newDataOutput();
            out.writeUTF("Connect");
            out.writeUTF(lobby);
            p.sendPluginMessage(this, "BungeeCord", out.toByteArray());
        }
        else if (cmd.getName().equalsIgnoreCase("towny")) {
            ByteArrayDataOutput out = ByteStreams.newDataOutput();
            out.writeUTF("Connect");
            out.writeUTF(towny);
            p.sendPluginMessage(this, "BungeeCord", out.toByteArray());
        }
        else if (cmd.getName().equalsIgnoreCase("discord")) {
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&lDiscord &8>> " + ChatColor.GREEN + discord ));
        }
        
        return true;
     }
}