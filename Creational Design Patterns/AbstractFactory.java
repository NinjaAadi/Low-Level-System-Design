

/*
    Name: Abstract Factory Desing pattern
    Type: Creational design pattern
    Use: Sits above factory pattern, when one factory is not enough
    Use: When we want to create objects on run time and is grouped by some common logic.
    
    I extend this for factory pattern
    Suppose for Credit card, I need to also have a refund service
    And same for Debit card, I also need to have a refund service

    In factory method, I can do is send type as payment mode, and process payment and process refund, but that is not the correct way to do that
    because that violates the single responsibility principle and open close principle

    What we can do is we can create another factory of refund and a abstract factory for credit card service and debit card service
*/

import java.util.HashMap;


//Product
interface PaymentProcessor{
    Boolean processPayment(int amount,Data clientData);
}
interface RefundProcessor{
    Boolean processRefund(int amount,Data clientData);
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
         * queue.addPaymentToQueue(new Request(amount,clientData))
         */
        return true;
    }
}
class CreditCardRefundProcessor implements RefundProcessor{

    @Override
    public Boolean processRefund(int amount, Data clientData) {
        /*
         * 
         * queue.addRefundRequestToQueue(new Request(amount,clientData);
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
class DebitCardRefundProcessor implements RefundProcessor{

    @Override
    public Boolean processRefund(int amount, Data clientData) {
        return true;
    }
    
}

//Factory
interface PaymentGateway{
    public PaymentProcessor getPaymentProcessor(PaymentMethods paymentMode);
}
interface RefundGateway{
    public RefundProcessor getRefundProcessor(PaymentMethods paymentMode);
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
class CompanyRefundGateway implements RefundGateway{

    @Override
    public RefundProcessor getRefundProcessor(PaymentMethods paymentMode) {
        switch (paymentMode) {
            case PaymentMethods.CREDIT_CARD:
                return new CreditCardRefundProcessor();
            case PaymentMethods.DEBIT_CARD:
                return new DebitCardRefundProcessor();
            default:
                return null;
        }
    }
    
}
interface PaymentFactory{
    PaymentProcessor getPaymentGatewayObject(PaymentMethods paymentMode);
    RefundProcessor getRefundGatewayObject(PaymentMethods paymentMode);
}
//Factory of the factories
class CompanyPay implements PaymentFactory{

    @Override
    public PaymentProcessor getPaymentGatewayObject(PaymentMethods paymentMode) {
        return new CompanyPaymentGateway().getPaymentProcessor(paymentMode);
    }

    @Override
    public RefundProcessor getRefundGatewayObject(PaymentMethods paymentMode) {
        return new CompanyRefundGateway().getRefundProcessor(paymentMode);
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
public class AbstractFactory{
    public static void main(String args[]){

        //Data from view 
        HashMap<String,Object> clientMapData = new HashMap<>();
        clientMapData.put("name", "Aaditya Pal");
        clientMapData.put("credit_card_number","1231232322323");
        clientMapData.put("cvv",123);
        clientMapData.put("payment_method",PaymentMethods.CREDIT_CARD);
        clientMapData.put("callback_url","https://mycallbackurl.com");
        Data clientData = new Data(clientMapData);


        //Now I want a payment service
        PaymentProcessor clientPaymentProcessor = new CompanyPay().getPaymentGatewayObject((PaymentMethods)clientMapData.get("payment_method"));

        //Process payment
        clientPaymentProcessor.processPayment(200,clientData);

        //Now I want a refund service
        RefundProcessor clientRefundProcessor = new CompanyPay().getRefundGatewayObject((PaymentMethods)clientMapData.get("payment_method"));
        clientRefundProcessor.processRefund(200, clientData);
    }
}

enum PaymentMethods{
    CREDIT_CARD,
    DEBIT_CARD,
    CRYPTO,
    BANK_TRANSFER   
}

