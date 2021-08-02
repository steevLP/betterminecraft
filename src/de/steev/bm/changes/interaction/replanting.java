package de.steev.bm.changes.interaction;

import de.steev.bm.main;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public class replanting {

    private main plugin;

    /**
     * event constructor
     * @param plugin plugin instance
     */
    public replanting(main plugin) {
        plugin.getLogger().info("replanting handler Registered");
        this.plugin = plugin;
    }

    /**
     * simplified function for handling replanting works only with arrays
     * @param item the material of each drop
     * @param amount the drop amount of each item
     */
    public static void planting(Material[] item, int[] amount, Block target){
        Ageable crop = (Ageable) target.getBlockData();
        Location loc = target.getLocation().clone().add(0.5, 0.5, 0.5);

        // TODO: validate if code may throw errors

        if(crop.getAge() == crop.getMaximumAge()){
            for(int i = 0; i < amount[0]; i++) {
                target.getLocation().getWorld().dropItem(loc, new ItemStack(item[0]));
            }

            for(int i = 0; i < amount[1]; i++) {
                target.getLocation().getWorld().dropItem(loc, new ItemStack(item[1]));
            }
            crop.setAge(0);
            target.setBlockData(crop);
        }
    }
}
