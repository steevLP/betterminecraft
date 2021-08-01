package de.steev.bm.events;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Animals;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import de.steev.bm.main;

public class KillEvent implements Listener{
	private main plugin;

	public KillEvent(main plugin) {
		plugin.getLogger().info("Mob Death events Registered");
		this.plugin = plugin;
	}

	@EventHandler
	public void onEntityDeath(EntityDeathEvent event) {
		if(event.getEntity() instanceof Player){
			Location death = ((Player) event.getEntity()).getPlayer().getLocation();
			UUID uuid = ((Player) event.getEntity()).getPlayer().getUniqueId();
			plugin.playerDataConfig.set("" + uuid + ".death", death);
		} else if(event.getEntity() instanceof Animals) {
			if(event.getEntity().toString() == "CraftPig"){

				int i1_amnt = ThreadLocalRandom.current().nextInt(1, 2 + 1);
				int i2_amnt = ThreadLocalRandom.current().nextInt(1, 2 + 1);

				plugin.getLogger().info("Output amount: "  + i1_amnt);
				plugin.getLogger().info("Output amount: "  + i2_amnt);

				event.getDrops().clear();

				for(int i = 0; i < i1_amnt; i++) {
					event.getEntity().getLocation().getWorld().dropItem(event.getEntity().getLocation(), new ItemStack(Material.LEATHER));
					plugin.getLogger().info("Output Leather");
				}

				for(int i = 0; i < i2_amnt; i++) {
					event.getEntity().getLocation().getWorld().dropItem(event.getEntity().getLocation(), new ItemStack(Material.PORKCHOP));
					plugin.getLogger().info("Output Porkchop");
				}
			}
		}
	}
}
