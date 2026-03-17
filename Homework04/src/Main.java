package Homework04.src;

public class Main {
    public static void main(String[] args){
        BankAccount account1 = new BankAccount("MB100","Duc Anh" , 150000);
        BankAccount account2 = new BankAccount("MB101","Dang Duong" , 100000);

        account1.deposit(20000);
        account1.printBalance();
        account1.deposit(0);
        account1.printBalance();

        account2.withdraw(10000);
        account2.printBalance();
        account2.withdraw(1000000);
        account2.printBalance();

        account1.transfer(account2, 30000);
        account1.printBalance();
        account2.printBalance();

        account1.transfer(account2, 15000);
        account1.printBalance();
        account2.printBalance();

        account2.payBill("Electricity Bill", 20000);

        account1.printBalance();
        account2.printBalance();



    }
}
