
import java.util.*;

//In observer design pattern we have a observable we have a observers and we have product.
interface Observable<T>{
    T getData();
    void setData(T newData);
    void notifyall();
    void addObserver(Observer e);
    void removeObserver(Observer e);
}

//We have to set observable for a product
class ProductObservable <T>implements Observable<T>{
    T data;
    ArrayList<Observer>observers;
    @Override
    public T getData(){
        return data;
    }
    @Override
    public void setData(T newData){
        if(newData != data){
            notifyall();
        }

    }
    ProductObservable(T initialData){
        data = initialData;
        observers = new ArrayList<Observer>();
    }
    @Override
    public void addObserver(Observer e){
        observers.add(e);
    }
    @Override
    public void notifyall(){
        for(Observer e : observers){
            e.getNotified();
        }
    }
    public void removeObserver(Observer e){
        observers.remove(e);
    }
}

class Iphone<T>{

    private Observable<T> stock;
    private Iphone(){
        //Iphone will always need an observeable
    }
    Iphone(Observable<T> e){
        stock = e;
    }
    void change(T _stock){
        stock.setData(_stock);
    }
    T getStock(){
        return stock.getData();
    }
    void registerForNotification(Observer o){
        stock.addObserver(o);
    }
    void unregisterForNotification(Observer o){
        stock.removeObserver(o);
    }
}
interface Observer{
    public void getNotified();
}

class Device implements Observer{
    String device;
    Device(String name){
        device = name;
    }


    //This function will receive any change in value and we will implement the push notification
    @Override
    public void getNotified(){
        System.out.println(device + " is getting notified...");
    }
}
public class ObserverPattern{
    public static void main(String args[]){
        Observable<Integer> o = new ProductObservable<Integer>(0);
        Iphone<Integer>iphone = new Iphone<Integer>(o);
        
        Observer mobile = new Device("Aaditya's iphone");
        iphone.registerForNotification(mobile);
        iphone.change(100);
    }
}
