package io.github.nahkd123.persistentcontainerlistbug;

import java.util.Collections;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;

public class PluginMain extends JavaPlugin {
	private NamespacedKey tagKey;

	@Override
	public void onLoad() {
		tagKey = new NamespacedKey(this, "example");
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (!(sender instanceof Player player)) {
			sender.sendMessage("run command as player please");
			return true;
		}

		if (args[0].equals("give")) {
			ItemStack stack = new ItemStack(Material.DIAMOND);
			ItemMeta meta = stack.getItemMeta();
			meta.getPersistentDataContainer().set(tagKey, PersistentDataType.LIST.dataContainers(), Collections.emptyList());
			stack.setItemMeta(meta);
			player.getInventory().setItemInMainHand(stack);
			player.sendMessage("now restart your server (use /stop or something), then run '/demo check' while holding this item");
		}

		if (args[0].equals("check")) {
			ItemStack stack = player.getInventory().getItemInMainHand();
			ItemMeta meta = stack.getItemMeta();
			meta.getPersistentDataContainer().get(tagKey, PersistentDataType.LIST.dataContainers()); // <-- THROW HERE
			player.sendMessage("wait... nothing happened? either the \"bug\" has been fixed or you didn't restart your server");
		}

		return true;
	}
}
