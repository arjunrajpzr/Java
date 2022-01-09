package com.arjun.business;

public class Transaction {

    private int transactionId;
    private double transactionValue;
    private com.arjun.Transaction type;

    public Transaction(int transactionId, double transactionValue, com.arjun.Transaction type) {
        this.transactionId = transactionId;
        this.transactionValue = transactionValue;
        this.type = type;
    }

    public Transaction() {

    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public double getTransactionValue() {
        return transactionValue;
    }

    public void setTransactionValue(double transactionValue) {
        this.transactionValue = transactionValue;
    }

    public com.arjun.Transaction getType() {
        return type;
    }

    public void setType(com.arjun.Transaction type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", transactionValue=" + transactionValue +
                ", type=" + type +
                '}';
    }
}
