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

	/**
	 * Implements drops on death and can handle other deaths
	 * @param event the parsed event on any death
	 */
	@EventHandler
	public void onEntityDeath(EntityDeathEvent event) {
		if(event.getEntity() instanceof Player){
			Location death = ((Player) event.getEntity()).getPlayer().getLocation();
			UUID uuid = ((Player) event.getEntity()).getPlayer().getUniqueId();
			plugin.playerDataConfig.set("" + uuid + ".death", death);
		} else if(event.getEntity() instanceof Animals) {


			if(event.getEntity().toString() == "CraftPig"){
				// leather: 2, porkchop: 2
				// TODO: do the implementation
			}
		}
	}
}
