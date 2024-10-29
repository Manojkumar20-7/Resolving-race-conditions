package Semaphores;

import java.util.concurrent.Semaphore;

public class Gym {
    private final Semaphore machines;

    public Gym(int noOfMachines){
        machines=new Semaphore(noOfMachines);
    }

    public void useMachines(String name){
        try{
            System.out.println(name+" is waiting to use the machine");
            machines.acquire();
            System.out.println(name+" is using a machine");
            Thread.sleep(2000);
            System.out.println(name+" is done using the machine");
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            machines.release();
        }
    }
}