package main.javaFX;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.models.Auto;
import main.models.Garage;
import main.persistance.AutoController;
import main.persistance.Database;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("JavaFX Wasstraat");
        primaryStage.setScene(new Scene(root, 840, 400));
        primaryStage.show();

        // Testing the database functions
        dbTest();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void dbTest() {
        Database.connect();
        AutoController ac = new AutoController();
        Auto ab = ac.GetSingle(1);
        if(ab != null){
            System.out.println("Database test passed");
        }
    }
}

