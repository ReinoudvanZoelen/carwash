package main.javaFX;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.models.Wasplaats;
import main.persistance.serialize.SerializeWasplaats;

import java.util.ArrayList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("JavaFX Wasstraat");
        primaryStage.setScene(new Scene(root, 840, 400));
        primaryStage.show();

        //Serialize();
    }

    private void Serialize() {
        SerializeWasplaats swp = new SerializeWasplaats();
        swp.writer();
        ArrayList<Wasplaats> reader = swp.reader();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

