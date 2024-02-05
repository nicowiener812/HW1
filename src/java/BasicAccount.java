public class BasicAccount implements IAccount {
    private int accountNumber;
    private double balance;
    private double withdrawalLimit;

    public BasicAccount(int accountNumber, double withdrawalLimit) {
        this.accountNumber = accountNumber;
        this.withdrawalLimit = (withdrawalLimit > 0) ? withdrawalLimit : 0;
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
        double withdrawalAmount = Math.min(amount, withdrawalLimit);
        if (withdrawalAmount > balance) {
            withdrawalAmount = balance;
        }
        balance -= withdrawalAmount;
        return withdrawalAmount;
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
