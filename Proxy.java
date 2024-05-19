class User{
    String name;
    int age;
}
interface EmployeeDao{
    void create(User user);
    void delete(User user);
}
class EmployeeDaoImpl implements EmployeeDao{
    @Override
    public void create(User user){
        System.out.println("User created");
    }
    @Override
    public void delete(User user){
        System.out.println("User deleted");
    }
}
enum Role{
    ADMIN,
    USER
}
class EmployeeProxy implements EmployeeDao{

    Role r;
    EmployeeDao e = new EmployeeDaoImpl();
    EmployeeProxy(Role role){
        r = role;
    }
    @Override
    public void create(User user){
        if(r == Role.ADMIN){
            e.create(user);
        }
        else System.out.println("Access denied");
    }
    @Override
    public void delete(User user){
        if(r == Role.ADMIN){
            e.delete(user);
        }
        else System.out.println("Access denied");
    }
}
public class Proxy{
    public static void main(String args[]){
        EmployeeDao e = new EmployeeProxy(Role.ADMIN);
        e.create(new User());
        EmployeeDao ee = new EmployeeProxy(Role.USER);
        ee.create(new User());
    }
}