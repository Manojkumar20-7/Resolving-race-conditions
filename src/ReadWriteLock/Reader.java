package ReadWriteLock;

public class Reader implements Runnable{
    private final SharedData sharedData;

    public Reader(SharedData sharedData){
        this.sharedData=sharedData;
    }

    public void run(){
        for(int i=0;i<5;i++){
            sharedData.readData();
            try{
                Thread.sleep(1000);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
