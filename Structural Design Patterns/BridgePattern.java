

/*
    Name: Bridge Pattern
    Type: Structural Pattern
    Use case:
    When two types can have subtypes, their subtypes can have new subtypes, and both are related to each other
    When we add a subtype to type B, we need to create linking for Type A as well.
    Example: We have ThreadScheduler
    We can have different types of thread scheduler like , preemtive, fcfs, priority based.
    We can have different operating system for that
    So if we make classes for each
    threadSchedulerPremtiveWindows
    thredSchedulerPremtiveMac
    threadSchedulerFcfcWindows
    threadSchedulerUNIX
    ..
    Now if we add another OS, then we need to make each class for each of the threadScheduler, so each and every class has "is a relationship"
    We need to have a bridge between both the catogaries, threadScheduler and Operating System


 */

abstract class OperatingSystem{
    ThreadScheduler threadScheduler;
    OperatingSystem(ThreadScheduler _ThreadScheduler){
        threadScheduler = _ThreadScheduler;
    }
    abstract void run();
    void scheduleTask(){
        threadScheduler.scheduleTask();
    }

}

class Windows extends OperatingSystem{

    Windows(ThreadScheduler _threadScheduler) {
        super(_threadScheduler);
    }
    @Override
    void run() {
        System.out.println("Windows is running\n");
    }
}
class Mac extends OperatingSystem{

    Mac(ThreadScheduler _ThreadScheduler) {
        super(_ThreadScheduler);
    }
    @Override
    void run() {
        System.out.println("Mac is running\n");
    }
    
}
abstract class ThreadScheduler{
    abstract void scheduleTask();
}
class FCFS extends ThreadScheduler{
    @Override
    void scheduleTask() {
       System.out.println("Scheduling task with fcfs");
    }
}
class PriorityBased extends ThreadScheduler{
    @Override
    void scheduleTask() {
       System.out.println("Scheduling task with fcfs");
    }
}
public class BridgePattern {
    public static void main(String args[]){
        ThreadScheduler fcfs = new FCFS();
        OperatingSystem macOs = new Mac(fcfs);
        macOs.scheduleTask();
        ThreadScheduler priorityBased = new PriorityBased()
        OperatingSystem windows = new Windows(priorityBased);
        windows.scheduleTask();
    }
}
