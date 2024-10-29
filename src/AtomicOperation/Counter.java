package AtomicOperation;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    private AtomicInteger count=new AtomicInteger(0);
    private int count1=0;

    public void increment(){
        count.incrementAndGet();
        count1++;
    }

    public int getCount(){
        return count.get();
    }

    public int getCount1(){
        return count1;
    }
}
