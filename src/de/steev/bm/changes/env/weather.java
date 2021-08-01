package de.steev.bm.changes.env;

import org.bukkit.World;

public class weather {

	static long lastThunder = 0;
	long delay = 24000;
	private static boolean isThunder(World world) {
		return world.getThunderDuration() > 0;
	}
	
	public static void changeWeather(World world) {
		if(isThunder(world)) {
			if(lastThunder + 24000 > world.getFullTime()) {
				world.setClearWeatherDuration(1000);
			}else {
				lastThunder = world.getFullTime();
			}
		}
	}
}
