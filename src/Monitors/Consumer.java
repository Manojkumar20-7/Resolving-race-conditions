package Monitors;

public class Consumer implements Runnable{
    private final Buffer buffer;

    public Consumer(Buffer buffer){
        this.buffer=buffer;
    }

    public void run(){
        while(true){
            try{
                buffer.consume();
                Thread.sleep(1500);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
