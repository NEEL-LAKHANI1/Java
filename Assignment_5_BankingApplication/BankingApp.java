package Assignment_5_BankingApplication;

// Main Class
import java.util.ArrayList;
public class BankingApp {

    public static void main(String[] args) {


        // STEP 1: Create Customers

        ArrayList<Customer> customers = new ArrayList<>();

        customers.add(new Customer(101, "Aisha Sharma"));
        customers.add(new Customer(102, "Rohan Mehta"));
        customers.add(new Customer(103, "Priya Nair"));


        // STEP 2: Create Accounts

        ArrayList<Account> accounts = new ArrayList<>();

        accounts.add(new SavingsAccount("SA-101", 101, 25000, 1000));
        accounts.add(new LoanAccount   ("LA-101", 101, 50000, 200000));

        accounts.add(new SavingsAccount("SA-102", 102, 15000, 500));
        accounts.add(new SavingsAccount("SA-103", 102, 8000,  500));

        accounts.add(new LoanAccount   ("LA-103", 103, 100000, 300000));


        // STEP 3: Transactions (with try-catch for BankException)

        System.out.println("======== TRANSACTIONS ========\n");

        SavingsAccount aishaSavings = (SavingsAccount) findAccount(accounts, "SA-101");
        LoanAccount    aishaLoan    = (LoanAccount)    findAccount(accounts, "LA-101");
        SavingsAccount rohanSavings = (SavingsAccount) findAccount(accounts, "SA-102");
        LoanAccount    priyaLoan    = (LoanAccount)    findAccount(accounts, "LA-103");

        System.out.println(">> Aisha's Savings Account (SA-101)");
        aishaSavings.deposit(5000);                                                                         // no try-catch needed
        try {
            aishaSavings.withdraw(3000);
        } catch (BankException e) {
            System.out.println("  Error: " + e.getMessage());
        }

        try {
            aishaSavings.withdraw(25000);
        } catch (BankException e) {
            System.out.println("  Error: " + e.getMessage());
        } // fails - min balance


        System.out.println("\n>> Aisha's Loan Account (LA-101)");
        aishaLoan.deposit(10000);                                                                            // repayment, no try-catch needed
        try {
            aishaLoan.withdraw(20000);
        } catch (BankException e) {
            System.out.println("  Error: " + e.getMessage());
        } // borrow more
        try {
            aishaLoan.withdraw(200000);
        } catch (BankException e) {
            System.out.println("  Error: " + e.getMessage());
        } // fails - limit



        System.out.println("\n>> Rohan's Savings Account (SA-102)");
        rohanSavings.deposit(2000);                                                                          // no try-catch needed
        try {
            rohanSavings.withdraw(1000);
        } catch (BankException e) {
            System.out.println("  Error: " + e.getMessage());
        }


        System.out.println("\n>> Priya's Loan Account (LA-103)");
        priyaLoan.deposit(30000);                                                                            // repayment, no try-catch needed
        try {
            priyaLoan.withdraw(50000);
        } catch (BankException e) {
            System.out.println("  Error: " + e.getMessage());
        } // borrow more


        // STEP 4: Consolidated Report

        System.out.println("\n======== CONSOLIDATED REPORT ========\n");

        for (Customer customer : customers) {
            customer.display();

            boolean hasAccount = false;
            for (Account acc : accounts) {
                if (acc.customerId == customer.customerId) {
                    acc.displayInfo(); // polymorphic call — calls the right subclass method
                    System.out.println("    --------------------------------");
                    hasAccount = true;
                }
            }

            if (!hasAccount) {
                System.out.println("    No accounts found.");
            }
            System.out.println();
        }
    }

    // Helper: find an account by account number
    static Account findAccount(ArrayList<Account> accounts, String accountNumber) {
        for (Account acc : accounts) {
            if (acc.accountNumber.equals(accountNumber)) {
                return acc;
            }
        }
        return null;
    }
}
