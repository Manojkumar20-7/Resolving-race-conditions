package ReadWriteLock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SharedData {
    private int data;
    private final ReentrantReadWriteLock lock=new ReentrantReadWriteLock();

    public void readData(){
        lock.readLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+" is reading the data: "+data);
        }
        finally{
            lock.readLock().unlock();
        }
    }

    public void writeData(int newData){
        lock.writeLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+" is writing the data: "+newData);
            data=newData;
        }
        finally{
            lock.writeLock().unlock();
        }
    }
}
