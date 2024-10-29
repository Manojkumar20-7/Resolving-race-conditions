package mutex;

import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private double balance;
    private final ReentrantLock lock=new ReentrantLock();

    public BankAccount(double initialBalance){
        this.balance=initialBalance;
    }

    public void deposit(double amount){
        lock.lock();
        try{
            balance+=amount;
            System.out.println(Thread.currentThread().getName()+" deposited :"+amount+". Current balance: "+balance);
        }
        finally{
            lock.unlock();
        }
    }

    public void withdraw(double amount){
        lock.lock();
        try{
            if(amount<=balance){
                balance-=amount;
                System.out.println(Thread.currentThread().getName()+" withdrew "+amount+". Current balance: "+balance);
            }
            else{
                System.out.println(Thread.currentThread().getName()+" tries to withdraw "+amount+" but insufficient balance");
            }
        }
        finally{
            lock.unlock();
        }
    }

    public double getBalance(){
        lock.lock();
        try{
            return balance;
        }
        finally{
            lock.unlock();
        }
    }
}