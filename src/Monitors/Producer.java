package Monitors;

public class Producer implements Runnable {
    private final Buffer buffer;

    public Producer(Buffer buffer){
        this.buffer=buffer;
    }

    public void run(){
        int item=0;
        try{
            while(true){
                buffer.produce(item++);
                Thread.sleep(1000);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
