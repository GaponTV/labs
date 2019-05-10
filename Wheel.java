package sample.Model;

import sample.Controller;

import java.util.concurrent.TimeUnit;

public class Wheel extends Detail {
    public Wheel(int massWheel){
        super(massWheel);
    }
    public void rotate(int fuelBuffer){
        try {
            Thread.sleep(1000*fuelBuffer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
