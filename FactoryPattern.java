


//Factory patter is used to encapsulate the building logic from client and is to be used
//when an object creation is relied upon multiple objects

//Product
abstract class Burger{
    String name;
    Burger(String name){
        this.name = name;
    }
    void printDescription(){
        System.out.println("This is a " + name);
    }
}
interface Ingredients{}
class Chicken implements Ingredients{};
class Mutton implements Ingredients{};
class Patte implements Ingredients{};


//Concrete product
class ChickenBurger extends Burger{
    ChickenBurger(Chicken c,Patte p) {
        super("Chicken burger");
    }
}

//Concrete product
class MuttonBurger extends Burger{
    MuttonBurger(Mutton c,Patte p) {
        super("Mutton burger");
    }
}
//Creator
interface BurgerFactory{
    Burger createBurger();
}

//Concrete creator
class ChickenBurgerFactory implements BurgerFactory{
    @Override
    public Burger createBurger() {
        return new ChickenBurger(new Chicken(),  new Patte());
    }
}
class MuttonBurgerFactory implements BurgerFactory{
    @Override
    public Burger createBurger(){
        return new MuttonBurger(new Mutton(), new Patte());
    }
}

//Client
class Restaurant{
    public Burger getBurger(BurgerFactory b){
        return b.createBurger();
    }
}
public class FactoryPattern{
    public static void main(String args[]){
        Restaurant r = new Restaurant();
        Burger b = r.getBurger(new ChickenBurgerFactory());
        b.printDescription();
    }
}