package Wasserman.Zachary.BankAccountTest;


import Wasserman.Zachary.BankAccount.BankAccount;
import org.junit.Test;
import static org.junit.Assert.*;
public class BankAccountTest {

    @Test
    public void creditClosedTest(){
        BankAccount acc1 = new BankAccount("Savings", "Zachary Waters", "Closed", "Enabled", 500.00, .05);
        Double expected = 500.0;
        Double actual = acc1.credit(100.0);
        assertEquals(expected, actual);

    }
    @Test
    public void creditBalanceTest(){
        BankAccount acc1 = new BankAccount("Savings", "Zachary Waters", "Open", "Enabled", 500.00, .05);
        Double expected = 600.0;
        Double actual = acc1.credit(100.0);
        assertEquals(expected, actual);
    }
    @Test
    public void debitClosedTest(){
        BankAccount acc1 = new BankAccount("Savings", "Zachary Waters", "Closed", "Enabled", 500.00, .05);
        Double expected = 500.0;
        Double actual = acc1.debit(100.0);
        assertEquals(expected, actual);

    }
    @Test
    public void debitBalanceTest(){
        BankAccount acc1 = new BankAccount("Savings", "Zachary Waters", "Open", "Enabled", 500.00, .05);
        Double expected = 400.0;
        Double actual = acc1.debit(100.0);
        assertEquals(expected, actual);
    }
}
