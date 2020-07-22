# naturepluginutils

Utilities for spigot/bukkit plugins

## Installing

Using git submodules is recommended.

Run the following command to install:

```sh
git submodule add -b master -f --name naturepluginutils https://github.com/naturecodevoid/naturepluginutils.git ./src/main/java/dev/naturecodevoid/spigot/naturepluginutils
```

## Updating

Run the following command to update:

```sh
cd ./src/main/java/dev/naturecodevoid/spigot/naturepluginutils && git fetch && git pull && cd ../../../../../../../
```

### Examples

#### Base command:

```java
package my.plugin;

import dev.naturecodevoid.spigot.naturepluginutils.commands.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class ExampleCommand extends Command {
    public ExampleCommand(JavaPlugin plugin) {
        super(plugin);
    }

    @Override
    protected void init() {
        // Run other initialization code here,
        // such as adding subcommands
    }

    @Override
    public boolean run(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        plugin.getLogger().info("Hello World!");
        return true;
    }

    @Override
    public ArrayList<String> tabComplete(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        return new ArrayList<String>();
    }
}
```

#### Subcommand:

```java
TODO
```
