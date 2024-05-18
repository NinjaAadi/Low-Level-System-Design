
enum Level{
    LOW,
    MEDIUM,
    HIGH 
}
abstract class Request{
    Level level;
    Request(Level l){
        this.level = l;
    }
    abstract void process();
}
class SecurityRequest extends Request{
    public String requestName;
    SecurityRequest(String s,Level l){
        super(l);
        requestName = s;
    }
    @Override
    public void process() {
        System.out.println("Request \" " + requestName + "\" has been processed");
    }
    
} 
abstract class Handler{
    protected Handler nextHandler;
    protected Level canHandle;
    final void setNextHandler(Handler h){
        nextHandler = h;
    }
    final void setLevel(Level l){
        canHandle = l;
    }
    abstract void process(Request r);
}
class Handler1 extends Handler{
    Handler1(Handler nxt,Level canHandle){
        setNextHandler(nxt);
        setLevel(canHandle);
    }
    @Override
    void process(Request r) {
        if(r.level == canHandle){
            r.process();
        }
        else nextHandler.process(r);
    }
}
class Handler2 extends Handler{
    Handler2(Handler nxt,Level canHandle){
        setNextHandler(nxt);
        setLevel(canHandle);
    }
    @Override
    void process(Request r){
        if(r.level == canHandle){
            r.process();
        }
        else if(nextHandler == null){
            System.out.println("Cannot handle request...");
        }
        else nextHandler.process(r);
    }
}
public class ChainOfResponsibility{
    public static void main(String args[]){
        Handler h = new Handler1(new Handler2(null,Level.MEDIUM), Level.LOW);
        Request r = new SecurityRequest("Emergency",Level.LOW);
        h.process(r);
    }
}