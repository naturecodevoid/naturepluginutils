package dev.naturecodevoid.spigot.naturepluginutils.commands;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Command implements CommandExecutor {
    public JavaPlugin plugin;

    private final ArrayList<String> subCommands = new ArrayList<String>();
    private final ArrayList<String> subCommandsLowerCase = new ArrayList<String>();
    private final ArrayList<SubCommand> subCommandsClasses = new ArrayList<SubCommand>();
    private final ArrayList<String> commandAliases = new ArrayList<String>();

    public Command(JavaPlugin plugin) {
        this.plugin = plugin;
        this.init();
    }

    protected void init() {
        // Run other initialization code here
    }

    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        if (args.length > 0) {
            if (validSubcommand(Array.get(args, 0).toString())) {
                Object[] argsNoSubCommand = ArrayUtils.removeElement(args, Array.get(args, 0));
                subCommandsClasses.get(subCommandsLowerCase.indexOf(Array.get(args, 0).toString().toLowerCase())).run(sender, (String[]) argsNoSubCommand);
            }
        } else {
            return run(sender, command, label, args);
        }
        return true;
    }

    public boolean run(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        throw new NotImplementedException();
    }

    public String addCommandAlias(String name) {
        commandAliases.add(name);
        return name;
    }

    public SubCommandInfo addSubCommand(String name, SubCommand _class) {
        subCommands.add(name);
        subCommandsLowerCase.add(name.toLowerCase());
        subCommandsClasses.add(_class);
        return getSubCommand(name.toLowerCase());
    }

    public SubCommandInfo getSubCommand(String nameLowerCase) {
        int index = subCommandsLowerCase.indexOf(nameLowerCase.toLowerCase());
        SubCommandInfo info = new SubCommandInfo();
        info.name = getSubCommandString(index);
        info.nameLowerCase = getSubCommandLowerCase(index);
        info._class = getSubCommandClass(index);
        return info;
    }

    public String getSubCommandString(int index) {
        return subCommands.get(index);
    }

    public String getSubCommandLowerCase(int index) {
        return subCommandsLowerCase.get(index);
    }

    public SubCommand getSubCommandClass(int index) {
        return subCommandsClasses.get(index);
    }

    public ArrayList<String> onTabComplete(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        if (args.length > 1) if (validSubcommand(Array.get(args, 0).toString())) {
            // Subcommand
            ArrayList<String> options = new ArrayList<String>();

            String subCommandName = Array.get(args, 0).toString().toLowerCase();

            SubCommandInfo subCommand = getSubCommand(subCommandName);

            try {
                options.addAll(subCommand._class.getTabComplete(sender, command, label, args));
            } catch (Exception ignored) {

            }

            return options;
        }
        if (commandAliases.contains(command.getName()) && !(args.length > 1)) {
            ArrayList<String> options = new ArrayList<String>(subCommands);

            try {
                options.addAll(tabComplete(sender, command, label, args));
            } catch (Exception ignored) {

            }

            return options;
        }
        return null;
    }

    public ArrayList<String> tabComplete(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        throw new NotImplementedException();
    }

    public boolean validSubcommand(String name) {
        return subCommandsLowerCase.contains(name.toLowerCase());
    }

    public boolean validAlias(String name) {
        return commandAliases.contains(name.toLowerCase());
    }
}
