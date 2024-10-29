package ReadWriteLock;

public class Main {
    public static void main(String[] args) {
        SharedData sharedData = new SharedData();

        Thread r1=new Thread(new Reader(sharedData),"Reader1");
        Thread r2=new Thread(new Reader(sharedData),"Reader2");
        Thread r3=new Thread(new Reader(sharedData),"Reader3");
        Thread w=new Thread(new Writer(sharedData),"Writer");

        r1.start();
        r2.start();
        r3.start();
        w.start();

        try{
            r1.join();
            r2.join();
            r3.join();
            w.join();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
