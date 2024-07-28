


/*
    Name: Decorator Pattern
    Type: Structural Design pattern
    Use: When there are lot of behaviour changes, and one behaviour could lead to another behaviour,
    Which means each and every class could be inherited to another classes
    For example there are classes c1, c2, c3..
    We want a behaviour c1c2
    We want a behaviour c2c3
    For each behaviour we cannot create classes
    So what we can do, is we try to make each class a base 

    Problem faced here
    You want to add behavior or state to individual objects at run-time. Inheritance is not feasible because it is static and applies to an entire class.
 */

interface Product{
    int getCost();
}
class ProductA implements Product{
    Product base;
    int cost;
    ProductA(){
        base = null;
        cost = 10;
    }
    ProductA(Product _b){
        base = _b;
    }
    @Override
    public int getCost() {
        int totalCost = cost;
        if(base != null) totalCost+=base.getCost();
        return totalCost;
    }

}

class Insurance implements Product{
    Product base;
    int cost;
    Insurance(){
        base = null;
        cost = 30;
    }
    Insurance(Product _b){
        base = _b;
    }
    @Override
    public int getCost() {
        int totalCost = cost;
        if(base != null) totalCost+=base.getCost();
        return totalCost;
    }
}
class SpeedDelivery implements Product{
    Product base;
    int cost;
    SpeedDelivery(){
        base = null;
        cost = 30;
    }
    SpeedDelivery(Product _b){
        base = _b;
    }
    @Override
    public int getCost() {
        int totalCost = cost;
        if(base != null) totalCost+=base.getCost();
        return totalCost;
    }
}

public class DecoratorPattern {
    Product newAmaoznProduct = new ProductA(new Insurance(new SpeedDelivery())); 
    Product newFlipkartProduct = new ProductA(new SpeedDelivery());
    int cost = newAmaoznProduct.getCost();
}
