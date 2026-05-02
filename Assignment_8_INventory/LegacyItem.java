package Assignment_8_INventory;

// LegacyItem class
// This is an old class that cannot directly work with Product interface
public class LegacyItem {

    private int itemId;
    private String description;

    // Parameterized constructor
    public LegacyItem(int itemId, String description) {
        this.itemId = itemId;
        this.description = description;
    }

    // Method used in the old system
    public void print() {
        System.out.println("Legacy Item -> ID: " + itemId + ", Description: " + description);
    }
}
