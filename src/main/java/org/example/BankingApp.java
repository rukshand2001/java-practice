package org.example;

import java.util.ArrayList;

public class BankingApp {

    private static Account currentAccountUser = null;

    private static final ArrayList<Account> accounts = new ArrayList<Account>();

    private static final ArrayList<TransactionHistory> transactionHistory = new ArrayList<TransactionHistory>();

    public static ArrayList<TransactionHistory> getTransactionHistory(){
        return BankingApp.transactionHistory;
    }

    public static void addTransactionHistory(TransactionHistory transactionHistory){
        BankingApp.transactionHistory.add(transactionHistory);
    }

    private static final double INTEREST_RATE = 0.1;

    public static ArrayList<Account> getAccounts() {
        return BankingApp.accounts;
    }

    public static void addAccounts(Account account) {
        BankingApp.accounts.add(account);
    }

    public static double getDefaultInterestRate(){
        return BankingApp.INTEREST_RATE;
    }

    public static Account getCurrentAccountUser() {
        return BankingApp.currentAccountUser;
    }

    public static void setCurrentAccountUser(Account account){
        BankingApp.currentAccountUser = account;
    }

    public static void main(String[] args) {

        UserInterface userInterface = new UserInterface();
        userInterface.mainUI();

    }
}
