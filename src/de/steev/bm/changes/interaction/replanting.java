package de.steev.bm.changes.interaction;

import de.steev.bm.main;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.concurrent.ThreadLocalRandom;

public class replanting implements Listener {

    private main plugin;

    public replanting(main plugin) {
        plugin.getLogger().info("replanting handler Registered");
        this.plugin = plugin;
    }

    // TODO: change planting to a single function that gets reused as the job plugin did

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event){
        if(event.getAction().equals(Action.RIGHT_CLICK_BLOCK)){

            // Get needed values and states
            Block target = event.getClickedBlock();
            Location loc = target.getLocation().clone().add(0.5, 0.5, 0.5);

            System.out.println(target.getType());

            // Detects the right block and its required action
            if(target.getType() == Material.CARROTS){
                Ageable crop = (Ageable) target.getBlockData();

                if(crop.getAge() == crop.getMaximumAge()){
                    for(int i = 0; i < 3; i++) {
                        target.getLocation().getWorld().dropItem(loc, new ItemStack(Material.CARROT));
                    }
                    crop.setAge(0);
                    target.setBlockData(crop);
                }
            } else if(target.getType() == Material.POTATOES){
                Ageable crop = (Ageable) target.getBlockData();

                if(crop.getAge() == crop.getMaximumAge()){
                    if(crop.getAge() == crop.getMaximumAge()){
                        int i1_amnt = ThreadLocalRandom.current().nextInt(1, 2 + 1);

                        for(int i = 0; i < i1_amnt; i++) {
                            target.getLocation().getWorld().dropItem(loc, new ItemStack(Material.POTATO));
                        }
                        crop.setAge(0);
                        target.setBlockData(crop);
                    }
                }
            } else if(target.getType() == Material.WHEAT){
                Ageable crop = (Ageable) target.getBlockData();

                if(crop.getAge() == crop.getMaximumAge()){
                    if(crop.getAge() == crop.getMaximumAge()){
                        int i1_amnt = ThreadLocalRandom.current().nextInt(1, 2 + 1);

                        target.getLocation().getWorld().dropItem(loc, new ItemStack(Material.WHEAT));
                        for(int i = 0; i < i1_amnt; i++) {
                            target.getLocation().getWorld().dropItem(loc, new ItemStack(Material.WHEAT_SEEDS));
                        }
                        crop.setAge(0);
                        target.setBlockData(crop);
                    }
                }
            } else if(target.getType() == Material.BEETROOTS){
                Ageable crop = (Ageable) target.getBlockData();

                if(crop.getAge() == crop.getMaximumAge()){
                    if(crop.getAge() == crop.getMaximumAge()){
                        int i1_amnt = ThreadLocalRandom.current().nextInt(1, 3 + 1);

                        target.getLocation().getWorld().dropItem(loc, new ItemStack(Material.BEETROOT));
                        for(int i = 0; i < i1_amnt; i++) {
                            target.getLocation().getWorld().dropItem(loc, new ItemStack(Material.BEETROOT_SEEDS));
                        }
                        crop.setAge(0);
                        target.setBlockData(crop);
                    }
                }
            } else {
                return;
            }
        }
    }
}
