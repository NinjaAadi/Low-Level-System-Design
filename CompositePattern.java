
//Tree like structure
abstract class Component{
    int size;
    String name;
    Component(String name){

    }
    
    abstract void showSize();
    abstract void showName();
    abstract void showCreatedDate();
}
interface Folder extends Components{

}
interface File extends Components{

}
public class CompositePattern{
    public static void main(String args[]){
        
    }
}