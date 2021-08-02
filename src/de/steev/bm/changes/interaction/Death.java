package de.steev.bm.changes.interaction;

import de.steev.bm.main;
import org.bukkit.Material;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import java.util.concurrent.ThreadLocalRandom;

public class Death {
    /**
     * handles animal loot drops only works as array
     * @param amount the drop amount
     * @param drops the dropping items
     * @param plugin plugin reference
     */
    public void onAnimalDeath(int[] amount, Material[] drops, main plugin, EntityDeathEvent event){

        // Random Drop amount generation DO NOT TOUCH!!!!
        int i1_amnt = ThreadLocalRandom.current().nextInt(1, amount[0] + 1);
        int i2_amnt = ThreadLocalRandom.current().nextInt(1, amount[1] + 1);

        // Clears Vanilla drops
        event.getDrops().clear();

        // Drops specified amount of the specified items
        for(int i = 0; i < i1_amnt; i++) { event.getEntity().getLocation().getWorld().dropItem(event.getEntity().getLocation(), new ItemStack(drops[0])); }
        for(int i = 0; i < i2_amnt; i++) { event.getEntity().getLocation().getWorld().dropItem(event.getEntity().getLocation(), new ItemStack(drops[1])); }
    }
}
