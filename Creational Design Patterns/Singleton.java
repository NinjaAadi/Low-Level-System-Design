import java.util.ArrayList;

interface Repository{
    void add(int data);
    void delete(int data);
    ArrayList<Integer> getAllData();
}
class DB implements Repository{
    
    ArrayList<Integer>data;
    static Repository DBObject;


    private DB(){
        data = new ArrayList<>();
    }
    public static synchronized Repository getObject(){
        //Initialize 
        if(DBObject == null) DBObject = new DB();
        return DBObject;
    }
    @Override
    public void add(int _d){
        data.add(_d);
    }
    @Override
    public void delete(int _d){
        data.remove(_d);
    }
    @Override
    public ArrayList<Integer>getAllData(){
        return data;
    }
}

public class Singleton{
    public static void main(String args[]){
        Repository repo = DB.getObject();
        repo.add(0);
    }
}