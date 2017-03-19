package main.javaFX;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.models.Auto;
import main.models.Garage;
import main.models.Wasplaats;
import main.persistance.auto.AutoController;
import main.persistance.Database;
import main.persistance.wasplaats.WasplaatsController;

import java.util.ArrayList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("JavaFX Wasstraat");
        primaryStage.setScene(new Scene(root, 840, 400));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

