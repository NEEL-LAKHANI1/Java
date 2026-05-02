package Assignment_5_BankingApplication;

public class LoanAccount extends Account {

    double loanLimit;

    // Constructor
    public LoanAccount(String accountNumber, int customerId, double loanAmount, double loanLimit) {
        super(accountNumber, customerId, loanAmount, "Loan");
        this.loanLimit = loanLimit;
    }

    // Override deposit — repayment, uses if-else, no exception needed
    @Override
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("  [Loan] Repayment failed: Amount must be greater than zero.");
        } else {
            double repayment = Math.min(amount, getBalance()); // can't repay more than what's owed
            setBalance(getBalance() - repayment);
            System.out.println("  [Loan] Repaid: Rs." + repayment + " | Remaining Loan: Rs." + getBalance());
            if (getBalance() == 0) {
                System.out.println("  [Loan] Loan fully repaid!");
            }
        }
    }


    // Override withdraw — throws BankException if borrowing would exceed the loan limit
    // (This is the only case we need an exception here)
    @Override
    public void withdraw(double amount) throws BankException {
        if ((getBalance() + amount) > loanLimit) {
            throw new BankException(
                    "Cannot borrow Rs." + amount +
                            ". Loan limit is Rs." + loanLimit +
                            ". Currently owed: Rs." + getBalance()
            );
        }
        setBalance(getBalance() + amount); // more debt
        System.out.println("  [Loan] Borrowed: Rs." + amount + " | Total Owed: Rs." + getBalance());
    }

    // Display loan account details
    @Override
    public void displayInfo() {
        System.out.println("    Account Type   : " + accountType);
        System.out.println("    Account Number : " + accountNumber);
        System.out.println("    Amount Owed    : Rs." + getBalance()); // getter to read private balance
        System.out.println("    Loan Limit     : Rs." + loanLimit);
    }
}
