package de.steev.bm.events;

import de.steev.bm.changes.interaction.replanting;
import de.steev.bm.main;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class InteractEvent implements Listener {

    private main plugin;

    public InteractEvent(main plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event){
        if(event.getAction().equals(Action.RIGHT_CLICK_BLOCK)){

            /** the clicked block */
            Block target = event.getClickedBlock();
            /** the location of the clicked block */
            Location loc = target.getLocation().clone().add(0.5, 0.5, 0.5);
            Material[] drops;
            int[] amounts;
            // Detects which type to replant
            switch(target.getType().toString()){
                case "CARROTS":
                    /** Droping items */
                    drops = new Material[] { Material.CARROT };
                    amounts = new int[] {3};
                    replanting.planting(drops, amounts, target);
                    break;
                case "POTATOES":
                    drops = new Material[] { Material.POTATO };
                    amounts = new int[] {2};
                    replanting.planting(drops, amounts, target);
                    break;
                case "WHEAT":
                    drops = new Material[] { Material.WHEAT, Material.WHEAT_SEEDS };
                    amounts = new int[] {1,2};
                    replanting.planting(drops, amounts, target);
                    break;
                case "BEETROOTS":
                    drops = new Material[] { Material.BEETROOT, Material.BEETROOT_SEEDS };
                    amounts = new int[] {1,2};
                    replanting.planting(drops, amounts, target);
                    break;
            }
        }
    }
}
