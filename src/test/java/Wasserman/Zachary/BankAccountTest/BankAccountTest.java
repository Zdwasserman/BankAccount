package Wasserman.Zachary.BankAccountTest;

import Wasserman.Zachary.BankAccount.Transactions;
import Wasserman.Zachary.BankAccount.BankAccount;
import org.junit.Test;
import static org.junit.Assert.*;
public class BankAccountTest {

    @Test
    public void creditClosedTest(){
        BankAccount acc1 = new BankAccount("Savings", "Zachary Waters", "Closed", "Enabled", 500.00, .05);
        Transactions feat = new Transactions();
        Double expected = 0.0;
        Double actual = feat.credit(100.0, acc1);
        assertEquals(expected, actual);

    }
    @Test
    public void creditBalanceTest(){
        BankAccount acc1 = new BankAccount("Savings", "Zachary Waters", "Open", "Enabled", 500.00, .05);
        Transactions feat = new Transactions();
        Double expected = 600.0;
        Double actual = feat.credit(100.0, acc1);
        assertEquals(expected, actual);
    }
    @Test
    public void debitClosedTest(){
        BankAccount acc1 = new BankAccount("Savings", "Zachary Waters", "Closed", "Enabled", 500.00, .05);
        Transactions feat = new Transactions();
        Double expected = 500.0;
        Double actual = feat.debit(100.0, acc1);
        assertEquals(expected, actual);

    }
    @Test
    public void debitBalanceTest(){
        BankAccount acc1 = new BankAccount("Savings", "Zachary Waters", "Open", "Enabled", 500.00, .05);
        Transactions feat = new Transactions();
        Double expected = 400.0;
        Double actual = feat.debit(100.0, acc1);
        assertEquals(expected, actual);
    }
    @Test
    public void inquiryTest(){
        BankAccount acc1 = new BankAccount("Savings", "Zachary Waters", "OFAC", "Enabled", 500.00, .05);
        Transactions feat = new Transactions();
        Double expected = 500.00;
        Double actual = feat.inquiry(acc1);
        assertEquals(expected, actual);
    }
    @Test
    public void changeNameTest() {
        BankAccount acc1 = new BankAccount("Savings", "Zachary Waters", "Open", "Enabled", 500.00, .05);
        Transactions feat = new Transactions();
        feat.changeName("Tarmogoyf", acc1);
        String actual = acc1.getHolderName();
        String expected = "Tarmogoyf";
        assertEquals(expected, actual);
    }
    @Test
    public void accountTransferTest() {
        BankAccount acc1 = new BankAccount("Savings", "Zachary Waters", "Open", "Enabled", 500.00, .05);
        BankAccount acc2 = new BankAccount("Savings", "Zachary Waters", "Open", "Enabled", 500.00, .05);
        Transactions feat = new Transactions();
        feat.accountTransfer(300.0, acc1, acc2);
        Double actual = acc1.getBalance();
        Double expected = 200.0;
        assertEquals(expected, actual);
        actual = acc2.getBalance();
        expected = 800.0;
        assertEquals(expected, actual);
    }
    @Test
    public void overDraftProtectionTest() {
        BankAccount acc1 = new BankAccount("Savings", "Zachary Waters", "Open", "Enabled", 500.00, .05);
        Transactions feat = new Transactions();
        feat.overDraft(acc1, 600.0);
        Double actual = 500.00;
        Double expected =  acc1.getBalance();
        assertEquals(expected, actual);
    }

}
