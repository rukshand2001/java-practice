package org.example;

import java.util.Scanner;


public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    Utils utils = new Utils();

    public void mainUI(){
        /* This is the main UI */

        while (true) {

            System.out.println("\n\n***************************************");
            System.out.println("-------BANKING APP-------");
            System.out.println("*****************************************\n\n");
            System.out.println("Press 1 to Logging to App");
            System.out.println("Press 2 to Create Account");
            System.out.println("Press 3 to get transaction history");
            System.out.println("Press 4 to  Exit");

            System.out.print("\nPlease enter your choice : ");
            int choice = this.scanner.nextInt();

            if (choice == 1) {
                this.loggingUI();

            } else if (choice == 2) {
                this.createYourAccountUI();

            } else if (choice == 3) {
                this.utils.showTransactionHistory();

            } else if (choice == 4) {
                System.exit(0);
            }
            else {
                    System.out.println("\nYour enter wrong input.Please enter correct choice\n");
                }
        }
    }

    public void createYourAccountUI(){
        /*Create Account*/

        Account newAccount = new Account();

        System.out.println("\n***************************************");
        System.out.println("-------BANKING APP-------");
        System.out.println("*****************************************\n\n");


        System.out.println("\n--Create Your Account--\n");
        System.out.print("Enter Your Name : ");
        String holdersName = this.scanner.next();

        System.out.print("Enter Your Initial Balance : ");
        double initialBalance = this.scanner.nextDouble();

        int accountNumber = BankingApp.getAccounts().size()+1;

        newAccount.setAccountName(holdersName);
        newAccount.setAccountNumber(accountNumber);
        newAccount.setAccountBalance(initialBalance);
        newAccount.setInterestRate(BankingApp.getDefaultInterestRate());

        BankingApp.addAccounts(newAccount);
        System.out.println("\nYour account number is: "+accountNumber);

    }

    public void loggingUI(){
        /*Logging to Account*/

        System.out.print("\n Enter your account number : ");
        int accountNumber = this.scanner.nextInt();

         Account account = this.utils.getAccountByID(accountNumber);

        if(account==null){
            System.out.println("Please enter valid account number");
        }else {
            BankingApp.setCurrentAccountUser(account);
            System.out.println("\n***************************************");
            System.out.println("-------BANKING APP-------");
            System.out.println("*****************************************\n\n");
            System.out.println("Welcome "
                    +account.getAccountName()
                    +". Account number: "
                    +account.getAccountNumber()+"\n");
            accountLoggedUI();
        }
    }

    public void accountLoggedUI(){
        /*to do banking works with accounts*/

        boolean loggedIn = true;
        Account userAccount = BankingApp.getCurrentAccountUser();

        while (loggedIn){

            System.out.println("Press 1 to withdraw money");
            System.out.println("Press 2 to deposit money");
            System.out.println("press 3 to get balance");
            System.out.println("pres 4 to get your account interest");
            System.out.println("press 5 to do transaction");
            System.out.println("press 6 to exit\n");

            System.out.print("Enter your choice: ");
            int choice =this.scanner.nextInt();

            switch (choice){
                case 1:
                    System.out.print("Enter your withdraw amount: ");
                    double withdrawAmount = this.scanner.nextDouble();
                    this.utils.withdraw(userAccount,withdrawAmount);
                    break;
                case 2:
                    System.out.print("Enter your deposit amount: ");
                    double depositAmount = this.scanner.nextDouble();
                    this.utils.deposit(userAccount,depositAmount);
                    break;
                case 3:
                    this.utils.checkBalance(userAccount);
                    break;
                case 4:
                    this.utils.interestRate(userAccount);
                    break;
                case 5:
                    System.out.print("Enter receiver's  account number: ");
                    int inputReceiverAccountNumber = scanner.nextInt();
                    System.out.println("Enter amount: ");
                    double inputAmount = scanner.nextDouble();
                    this.utils.transaction(userAccount,inputAmount,inputReceiverAccountNumber);
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
