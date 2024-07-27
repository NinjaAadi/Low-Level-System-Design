

/*
    Name: Factory Desing pattern
    Type: Creational design pattern
    Use: When I need flexibility or need something where the functionality should be same, but the type should be different.
    Use: When the object creation is complex, there should be one class that should create that.
    Real life example: Logistics.
    Suppose we have a logicstics service. The client should not know about the logicstics mechanism, it should be decided on runtime, what logicstics to use
    Scenario 1: Short distance -> By Truck
    Scenario 2: Mid distance -> By ships
    Scenario 3: Long distance -> By flight

    Example 2:
    Payment system
    For payments, we can either use cards, or bank transfer, or crypto

    Class diagram
    Creator interface
    We have a factory that returns the payment object  (Concrete creator)

    Product interface
    Concrete product interface
*/

import java.util.HashMap;


//Product
interface PaymentProcessor{
    Boolean processPayment(int amount,Data clienData);
}

//This is an extension
class RAZORPayAPI{
    void processPayment(Data d){
        //Pick up from queue
        //try for payement
        //success -> update with success messege
        //failure -> update with failure messege
    }
    void processRefund(Data d){

    }
}


//Concrete product
class CreditCardPaymentProcessor implements PaymentProcessor{

    @Override
    public Boolean processPayment(int amount,Data clienData){
        /*
         * 
         * queue.addPaymentToQueue(new Request(amoutn,clientData))
         */
        return true;
    }
}

class DebitCardPaymentProcessor implements PaymentProcessor{
    @Override
    public Boolean processPayment(int amount, Data clientData){
        return true;
    }
}

//Factory
interface PaymentGateway{
    public PaymentProcessor getPaymentProcessor(PaymentMethods paymentMode);
}

//Concrete factory
class CompanyPaymentGateway implements PaymentGateway{

    @Override
    public PaymentProcessor getPaymentProcessor(PaymentMethods paymentMode) {
        switch (paymentMode) {
            case PaymentMethods.CREDIT_CARD:
                return new CreditCardPaymentProcessor();
            case PaymentMethods.DEBIT_CARD:
                return new DebitCardPaymentProcessor();
            default:
                return null;
        }
        
    }

}
class Data{
        String name;
        String credit_card_number; 
        int cvv;
        PaymentMethods paymentMethod;
        String callBackURL;
        Data(HashMap<String,Object> _data){
            name = (String) _data.get("name");
            credit_card_number = (String) _data.get("credit_card_number");
            cvv = (int) _data.get("cvv");
            paymentMethod = (PaymentMethods) _data.get("payment_method");
            callBackURL = (String) _data.get("callback_url");
        }
}
public class FactoryPattern{
    public static void main(String args[]){

        //Data from view 
        HashMap<String,Object> clientMapData = new HashMap<>();
        clientMapData.put("name", "Aaditya Pal");
        clientMapData.put("credit_card_number","1231232322323");
        clientMapData.put("cvv",123);
        clientMapData.put("payment_method",PaymentMethods.CREDIT_CARD);
        clientMapData.put("callback_url","https://mycallbackurl.com");
        Data clientData = new Data(clientMapData);



        //Service
        PaymentProcessor clientPaymentProcessor = new CompanyPaymentGateway().getPaymentProcessor(clientData.paymentMethod);

        
        //Process payment
        clientPaymentProcessor.processPayment(200,clientData);
    }
}

enum PaymentMethods{
    CREDIT_CARD,
    DEBIT_CARD,
    CRYPTO,
    BANK_TRANSFER   
}
