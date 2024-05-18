
//Design a coffee machine expresso capechino latte -> extra milk sugar -> extra coffee
//Design a pizza machine -> pizza -> toppings -> cheese,mushroom -> cake etc.


interface Coffee{
    void printDescription();
    int getCost();
}
abstract class Toppings implements Coffee{
    private Coffee c;
    int cost;
    Toppings(Coffee _c,int _cost){
        this.c = _c;
        cost = _cost;
    }
    @Override
    public int getCost(){
        return c.getCost() + cost;
    }
    public void printDescription(){
        c.printDescription();
    };
}
class Sugar extends Toppings{
    Sugar(Coffee c){
        super(c,20);
    }

    @Override
    public void printDescription() {
        System.out.println("Sugar");
        super.printDescription();
    }

}
class Expresso implements Coffee{
    int cost = 20;
    @Override
    public void printDescription() {
        System.out.println("Expresso");
    }
    public int getCost(){
        return this.cost;
    }
}
public class DecoratorPattern {
    public static void main(String args[]){
        Coffee e = new Expresso();
        e.printDescription();
        System.out.println(e.getCost());

    }
}
