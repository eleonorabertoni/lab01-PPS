import lab01.example.model.AccountHolder;
import lab01.example.model.BankAccount;

import lab01.example.model.SimpleBankAccountWithATM;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the SimpleBankAccount implementation
 */
class SimpleBankAccountWithATMTest extends AbstractBankAccountTest {

    @Override
    @BeforeEach
    void beforeEach(){
        super.beforeEach();
        bankAccount = new SimpleBankAccountWithATM(accountHolder, 0);
    }

    @Override
    int getFee() {
        return 1;
    }

}

