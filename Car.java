package sample.Model;

public class Car {

    private final String name;
    private final Engine engine;
    private final Tank tank;
    private final Wheel wheel;

    public Car(String name) {
        this.name = name;
        this.engine = new Engine(13);
        this.tank = new Tank(50, 30, 10);
        this.wheel = new Wheel(5);
    }

    public boolean go(){
        if(tank.getFuel()>0){
            return true;
        }
        return false;
        //engine.startEngine(tank, wheel);
    }

    public Engine getEngine(){ return engine; }
    public Tank getTank(){ return tank; }
    public Wheel getWheel(){ return wheel; }
}
