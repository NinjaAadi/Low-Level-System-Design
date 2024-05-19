
class Computer{
    private int ram;
    private int hdd;
    private Computer(ComputerBuilder b){
        ram = b.ram;
        hdd = b.hdd;
        isBluetoothEnabled = b.isBluetoothEnabled;
        isGraphicsEnabled = b.isGraphicsEnabled;
    }
    //Optional parameters
    boolean isGraphicsEnabled;
    boolean isBluetoothEnabled;

    int getRam(){
        return ram;
    }
    int getHdd(){
        return hdd;
    }
    boolean isGraphicsCardEnabled(){
        return isGraphicsEnabled;
    }
    boolean isBluetoothCardEnabled(){
        return isBluetoothEnabled;
    }
    public static class ComputerBuilder{
        private int ram;
        private int hdd;
        
        //Optional fields
        private boolean isBluetoothEnabled;
        private boolean isGraphicsEnabled;
        ComputerBuilder(int ram,int hdd){
            this.ram = ram;
            this.hdd = hdd;
        }
        public ComputerBuilder enableBluetooth(){
            isBluetoothEnabled = true;
            return this;
        }
        public ComputerBuilder enableGraphics(){
            isGraphicsEnabled = true;
            return this;
        }
        public Computer build(){
            return new Computer(this);
        }
    }
}
public class Builder{
    public static void main(String args[]){
        Computer c = new Computer.ComputerBuilder(10, 10)
            .enableBluetooth()
            .build();
        System.out.println(c.isBluetoothEnabled);
    }
}