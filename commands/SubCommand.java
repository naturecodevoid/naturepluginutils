package dev.naturecodevoid.spigot.naturepluginutils.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.apache.commons.lang.NotImplementedException;

import java.util.ArrayList;

public class SubCommand {
    public JavaPlugin plugin;

    public SubCommand(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public void run(CommandSender sender, String[] args) {
        throw new NotImplementedException();
    }

    public ArrayList<String> getTabComplete(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        throw new NotImplementedException();
    }
}
