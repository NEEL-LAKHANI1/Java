package Assignment_5_BankingApplication;

public class SavingsAccount extends Account{

    double minBalance;

    // Constructor
    public SavingsAccount(String accountNumber, int customerId, double balance, double minBalance) {
        super(accountNumber, customerId, balance, "Savings");
        this.minBalance = minBalance;
    }

    // Override deposit — uses if-else, no exception needed
    @Override
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("  [Savings] Deposit failed: Amount must be greater than zero.");
        } else {
            setBalance(getBalance() + amount);
            System.out.println("  [Savings] Deposited: Rs." + amount + " | New Balance: Rs." + getBalance());
        }
    }

    // Override withdraw — throws BankException if withdrawal would breach minBalance
    // (This is the only case we need an exception here)
    @Override
    public void withdraw(double amount) throws BankException {
        // Use getBalance() because balance is private in Account
        if ((getBalance() - amount) < minBalance) {
            throw new BankException(
                    "Cannot withdraw Rs." + amount +
                            ". Minimum balance of Rs." + minBalance + " must be maintained. " +
                            "Max you can withdraw: Rs." + (getBalance() - minBalance)
            );
        }
        setBalance(getBalance() - amount); // use setter to update private balance
        System.out.println("  [Savings] Withdrawn: Rs." + amount + " | New Balance: Rs." + getBalance());
    }

    // Display savings account details
    @Override
    public void displayInfo() {
        System.out.println("    Account Type   : " + accountType);
        System.out.println("    Account Number : " + accountNumber);
        System.out.println("    Balance        : Rs." + getBalance()); // getter to read private balance
        System.out.println("    Min Balance    : Rs." + minBalance);
    }
}
