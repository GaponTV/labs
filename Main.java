package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Model.Car;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("sample.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Hello World");

        primaryStage.setScene(new Scene(root, 575, 281));
        Controller controller = loader.getController();
        controller.setMainApp(this);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
