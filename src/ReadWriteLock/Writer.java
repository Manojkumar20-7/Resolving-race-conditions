package ReadWriteLock;

public class Writer implements Runnable{
    private final SharedData sharedData;

    public Writer(SharedData sharedData){
        this.sharedData=sharedData;
    }

    public void run(){
        for(int i=0;i<5;i++){
            sharedData.writeData(i*10);
            try{
                Thread.sleep(1200);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
