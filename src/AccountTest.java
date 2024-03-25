import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

public class AccountTest {
    private Account account1;
    private Account account2;
    private Account account3;
    private Account account4;

    @Before
    public void setUp() {
        account1 = new Account("Ted Murphy", 72354, 102.56);
        account2 = new Account("Jane Smith", 69713, 40.00);
        account3 = new Account("Edward Demsey", 93757, 759.32);
        account4 = account1;
    }

    @Test
    public void testAlias() {
        assertSame("Account1 and Account4 should be aliases", account1, account4);
    }

    @Test
    public void testDeposit() {
        account1.deposit(100);
        assertEquals(202.56, account1.getBalance(), 0.001);
    }

    @Test
    public void testDepositException() {
        assertThrows("Negative deposit should throw ArithmeticException", IllegalArgumentException.class,
                () -> account1.deposit(-100));
    }

    @Test
    public void testWithdraw() {
        if (account2 != null) {
            account2.withdraw(10, 2);
        }
        assertEquals("Withdrawal amount incorrect", 28.00, account2.getBalance(), 0.001);
    }

    @Test
    public void testAddInterest() {
        double expectedInterest = 759.32;
        expectedInterest += (expectedInterest * 0.035);
        assertEquals("Interest calculation incorrect", expectedInterest, account3.addInterest(), 0.001);
    }

    @Test
    public void testToString() {
        String expectedString = "69713" + "\t" + "Jane Smith" + "\t" + "$40.00";
        assertEquals("toString method not equal to expected", expectedString, account2.toString());
    }

    @After
    public void tearDown() {
        account1 = null;
        account2 = null;
        account3 = null;
        account4 = null;
    }
}