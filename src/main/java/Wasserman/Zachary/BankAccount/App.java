package Wasserman.Zachary.BankAccount;


public class App {
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("Savings", "Zachary Waters", "Open", "Enabled", 500.00, .05);
        System.out.println(acc1.getAccNum());
        BankAccount acc2 = new BankAccount("Savings", "Jerosalee Waters", "Open", "Enabled", 600.00, .05);
        System.out.println(acc2.getAccNum());
    }
}

