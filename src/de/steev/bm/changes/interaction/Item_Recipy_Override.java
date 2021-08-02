package de.steev.bm.changes.interaction;

import de.steev.bm.main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public class Item_Recipy_Override {

    main plugin;
    NamespacedKey item;
    static ShapedRecipe rec_item;

    /**
     * Overrides vanilla recipes
     * @param plugin Plugin Reference
     * @param Item Item name
     * @param result the dropping item
     * @param amount the droprate
     */
    public Item_Recipy_Override(main plugin, String Item, Material result, int amount){
        this.plugin = plugin;
        item = new NamespacedKey(plugin, Item);
        ItemStack itemStack = new ItemStack(result);
        itemStack.setAmount(amount);

        rec_item = new ShapedRecipe(item, itemStack);
    }

    /**
     * registers recipe to bukkit recipe handler
     * @param ing Ingredience reference
     * @param mat material ing will reference
     * @param rec the recipe shape
     */
    public static void register_recipy(char[] ing, Material[] mat, String[] rec){
        //Recipe shapes
        rec_item.shape(rec[0], rec[1], rec[2]);

        for(int i = 0; i < ing.length; i++) {
            // Material Definitions
            rec_item.setIngredient(ing[i], mat[i]);
        }

        // Add recipes to Server
        Bukkit.addRecipe(rec_item);
    }
}
