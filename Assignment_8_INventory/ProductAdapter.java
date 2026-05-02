package Assignment_8_INventory;

// Adapter class
// Converts LegacyItem into a Product object
class ProductAdapter implements Product {
    private LegacyItem legacyItem;

    // Constructor accepts LegacyItem object
    public ProductAdapter(LegacyItem legacyItem) {
        this.legacyItem = legacyItem;
    }

    // Calls the print() method of LegacyItem
    @Override
    public void displayDetails() {
        legacyItem.print();
    }
}

// NewProduct class
// Represents products already following the Product interface
class NewProduct implements Product {
    private String name;

    // Constructor accepts only product name
    public NewProduct(String name) {
        this.name = name;
    }

    // Prints details of new product
    @Override
    public void displayDetails() {
        System.out.println("New Product -> Name: " + name);
    }
}
