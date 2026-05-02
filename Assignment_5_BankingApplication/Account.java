package Assignment_5_BankingApplication;

public abstract class Account {
    String accountNumber;
    int    customerId;
    String accountType;

    // balance is PRIVATE — only accessible via getter/setter below
    private double balance;

    // Constructor: called by child classes using super()
    public Account(String accountNumber, int customerId, double balance, String accountType) {
        this.accountNumber = accountNumber;
        this.customerId    = customerId;
        this.accountType   = accountType;
        this.balance       = balance;
    }

    // ── Getter: read the balance ──
    public double getBalance() {
        return balance;
    }

    // ── Setter: update the balance (protected so only subclasses can call it) ──
    protected void setBalance(double balance) {
        this.balance = balance;
    }

    // ── Basic deposit — uses simple if-else, no exception needed ──
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("  Deposit failed: Amount must be greater than zero.");
        } else {
            setBalance(getBalance() + amount);
            System.out.println("  Deposited: Rs." + amount + " | New Balance: Rs." + getBalance());
        }
    }

    // ── Basic withdraw ──
    // throws BankException ONLY when withdrawal amount exceeds current balance.
    // Child classes override this to add their own extra checks.
    public void withdraw(double amount) throws BankException {
        if (amount > getBalance()) {
            throw new BankException("Insufficient funds. Current balance: Rs." + getBalance());
        }
        setBalance(getBalance() - amount);
        System.out.println("  Withdrawn: Rs." + amount + " | New Balance: Rs." + getBalance());
    }

    // ── Every child class MUST implement this to show its own details ──
    public abstract void displayInfo();
}
