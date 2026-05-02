package Assignment_8_INventory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// InventoryManager class using Singleton pattern
class InventoryManager {

    // Single instance of InventoryManager
    private static InventoryManager instance;

    // List to store all products
    private List<Product> inventory;

    // Private constructor so object cannot be created from outside
    private InventoryManager() {
        inventory = new ArrayList<>();
    }

    // Method to get the single instance of InventoryManager
    public static InventoryManager getInstance() {
        if (instance == null) {
            instance = new InventoryManager();
        }
        return instance;
    }

    // Adds a product to inventory
    public void addProduct(Product product) {
        inventory.add(product);
    }

    // Returns iterator for the inventory list
    public Iterator<Product> returnInventory() {
        return inventory.iterator();
    }
}


public class InventorySystem{

    public static void main(String[] args) {

        // Get the single InventoryManager object
        InventoryManager manager = InventoryManager.getInstance();

        // Add new products
        manager.addProduct(new NewProduct("Laptop"));
        manager.addProduct(new NewProduct("Keyboard"));

        // Create legacy items
        LegacyItem item1 = new LegacyItem(101, "Old Monitor");
        LegacyItem item2 = new LegacyItem(102, "Old Printer");

        // Add legacy items using adapter
        manager.addProduct(new ProductAdapter(item1));
        manager.addProduct(new ProductAdapter(item2));

        // Get iterator for inventory
        Iterator<Product> iterator = manager.returnInventory();

        System.out.println("Inventory Details:\n");

        // Iterate through inventory and display details
        while (iterator.hasNext()) {
            Product product = iterator.next();
            product.displayDetails();
        }
    }

}
