package Assignment_5_BankingApplication;

public class Customer {

    int customerId;
    String name;

    // Constructor: sets up a new customer
    public Customer(int customerId, String name) {
        this.customerId = customerId;
        this.name       = name;
    }

    // Print customer info
    public void display() {
        System.out.println("Customer ID: " + customerId + " | Name: " + name);
    }
}
