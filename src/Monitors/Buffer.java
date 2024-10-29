package Monitors;

import java.util.LinkedList;
import java.util.Queue;

public class Buffer {
    private int capacity;
    private Queue<Integer> queue=new LinkedList<>();

    public Buffer(int capacity){
        this.capacity=capacity;
    }

    public synchronized void produce(int item) throws Exception{
        while(queue.size()==capacity){
            System.out.println("Buffer is full. Producer is waiting...");
            wait();
        }
        queue.add(item);
        System.out.println("Produced: "+item);
        notify();
    }

    public synchronized int consume() throws Exception{
        while(queue.isEmpty()){
            System.out.println("Buffer is empty. Consumer is waiting...");
            wait();
        }

        int item=queue.poll();
        System.out.println("Consumed: "+item);
        notify();
        return item;
    }
}