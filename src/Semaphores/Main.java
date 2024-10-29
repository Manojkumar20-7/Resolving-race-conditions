package Semaphores;

public class Main {
    public static void main(String[] args) {
        int machines=3;
        Gym gym = new Gym(machines);

        Thread[] customers=new Thread[10];
        for(int i=0;i<10;i++){
            customers[i]=new Thread(new Customer(gym,"Customer-"+(i+1)));
        }
        for(Thread customer:customers){
            customer.start();
        }
        for(Thread customer:customers){
            try{
                customer.join();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        System.out.println("All customers are done using the machines");
    }
}
