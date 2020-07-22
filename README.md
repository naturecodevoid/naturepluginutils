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
git submodule foreach --recursive git pull
```

If that doesn't work, try:

```sh
cd ./src/main/java/dev/naturecodevoid/spigot/naturepluginutils && git fetch && git pull && cd ../../../../../../../
```
