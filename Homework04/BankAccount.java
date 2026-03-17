package Homework04;

import java.util.HashMap;
import java.util.Map;

public class BankAccount {
    public static final double MINIMUM_BALANCE = 50000;
    public static final double TRANSFER_FEE = 0.02;

    private static Map<String, Boolean> idMap = new HashMap<>();

    private String id;
    private String name;
    private double balance;

    public BankAccount(String id, String name, double initialBalance) {
        if (idMap.containsKey(id)) {
            throw new IllegalArgumentException("ID must be unique");
        }
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name must not be empty");
        }
        if (initialBalance < MINIMUM_BALANCE) {
            throw new IllegalArgumentException("Initial balance cannot not be less than 50000");
        }
        this.id = id;
        this.name = name;
        this.balance = initialBalance;
        idMap.put(id, true);
    }

    
    public String getName(){
        return this.name;
    }

    public void setName(String newName){
        this.name = newName;
    }

    public double getBalance(){
        return this.balance;
    }


    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be greater than 0");
        }
        this.balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdraw amount must be greater than 0");
        }
        if (balance - amount < MINIMUM_BALANCE) {
            throw new IllegalArgumentException("Balance must not below 50000");
        }
        this.balance -= amount;
    }


}
