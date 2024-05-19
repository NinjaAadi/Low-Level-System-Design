/*
 * Adaptor pattern is basically when there is an incompatible system, basically adaptee, 
 * which needs to be adapted. So we introduce a adaptor class which has a relationship with the 
 * adaptee class
 */

class LegacyPrinter{
    void print(){
        System.out.println("Legacy printer printing...");
    }
}
interface PrinterAdaptor{
    void print();
}
class Adaptor implements PrinterAdaptor{
    LegacyPrinter lp;
    Adaptor(LegacyPrinter _lp){
        lp = _lp;
    }
    @Override
    public void print() {
        System.out.println("Doing some modification...");
        lp.print();
    }
    
}
public class AdaptorPattern{
    public static void main(String args[]){
        PrinterAdaptor p = new Adaptor(new LegacyPrinter());
        p.print();
    }
}