package org.example;

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
}
