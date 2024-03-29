# Persistent Container List
Weird issue when trying to get the `List` of data containers when the underlying NBT list is empty.

## Version
```
[14:46:08] [Server thread/INFO]: This server is running CraftBukkit version 4066-Spigot-e9ec548-45d6a60 (MC: 1.20.4) (Implementing API version 1.20.4-R0.1-SNAPSHOT)
[14:46:08] [Server thread/INFO]: Checking version, please wait...
[14:46:10] [Thread-15/INFO]: You are running the latest version
```

## How to reproduce
0. Clone this repository.
0. Build with Maven: `mvn package`.
0. Copy built plugin to `plugin/` folder.
0. Start the server.
0. Join the server, run `/demo give` as player to get the item.
0. Restart the server (either by stopping then starting again or any other means that involves stopping the server).
0. Join the server again, run `/demo check` **while holding the item that you've previously received** and it should throw an exception.

## Log
```
[14:45:37] [Server thread/INFO]: nahkd123 issued server command: /demo check
[14:45:37] [Server thread/ERROR]: null
org.bukkit.command.CommandException: Unhandled exception executing command 'demo' in plugin PersistentContainerListBug v0.0.1
        at org.bukkit.command.PluginCommand.execute(PluginCommand.java:47) ~[spigot-api-1.20.4-R0.1-SNAPSHOT.jar:?]
        at org.bukkit.command.SimpleCommandMap.dispatch(SimpleCommandMap.java:149) ~[spigot-api-1.20.4-R0.1-SNAPSHOT.jar:?]
        at org.bukkit.craftbukkit.v1_20_R3.CraftServer.dispatchCommand(CraftServer.java:887) ~[spigot-1.20.4-R0.1-SNAPSHOT.jar:4066-Spigot-e9ec548-45d6a60]
        at org.bukkit.craftbukkit.v1_20_R3.command.BukkitCommandWrapper.run(BukkitCommandWrapper.java:50) ~[spigot-1.20.4-R0.1-SNAPSHOT.jar:4066-Spigot-e9ec548-45d6a60]
        at com.mojang.brigadier.context.ContextChain.runExecutable(ContextChain.java:73) ~[brigadier-1.2.9.jar:?]
        at net.minecraft.commands.execution.tasks.ExecuteCommand.a(SourceFile:29) ~[spigot-1.20.4-R0.1-SNAPSHOT.jar:4066-Spigot-e9ec548-45d6a60]
        at net.minecraft.commands.execution.tasks.ExecuteCommand.execute(SourceFile:13) ~[spigot-1.20.4-R0.1-SNAPSHOT.jar:4066-Spigot-e9ec548-45d6a60]
        at net.minecraft.commands.execution.UnboundEntryAction.a(SourceFile:8) ~[spigot-1.20.4-R0.1-SNAPSHOT.jar:4066-Spigot-e9ec548-45d6a60]
        at net.minecraft.commands.execution.CommandQueueEntry.a(SourceFile:8) ~[spigot-1.20.4-R0.1-SNAPSHOT.jar:4066-Spigot-e9ec548-45d6a60]
        at net.minecraft.commands.execution.ExecutionContext.a(SourceFile:107) ~[spigot-1.20.4-R0.1-SNAPSHOT.jar:4066-Spigot-e9ec548-45d6a60]
        at net.minecraft.commands.CommandDispatcher.a(CommandDispatcher.java:413) ~[spigot-1.20.4-R0.1-SNAPSHOT.jar:4066-Spigot-e9ec548-45d6a60]
        at net.minecraft.commands.CommandDispatcher.performCommand(CommandDispatcher.java:335) ~[spigot-1.20.4-R0.1-SNAPSHOT.jar:4066-Spigot-e9ec548-45d6a60]
        at net.minecraft.commands.CommandDispatcher.a(CommandDispatcher.java:322) ~[spigot-1.20.4-R0.1-SNAPSHOT.jar:4066-Spigot-e9ec548-45d6a60]
        at net.minecraft.server.network.PlayerConnection.a(PlayerConnection.java:1856) ~[spigot-1.20.4-R0.1-SNAPSHOT.jar:4066-Spigot-e9ec548-45d6a60]
        at net.minecraft.server.network.PlayerConnection.lambda$15(PlayerConnection.java:1818) ~[spigot-1.20.4-R0.1-SNAPSHOT.jar:4066-Spigot-e9ec548-45d6a60]
        at net.minecraft.util.thread.IAsyncTaskHandler.b(SourceFile:67) ~[spigot-1.20.4-R0.1-SNAPSHOT.jar:4066-Spigot-e9ec548-45d6a60]
        at java.util.concurrent.CompletableFuture$AsyncSupply.run(CompletableFuture.java:1768) ~[?:?]
        at net.minecraft.server.TickTask.run(SourceFile:18) ~[spigot-1.20.4-R0.1-SNAPSHOT.jar:4066-Spigot-e9ec548-45d6a60]
        at net.minecraft.util.thread.IAsyncTaskHandler.d(SourceFile:156) ~[spigot-1.20.4-R0.1-SNAPSHOT.jar:4066-Spigot-e9ec548-45d6a60]
        at net.minecraft.util.thread.IAsyncTaskHandlerReentrant.d(SourceFile:23) ~[spigot-1.20.4-R0.1-SNAPSHOT.jar:4066-Spigot-e9ec548-45d6a60]
        at net.minecraft.server.MinecraftServer.b(MinecraftServer.java:1191) ~[spigot-1.20.4-R0.1-SNAPSHOT.jar:4066-Spigot-e9ec548-45d6a60]
        at net.minecraft.server.MinecraftServer.d(MinecraftServer.java:1) ~[spigot-1.20.4-R0.1-SNAPSHOT.jar:4066-Spigot-e9ec548-45d6a60]
        at net.minecraft.util.thread.IAsyncTaskHandler.x(SourceFile:130) ~[spigot-1.20.4-R0.1-SNAPSHOT.jar:4066-Spigot-e9ec548-45d6a60]
        at net.minecraft.server.MinecraftServer.bl(MinecraftServer.java:1170) ~[spigot-1.20.4-R0.1-SNAPSHOT.jar:4066-Spigot-e9ec548-45d6a60]
        at net.minecraft.server.MinecraftServer.x(MinecraftServer.java:1163) ~[spigot-1.20.4-R0.1-SNAPSHOT.jar:4066-Spigot-e9ec548-45d6a60]
        at net.minecraft.util.thread.IAsyncTaskHandler.c(SourceFile:139) ~[spigot-1.20.4-R0.1-SNAPSHOT.jar:4066-Spigot-e9ec548-45d6a60]
        at net.minecraft.server.MinecraftServer.w_(MinecraftServer.java:1147) ~[spigot-1.20.4-R0.1-SNAPSHOT.jar:4066-Spigot-e9ec548-45d6a60]
        at net.minecraft.server.MinecraftServer.w(MinecraftServer.java:1060) ~[spigot-1.20.4-R0.1-SNAPSHOT.jar:4066-Spigot-e9ec548-45d6a60]
        at net.minecraft.server.MinecraftServer.lambda$0(MinecraftServer.java:304) ~[spigot-1.20.4-R0.1-SNAPSHOT.jar:4066-Spigot-e9ec548-45d6a60]
        at java.lang.Thread.run(Thread.java:1583) ~[?:?]
Caused by: java.lang.IllegalArgumentException: The found tag instance (NBTTagList) cannot store List
        at com.google.common.base.Preconditions.checkArgument(Preconditions.java:445) ~[guava-32.1.2-jre.jar:?]
        at org.bukkit.craftbukkit.v1_20_R3.persistence.CraftPersistentDataTypeRegistry.extract(CraftPersistentDataTypeRegistry.java:348) ~[spigot-1.20.4-R0.1-SNAPSHOT.jar:4066-Spigot-e9ec548-45d6a60]
        at org.bukkit.craftbukkit.v1_20_R3.persistence.CraftPersistentDataContainer.get(CraftPersistentDataContainer.java:73) ~[spigot-1.20.4-R0.1-SNAPSHOT.jar:4066-Spigot-e9ec548-45d6a60]
        at io.github.nahkd123.persistentcontainerlistbug.PluginMain.onCommand(PluginMain.java:42) ~[?:?]
        at org.bukkit.command.PluginCommand.execute(PluginCommand.java:45) ~[spigot-api-1.20.4-R0.1-SNAPSHOT.jar:?]
        ... 29 more
```