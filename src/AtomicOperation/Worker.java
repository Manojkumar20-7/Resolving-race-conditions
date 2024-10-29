package AtomicOperation;

public class Worker implements Runnable{
    private final Counter counter;

    public Worker(Counter counter){
        this.counter=counter;
    }
    public void run(){
        for(int i=0;i<10;i++){
            counter.increment();
        }
    }
}
