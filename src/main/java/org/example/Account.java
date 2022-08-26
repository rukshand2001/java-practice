package org.example;

public class Account {
    private int accountNumber;
    private String accountName;
    private  double accountBalance;
    private double interestRate ;



    public  double getAccountBalance(){
        return this.accountBalance;
    }
    public double getInterestRate(){
        return  this.interestRate;
    }
    public String getAccountName(){
        return this.accountName;
    }
    public int getAccountNumber(){
        return this.accountNumber;
    }



    public void  setAccountNumber(int newAccountNumber){
        this.accountNumber = newAccountNumber;
    }
    public void setAccountName(String newAccountHolderName){
        this.accountName = newAccountHolderName;
    }
    public void setAccountBalance(double newAccountBalance){
        this.accountBalance = newAccountBalance;
    }
    public void  setInterestRate(double newInterestRate){
        this.interestRate = newInterestRate;
    }
}
