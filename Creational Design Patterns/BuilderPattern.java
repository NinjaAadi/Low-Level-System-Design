/*
    Name: Builder Pattern
    Type: Creational Design pattern
    Use: When we want single object which have complex logic building.
    Use: When the order of building of the object can vary

 */
interface Computer{
    public void run();
    void increaseRam();
    public int getRam();
}
class Mac implements Computer{
    
    private int ram;
    private int hdd;
    private CPU cpu;
    private int core;

    Mac(int _ram,int _hdd,CPU _cpu,int _core){
        ram = _ram;
        hdd = _hdd;
        cpu = _cpu;
        core = _core;
    }
    @Override
    public int getRam(){
        return ram;
    }
    @Override
    public void increaseRam(){

    }
    @Override
    public void run(){
        //DO some stuff
    }
}
interface Builder{
    Computer build();
    Builder setRam(int _ram);
    Builder setCPU(CPU _cpu);
    Builder setCore(int _core);
    Builder setHDD(int _hdd);
}
class ComputerBuilder implements Builder{
    int ram;
    int hdd;
    CPU cpu;
    int core;
    @Override
    public Computer build() {
        return new Mac(ram,hdd,cpu,core);
    }

    @Override
    public Builder setRam(int _ram) {
        ram = _ram;
        return this;
    }

    @Override
    public Builder setCPU(CPU _cpu) {
        cpu = _cpu;
        return this;
    }

    @Override
    public Builder setCore(int _core) {
        core = _core;
        return this;
    }

    @Override
    public Builder setHDD(int _hdd) {
        hdd = _hdd;
        return this;
    }

}
public class BuilderPattern{
    public static void main(String args[]){
        Computer mac = new ComputerBuilder().
                            setCPU(CPU.INTEL).
                            setRam(1024).
                            setHDD(20).
                            build();
        mac.run();
    }
}
enum CPU{
    INTEL,
    ARM,
    X64
}