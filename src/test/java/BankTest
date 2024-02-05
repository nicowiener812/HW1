import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankSystemTest {
    private IAccount account;

    @BeforeEach
    void setUp() {
        // Create a new account before each test
        account = new StandardAccount(1, -100); // You can adjust the account type and parameters here
    }

    @Test
    void testDeposit() {
        // Deposit some money
        account.deposit(200.0);

        // Get the current balance
        double currentBalance = account.getCurrentBalance();

        // Check if the current balance matches the expected balance after the deposit
        assertEquals(200.0, currentBalance, 0.01); // 0.01 is the delta for comparing double values
    }

    @Test
    void testWithdrawWithinCreditLimit() {
        // Withdraw within the credit limit
        double withdrawnAmount = account.withdraw(50.0);

        // Get the current balance
        double currentBalance = account.getCurrentBalance();

        // Check if the withdrawn amount matches the expected amount
        assertEquals(50.0, withdrawnAmount, 0.01);
        // Check if the current balance matches the expected balance after the withdrawal
        assertEquals(-50.0, currentBalance, 0.01);
    }

    @Test
    void testWithdrawExceedCreditLimit() {
        // Attempt to withdraw an amount exceeding the credit limit
        double withdrawnAmount = account.withdraw(200.0);

        // Get the current balance
        double currentBalance = account.getCurrentBalance();

        // Check if the withdrawn amount matches the expected amount (limited by the credit limit)
        assertEquals(100.0, withdrawnAmount, 0.01);
        // Check if the current balance matches the expected balance after the withdrawal
        assertEquals(-100.0, currentBalance, 0.01);
    }

    @Test
    void testWithdrawNegativeAmount() {
        // Attempt to withdraw a negative amount (should not affect the balance)
        double withdrawnAmount = account.withdraw(-50.0);

        // Get the current balance
        double currentBalance = account.getCurrentBalance();

        // Check if the withdrawn amount is zero
        assertEquals(0.0, withdrawnAmount, 0.01);
        // Check if the current balance remains unchanged
        assertEquals(-100.0, currentBalance, 0.01);
    }
}
