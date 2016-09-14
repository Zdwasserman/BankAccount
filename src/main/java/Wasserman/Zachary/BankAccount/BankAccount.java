package Wasserman.Zachary.BankAccount;


public class BankAccount {
    private static int nextAcc = 1000000001;
    private String accType;
    private int accNum;
    private Double balance;
    private String holderName;
    private Double interest;
    private String status;
    private String overDraft;

    // Constructor for bank account
    public BankAccount(String accType, String holderName, String status, String overDraft, Double balance, Double interest){
        this.accType = accType;
        this.holderName = holderName;
        this.status = status;
        this.overDraft = overDraft;
        this.accNum = nextAcc++;
        this.balance = balance;
        this.interest = interest;

    }
    // Getters
    public String getAccType(){
        return accType;
    }
    public String getHolderNAme(){
        return holderName;
    }
    public String getOverDraft(){
        return overDraft;
    }
    public int getAccNum(){
        return accNum;
    }
    public Double getBalance(){
        return balance;
    }
    public Double getInterest(){
        return interest;
    }

    // deposit money into bank account
    public Double credit(Double amount){
        if(status == "Open"){
            balance += amount;
        }
        else{
            System.out.println("Access Denied! Account Closed!");
            return balance;
        }
        return balance;
    }
    // withdrawal money from bank account
    public Double debit(Double amount){
        if(status == "Open"){
            balance -= amount;
        }
        else{
            System.out.println("Access Denied! Account Closed!");
            return balance;
        }
        return balance;
    };

}
