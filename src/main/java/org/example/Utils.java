package org.example;

import java.util.ArrayList;

public class Utils {

    public Account getAccountByID(int accountNumber){
        /*This function use to get account from account number*/

        for (Account account : BankingApp.getAccounts()){
            if(account.getAccountNumber()==accountNumber){
                return account;
            }
        }
        return null;
    }

    public void withdraw(Account account, double withdrawAmount){
        /*To withdraw money*/

        if (account.getAccountBalance() >= withdrawAmount){
            /*For check account has sufficient balance*/

            double newBalance = account.getAccountBalance()-withdrawAmount;
            account.setAccountBalance(newBalance);

            System.out.println("Your withdraw successful and new balance is: "+newBalance);

        }else {
            System.out.println("Not sufficient balance");
        }
    }

    public void deposit(Account account,double depositAmount){
        /*to deposit*/

        double newBalance = account.getAccountBalance()+depositAmount;
        account.setAccountBalance(newBalance);
        System.out.println("Your deposit is successful and your balance is: "+newBalance);
    }

    public void checkBalance(Account account){
        /*check balance*/

        double currentBalance = account.getAccountBalance();
        System.out.println("Your account balance is: "+currentBalance);
    }

    public void interestRate(Account account){
        /*get interest*/

        double currentInterest = account.getAccountBalance()*BankingApp.getDefaultInterestRate();
        System.out.println("Your account interest is: "+currentInterest);
    }

    public void transaction(Account account,Double amount,int receiversAccountNumber){
        /*Function for Transaction*/

        if (account.getAccountBalance() >= amount){
            /*For check account has sufficient balance*/

            Account receiverAccount = getAccountByID(receiversAccountNumber);

            if (receiverAccount == null){
                /*check there is receivers account*/

                System.out.println("Is there no receiver's account");

            }else {
                double newBalance = account.getAccountBalance()-amount;
                account.setAccountBalance(newBalance);

                double receiversAccountBalance = receiverAccount.getAccountBalance()+amount;
                receiverAccount.setAccountBalance(receiversAccountBalance);

                TransactionHistory transactionHistory = new TransactionHistory();

                transactionHistory.setSender(account);
                transactionHistory.setAmount(amount);
                transactionHistory.setreceiver(receiverAccount);
                BankingApp.addTransactionHistory(transactionHistory);

                System.out.println("Your transaction is successful and your currently account balance is:" +newBalance);
            }
        }else {
            System.out.println("Not sufficient balance for this transaction");
        }

    }

    public void showTransactionHistory(){
        /*To show transaction history*/

        System.out.println("Your transaction history is:\n");
        ArrayList<TransactionHistory> transactionHistoryList = BankingApp.getTransactionHistory();
        for (TransactionHistory transactionHistory : transactionHistoryList){
            String message = transactionHistory.getSender().getAccountName()
                    +" send "
                    + transactionHistory.getAmount()
                    + " to "
                    + transactionHistory.getReceiver().getAccountName();
            System.out.println(message );
        }
    }
}
