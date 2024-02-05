import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Bank implements IBank {
    private List<IAccount> accounts;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    @Override
    public void openAccount(IAccount account) {
        accounts.add(account);
    }

    @Override
    public void closeAccount(int accountNumber) {
        Iterator<IAccount> iterator = accounts.iterator();
        while (iterator.hasNext()) {
            IAccount account = iterator.next();
            if (account.getAccountNumber() == accountNumber) {
                if (account.getCurrentBalance() >= 0) {
                    iterator.remove();
                } else {
                    System.out.println("Account not closed due to debt.");
                }
                return;
            }
        }
    }

    @Override
    public List<IAccount> getAllAccounts() {
        return accounts;
    }

    @Override
    public List<IAccount> getAllAccountsInDebt() {
        List<IAccount> debtAccounts = new ArrayList<>();
        for (IAccount account : accounts) {
            if (account.getCurrentBalance() < 0) {
                debtAccounts.add(account);
            }
        }
        return debtAccounts;
    }

    @Override
    public List<IAccount> getAllAccountsWithBalance(double balanceAbove) {
        List<IAccount> accountsWithBalanceAbove = new ArrayList<>();
        for (IAccount account : accounts) {
            if (account.getCurrentBalance() > balanceAbove) {
                accountsWithBalanceAbove.add(account);
            }
        }
        return accountsWithBalanceAbove;
    }
}
