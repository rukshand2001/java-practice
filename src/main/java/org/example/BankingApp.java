package org.example;

import java.util.ArrayList;

public class BankingApp {

    private static Account currentAccountUser = null;

    private static final ArrayList<Account> accounts = new ArrayList<Account>();
    private static final double INTEREST_RATE = 0.1;

    public static ArrayList<Account> getAccounts() {
        return accounts;
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
