package Semaphores;

public class Customer implements Runnable{
    private final Gym gym;
    private final String name;

    public Customer(Gym gym, String name){
        this.gym=gym;
        this.name=name;
    }
    public void run(){
        gym.useMachines(name);
    }
}
