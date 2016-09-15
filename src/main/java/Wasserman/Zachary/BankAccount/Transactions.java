package Wasserman.Zachary.BankAccount;

import java.util.ArrayList;

/**
 * Created by zacharywasserman on 9/14/16.
 */
public class Transactions {

        public Transactions(){

    }
    ArrayList<String> transactionLog = new ArrayList<String>();


    public Double credit(Double amount, BankAccount account){


        if(account.getStatus() == "Open") {
            account.setBalance(account.getBalance() + amount) ;
            transactionLog.add(account.getAccNum() + ": $" +amount+ " withdrawn");
            return account.getBalance();

        }
        else{
            System.out.println("Access Denied! Account Closed!");
            transactionLog.add(account.getAccNum() + ": Failed withdrawal");
            return 0.0;
        }




    }
    // withdrawal money from bank account
    public Double debit(Double amount, BankAccount account){
        if(account.getStatus() == "Open"){
            account.setBalance(account.getBalance() - amount);
            account.getBalance();
            transactionLog.add(account.getAccNum() + ": $" +amount+ " deposited");
        }
        else {
            System.out.println("Access Denied! Account Closed!");
            transactionLog.add(account.getAccNum() + ": Failed withdrawal");
            //return balance;
        }
        return account.getBalance();

    }
    // checks if user is able to check balance
    public Double inquiry(BankAccount account) {
        if (account.getStatus() != "Frozen") {
            transactionLog.add(account.getAccNum() + ": balance inquiry");
            return account.getBalance();

        } else {
            System.out.println("Access Denied! Account Frozen!");
            transactionLog.add(account.getAccNum() + ": failed balance inquiry");
            return 0.0;
        }

    }
        //Changes the account holders name
        public void changeName(String name, BankAccount account){
            if (account.getStatus() == "Open"){
                transactionLog.add(account.getAccNum() + ": Account holder name changed");
                account.setName(name);
            }
            else{
                transactionLog.add(account.getAccNum() + ": failed attemped to change name");
                System.out.println("Access Denied! Account Closed!");
            }
        }
        //Transfers money from one account to another
        public void accountTransfer(Double amount, BankAccount account1, BankAccount account2){
            if (account1.getHolderName() == account2.getHolderName() && account1.getBalance() > amount){
                account1.setBalance(account1.getBalance() - amount);
                account2.setBalance(account2.getBalance() + amount);
                transactionLog.add(amount+" transferred from " +account1.getAccNum()+ " to "+ account2.getAccNum());
            }
            else{
                transactionLog.add(account1.getAccNum()+": failed account transfer");
                System.out.println("Error!");
            }
        }
        //Checks if user has overdraft protection. if so, it stops the transaction and outputs a warning.
        public void overDraft(BankAccount account, Double amount){
            if (account.getBalance() < amount && account.getOverDraft() == "Enabled" ){
                System.out.println("OverDraft Protection Activated!");
                System.out.println("Account Balance: " +account.getBalance());
                System.out.println("Tried to withdrawal: " +amount);
                transactionLog.add(account.getAccNum()+": Overdraft protected engaged.");
            }
        }
        //Prints out transactionlog
        public void printTransactionLog(){
            System.out.println("TRANSACTION LOG");
            for (int i = 0; i < transactionLog.size(); i++){
                System.out.println(transactionLog.get(i));
            }
        }
        // changing status of an account
        public void changeStatus(String status, BankAccount account) {
            if (account.getBalance() != 0 && status == "Closed"){
                System.out.println("Error! cannot close and account unless it has a balance of zero");
            }
            else if (account.getStatus() != "Closed"){
                account.setStatus(status);
                transactionLog.add(account.getAccNum() + " changed to " + status);
            }
            else {
                System.out.println("Cannot open a closed account.");
                transactionLog.add(account.getAccNum()+ " : Status Change denied!");
            }


        }

}
