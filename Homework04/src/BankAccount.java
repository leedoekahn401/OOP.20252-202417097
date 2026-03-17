package Homework04.src;

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
        if(newName.isEmpty()){
            System.err.println("Name must not be empty");
            return;
        }
        this.name = newName;
    }

    public double getBalance(){
        return this.balance;
    }

    public void printBalance(){
        System.out.println(this.name+"'s Balance: "+this.balance);
        return;
    }


    public void deposit(double amount) {
        if (amount <= 0) {
            System.err.println("Deposit amount must be greater than 0");
            return;
        }
        this.balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.err.println("Withdraw amount must be greater than 0");
            return;
        }
        if (balance - amount < MINIMUM_BALANCE) {
            System.err.println("Balance must not below 50000");
            return;
        }
        this.balance -= amount;
    }

    public void transfer(BankAccount receiver, double amount){
        if(amount <= 0){
            System.err.println("Transfer amount must be greater than 0");
            return;
        }
        if(balance - amount - amount*TRANSFER_FEE < MINIMUM_BALANCE){
            System.err.println("Balance must not below 50000");
            return;
        }
        this.balance -= amount + amount*TRANSFER_FEE;
        receiver.deposit(amount);
        System.out.println("Transaction success"+"\nSender: "+ this.name+"\nReceiver: "+receiver.getName()+"\nTransfer Amount: "+amount);
    }
    public void payBill(String billName, double amount ){
        if(amount <= 0){
            System.err.println("Transfer amount must be greater than 0");
            return;
        }
        if(balance - amount < MINIMUM_BALANCE){
            System.err.println("Balance must not below 50000");
            return;
        }
        this.balance -= amount;
        System.out.println("Pay "+amount+" for "+billName);
    }
}
