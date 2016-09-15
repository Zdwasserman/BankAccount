package Wasserman.Zachary.BankAccount;


public class App {
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("Savings", "Bob Belcher", "Open", "Enabled", 1000.00, .05);
        //System.out.println(acc1.getAccNum());
        BankAccount acc2 = new BankAccount("Savings", "Tina Belcher", "Open", "Enabled", 800.00, .05);
        //System.out.println(acc2.getAccNum());
        BankAccount acc3 = new BankAccount("Savings", "Louise Belcher", "Open", "Enabled", 600.00, .05);

        Transactions feat = new Transactions();
        feat.credit(100.0, acc1);
        feat.debit(200.0, acc2);
        feat.accountTransfer(200.0, acc1, acc2);
        feat.changeName("Bob Belcher", acc3);
        feat.accountTransfer(200.0, acc1, acc3);


        feat.printTransactionLog();
    }
}

