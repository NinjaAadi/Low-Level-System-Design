import java.util.ArrayList;
import java.util.List;

public class PrototypePattern{
    public static void main(String args[]){
        List<Integer>payments = new ArrayList<>();
        payments.add(10);
        payments.add(20);
        Dependency depenceny = new Dependency("Aaditya",payments);

        depenceny.print();
        Dependency depencencyClone = (Dependency) depenceny.clone();
        depencencyClone.print();
    }
}

 
interface Prototype{
    Prototype clone();
}
class Dependency implements Prototype{
    private String name;
    private List<Integer>payments;

    Dependency(String _name,List<Integer>_payments){
        name = _name;
        
        //Deep copy
        payments = new ArrayList<>();
        for(Integer items : _payments){
            int it = items;
            payments.add(it);
        }
    }
    @Override
    public Prototype clone(){
        return new Dependency(name,payments);
    }
    public void print(){
        for(Integer item : payments){
            System.out.print(item + ",");
        }
        System.out.println("");
    }
}

