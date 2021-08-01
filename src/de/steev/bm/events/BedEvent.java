package de.steev.bm.events;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;

import de.steev.bm.main;

public class BedEvent implements Listener {
	
	private main plugin;
	
	public BedEvent(main plugin) {
		plugin.getLogger().info("Bed events Registered");
		this.plugin = plugin;
	}
	
	@EventHandler // Adding to the Player Variable
	public void onPlayerBedEnter(PlayerBedEnterEvent event) {
		final World world = event.getPlayer().getWorld();
		if(world.getTime() >= 13000 || world.getThunderDuration() > 0) {
			plugin.playerInBed++;
			// Checks if enough Players (currentSleeping >= OnlinePlayerAmount/2) are Sleeping
			if(plugin.playerInBed >= (int)plugin.getServer().getOnlinePlayers().size()/2) {
				// Delayed Task for detecting useless entries
				Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
					@Override
					public void run() {
						if(plugin.playerInBed >= (int)plugin.getServer().getOnlinePlayers().size()/2) {
							world.setTime(0);
							world.setWeatherDuration(7 * 24000);
						}
					} 
				}, 20L);
			}
		}
	}	
	
	@EventHandler // Subtracting to the Player Variable
	public void onPlayerBedLeave(PlayerBedLeaveEvent event) {
		// Subtraction from the PlayerInBed variable
		if(plugin.playerInBed > 0) {
			plugin.playerInBed--;
			// Failsafe to prevent integer underflow
		}else if(plugin.playerInBed > 0) {
			plugin.playerInBed = 0;
		}
	}
}