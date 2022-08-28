package org.example;

public class TransactionHistory {

    private Account sender;

    private  double amount;

    private Account receiver;

    public Account getSender() {
        return this.sender ;
    }

    public void setSender(Account sender) {
        this.sender = sender;
    }

    public double getAmount() {
        return this.amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Account getReceiver() {
        return this.receiver;
    }

    public void setreceiver(Account receiver) {
        this.receiver = receiver;
    }
}
