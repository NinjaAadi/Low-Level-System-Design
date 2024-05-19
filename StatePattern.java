import java.util.ArrayList;

//In state design pattern we have a
/*
 *  State interface containing all the flow 
 *  Concrete states updating the value of the states
 *  The context class is responsible for updating the flow 
 * 
 */
interface MyObservable{
    void notifyall(State s);
    void addObserver(Observer e);
    void removeObserver(Observer e);
    public void changeState(State s);
    public State getVal();
}

interface Observer{
    void getNotified(State s);
}
interface State {
    void handle(MyObservable value);
}
// Define RedState class
class RedState implements State {
    @Override
    public void handle(MyObservable v) {
        System.out.println("Red Signal. Changing to yellow...");
        v.changeState(new YellowState());
    }
}

// Define GreenState class
class GreenState implements State {
    @Override
    public void handle(MyObservable v) {
        System.out.println("Green Signal. Changing to Red...");
       // v.changeState(new YellowState());
    }
}

// Define YellowState class
class YellowState implements State {
    @Override
    public void handle(MyObservable v) {
        System.out.println("Yellow Signal. Changing to Green...");
        v.changeState(new GreenState());
    }
}
class StopState implements State {
    @Override
    public void handle(MyObservable v) {
        System.out.println("Stopping Signal...");
        
    }
}
class ObserveValue implements MyObservable{
    ArrayList<Observer>observers;
    private State val = null;
    ObserveValue(State initState){
        observers = new ArrayList<Observer>();
        val = initState;
        changeState(initState);
    }
    @Override
    public void changeState(State s){
       
        if(s!=val) notifyall(s);
        val = s;
    }
    @Override
    public void notifyall(State s) {
        for(Observer i : observers){
            i.getNotified(s);
        }
    }
    @Override 
    public State getVal(){
        return val;
    }
    @Override
    public void addObserver(Observer e) {
        observers.add(e);
    }

    @Override
    public void removeObserver(Observer e) {
       observers.remove(e);
    }
    
} 

class TrafficLight implements Observer{ 
    MyObservable state;
    TrafficLight(){
    }
    void start(){
        state = new ObserveValue(null);
        state.addObserver(this);
        state.changeState(new RedState());
 
    }
    void stop(){
        state.changeState(new StopState());
        state.removeObserver(this);
    }
    @Override 
    public void getNotified(State s) {
        s.handle(state);
    }
}
public class StatePattern{
    public static void main(String args[]){
        TrafficLight t = new TrafficLight();
        t.start();
        t.stop();
    }
}