public class StandardAccount implements IAccount {
    private int accountNumber;
    private double balance;
    private double creditLimit;

    public StandardAccount(int accountNumber, double creditLimit) {
        this.accountNumber = accountNumber;
        this.creditLimit = (creditLimit < 0) ? creditLimit : 0;
        this.balance = 0;
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    @Override
    public double withdraw(double amount) {
        if (amount < 0) {
            return 0;
        }
        if (amount > (balance + creditLimit)) {
            double maxWithdrawal = balance + creditLimit;
            balance = creditLimit;
            return maxWithdrawal;
        } else {
            balance -= amount;
            return amount;
        }
    }

    @Override
    public double getCurrentBalance() {
        return balance;
    }

    @Override
    public int getAccountNumber() {
        return accountNumber;
    }
}

