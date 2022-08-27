package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class BankingApp {

    private static ArrayList<Account> accounts = new ArrayList<Account>();
    private static final double INTEREST_RATE = 0.1;


    public static void main(String[] args) {

        BankingApp bankingApp = new BankingApp();
        bankingApp.mainUI();

    }

    public void mainUI(){
        /* This is the main UI */

        Scanner scanner =new Scanner(System.in);

        System.out.println("\n***************************************");
        System.out.println("-------BANKING APP-------");
        System.out.println("*********************************\n\n");

        while (true){

            System.out.println("Press 1 to Logging to App");
            System.out.println("Press 2 to Create Account");
            System.out.println("Press 3 to  Exit");

            System.out.print("\nPlease enter your choice : ");
            int choice = scanner.nextInt();

            if(choice == 1){
                this.loggingUI(scanner);

            } else if (choice == 2) {
                this.createYourAccountUI(scanner);

            } else if (choice == 3) {
                System.exit(0);
            }else {
                System.out.println("\nYour enter wrong input.Please enter correct choice\n");
            }
        }
    }

    public void createYourAccountUI(Scanner scanner){
        /*Create Account*/

        Account newAccount = new Account();


        System.out.println("\nCreate Your Account\n");
        System.out.print("Enter Your Name : ");
        String holdersName = scanner.next();

        System.out.print("Enter Your Initial Balance : ");
        double initialBalance = scanner.nextDouble();

        int accountNumber = BankingApp.accounts.size()+1;

        newAccount.setAccountName(holdersName);
        newAccount.setAccountNumber(accountNumber);
        newAccount.setAccountBalance(initialBalance);
        newAccount.setInterestRate(BankingApp.INTEREST_RATE);

        BankingApp.accounts.add(newAccount);
        System.out.println("Your account number is: "+accountNumber);

    }

    public void loggingUI(Scanner scanner){
        /*Logging to Account*/

        System.out.print("\n Enter your account number : ");
        int accountNumber = scanner.nextInt();

        Account account = getAccountByID(accountNumber);

        if(account==null){
            System.out.println("Please enter valid account number");
        }else {
            System.out.println("Welcome " +account.getAccountName()+". Account number: "+account.getAccountNumber());
        }


    }

    public Account getAccountByID(int accountNumber){
        /*This function use to get account from account number*/

        for (Account account : BankingApp.accounts){
            if(account.getAccountNumber()==accountNumber){
                return account;
            }
        }
        return null;
    }

    public void accountLoggedUI(int accountNumber,Scanner scanner){
        /*to do banking works with accounts*/


        boolean loggedIn = true;

        while (loggedIn){
            System.out.println("Press 1 to withdraw money");
            System.out.println("Press 2 to deposit money");
            System.out.println("press 3 to get balance");
            System.out.println("pres 4 to get your account interest");
            System.out.println("press 5 to do transaction");
            System.out.println("press 6 to exit");

            System.out.print("Enter your choice: ");
            int choice =scanner.nextInt();
            Account accountUINew = new Account();

            switch (choice){
                case 1:
                    System.out.print("Enter your withdraw amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    break;
                case 2:
                    System.out.print("Enter your deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    break;
                case 3:
                    //Account accountBalanceAccountNumber = getAccountByID(accountNumber);
                    //Account accountBalanceCurrentAccount = get
                    System.out.print("Your current balance is: ");
                    break;
                case 4:
                    System.out.print("Your currently interest is: ");
                    break;
                case 5:
                    System.out.print("Receiver's  account number & amount: ");
                    break;
                case 6:
                    loggedIn = false;
                    break;
                default:
                    System.out.println("You have entered a wrong choice. Please check your choice");
            }
        }
    }
}
