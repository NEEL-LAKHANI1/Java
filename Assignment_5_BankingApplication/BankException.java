package Assignment_5_BankingApplication;

public class BankException extends Exception{

    public BankException(String message){
        super(message);
    }
}

// A custom exception class for all banking errors.
// Instead of printing errors with System.out.println, we now THROW this exception.
// This is better practice — the caller decides how to handle the error.
