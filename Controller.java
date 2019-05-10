package sample;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;
import sample.Model.Car;

import java.io.IOException;
import java.net.MalformedURLException;

public class Controller {
    Car car = new Car("Priora");
    TaskCar tcar = new TaskCar();
    TaskBak tbak = new TaskBak();
    @FXML
    private Label CarLabel;
    @FXML
    private Label WheelLabel;
    @FXML
    private Label BakLabel;
    @FXML
    private Label DvigatLabel;
    //@FXML
    //private Button GaCar;
    private Main main;

    public Controller(){
    }

    @FXML
    private void initialize() {
        tbak.setOnRunning(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent t) {
                setDvigatLabel("работает");
                setWheelLabel("крутится");
            }
        });
        tbak.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent t) {
                CarLabel.textProperty().unbind();
                setCarLabel("стоит");
                setDvigatLabel("не работает");
                setWheelLabel("не крутится");
            }
        });
    }


    public void startCar(){
        CarLabel.textProperty().bind(tcar.messageProperty());
        BakLabel.textProperty().bind(tbak.messageProperty());
        new Thread(tcar).start();


    }

    public void setMainApp(Main main) {
        this.main = main;
    }

    public void setCarLabel(String text){ CarLabel.setText(text);}
    public void setWheelLabel(String text){ WheelLabel.setText(text);}
    public void setBakLabel(String text){ BakLabel.setText(text);}
    public void setDvigatLabel(String text){ DvigatLabel.setText(text);}
    public Car getCar (){ return car;}

    class TaskCar extends Task<Void> {
        @Override public Void call() {
            if(car.go()){
                if(car.getEngine().startEngine(car.getTank(), car.getWheel())){
                    updateMessage("едет");
                    new Thread(tbak).start();
                }
            }
            return null;
        }

    }

    class TaskBak extends Task<Void> {
        @Override public Void call() {
            int fuelBuffer = 0;
            do{
                fuelBuffer = car.getEngine().work(car.getTank(), car.getWheel());
                car.getWheel().rotate(fuelBuffer);
                updateMessage(car.getTank().getFuel() + " L");
            }while (fuelBuffer > 0);

            return null;
        }
    }
}





