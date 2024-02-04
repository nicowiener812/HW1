public interface IAccount {
    void deposit(double amount);
    void withdraw(double amount) throws Exception;
    double getBalance();
    String getAccountNumber();
}
