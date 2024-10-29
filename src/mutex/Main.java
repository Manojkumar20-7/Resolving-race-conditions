package mutex;

public class Main {
    public static void main(String[] args) {
        BankAccount account=new BankAccount(1000);

        Thread t1=new Thread(()->{
            account.deposit(200);
            account.withdraw(150);
        },"Thread1");
        Thread t2=new Thread(()->{
            account.deposit(300);
            account.withdraw(400);
        },"Thread2");
        Thread t3=new Thread(()->{
            account.deposit(500);
            account.withdraw(600);
        },"Thread3");

        t1.start();
        t2.start();
        t3.start();

        try{
            t1.join();
            t2.join();
            t3.join();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("Final balance: "+account.getBalance());
    }
}
