package lab01.example.model;

/**
 * This class represent a particular instance of a BankAccount.
 * In particular, a Simple Bank Account with ATM allows always the deposit
 * while the withdrawal is allowed only if the balance greater or equal the withdrawal amount.
 * In this implementation each transaction done implies paying a 1$ fee.
 */
public class SimpleBankAccountWithATM extends AbstractBankAccount {

    public SimpleBankAccountWithATM(final AccountHolder holder, final double balance) {
        super(balance, holder);
    }

    @Override
    public int getFee() {

        return 1;
    }
}
