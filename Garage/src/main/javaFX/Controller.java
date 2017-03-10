package main.javaFX;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Bounds;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import main.models.Auto;
import main.models.Garage;

public class Controller {

    private Garage garage;
    private GraphicsContext gc;
    @FXML
    private Pane backgroundPane;
    @FXML
    private ListView viezeAutoLijst;



    @FXML
    public void buttonPressed(ActionEvent event) {
        System.out.println("Button has been clicked.");

        _moveCar(event);

    }

    private void _paintCar(ActionEvent event, Auto auto) {
        DrawingController draw = new DrawingController(backgroundPane);

        // Get the button so we can know where to draw underneath
        Button source = (Button) event.getSource();
        Bounds boundsInScene = source.localToScene(source.getBoundsInLocal());

        // Find the action positions where we want to draw the car
        int xTruePosition = (int) boundsInScene.getMaxX() - (int) boundsInScene.getWidth();
        int yTruePosition = (int) boundsInScene.getMaxY() + (int) boundsInScene.getHeight();

        draw.DrawCar(xTruePosition, yTruePosition, auto);

        System.out.println("Car has been painted");
    }

    private void _moveCar(ActionEvent event) {
        if (viezeAutoLijst.getSelectionModel().getSelectedIndex() >= 0) {
            Auto auto = (Auto) viezeAutoLijst.getItems().get(viezeAutoLijst.getSelectionModel().getSelectedIndex());

            Button button = (Button) event.getSource();

            button.setText(auto.toString());

            viezeAutoLijst.getItems().remove(viezeAutoLijst.getSelectionModel().getSelectedIndex());

            System.out.println("Car has been moved from the list");

            _paintCar(event, auto);
        }
    }

    public void Restart() {
        garage = new Garage();

        viezeAutoLijst.getItems().clear();

        for (Auto auto : garage.autos
                ) {
            viezeAutoLijst.getItems().add(auto);
        }
    }

}