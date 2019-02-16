package application;
	
import java.awt.event.ActionEvent;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,350,200);
			VBox metr = new VBox();
			VBox dym = new VBox();
			
			TextField metrs = new TextField();
			TextField duyms = new TextField();
			Button metrs_b = new Button("Ìוענû ג ה‏ילû");
			Button duyms_b = new Button("Ä‏ילû ג לוענû");
			
			metr.getChildren().add(new Text("Ìוענû"));
			metr.getChildren().add(metrs);
			metr.getChildren().add(metrs_b);
			
			dym.getChildren().add(new Text("Ä‏ילû"));
			dym.getChildren().add(duyms);
			dym.getChildren().add(duyms_b);
			metrs_b.setOnAction(ev -> {
					duyms.setText(Double.toString(Double.valueOf(metrs.getText())*39.37));
			});
			duyms_b.setOnAction(ev -> {
					metrs.setText(Double.toString(Double.valueOf(duyms.getText())/39.37));
				
			});
			root.setLeft(metr);
			root.setRight(dym);
			primaryStage.setTitle("Lab8");
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
