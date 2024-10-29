package AtomicOperation;

public class Main {
    public static void main(String[] args) throws Exception {
        Counter counter = new Counter();
        
        Thread t1= new Thread(new Worker(counter));
        Thread t2= new Thread(new Worker(counter));
        Thread t3= new Thread(new Worker(counter));


        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("Final count value: "+counter.getCount());
        System.out.println("Final count1 value: "+counter.getCount1());
    }
}
