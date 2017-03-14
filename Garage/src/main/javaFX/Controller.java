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
import main.models.Wasplaats;

public class Controller {

    public Garage garage;

    //private GraphicsContext gc;
    @FXML
    private Pane drawPane;
    @FXML
    private ListView viezeAutoLijst;



    @FXML
    public void buttonPressed(ActionEvent event) {
        System.out.println("Button " + ((Button) event.getSource()).getText()+ " has been clicked.");

        _moveCar(event);

    }

    private void _moveCar(ActionEvent event) {
        if (viezeAutoLijst.getSelectionModel().getSelectedIndex() >= 0) {
            // Get the car that we have selected
            Auto auto = (Auto) viezeAutoLijst.getItems().get(viezeAutoLijst.getSelectionModel().getSelectedIndex());
            System.out.println("Selected Car has been picked up and saved in a temp Car object");

            // Get the button that was clicked
            Button button = (Button) event.getSource();
            System.out.println("Clicked Button has been detected");

            // Assign the car to the Garage object Wasplaats (w1/w2/w3) depending on the clicked button
            switch(button.getText()){
                case "Wasplaats 1":
                    garage.setWp1(auto);
                    System.out.println("Car has been saved to Garage.WP1");
                    break;
                case "Wasplaats 2":
                    garage.setWp2(auto);
                    System.out.println("Car has been saved to Garage.WP2");
                    break;
                case "Wasplaats 3":
                    garage.setWp3(auto);
                    System.out.println("Car has been saved to Garage.WP3");
                    break;
            }

            // Remove the car from the left list
            viezeAutoLijst.getItems().remove(viezeAutoLijst.getSelectionModel().getSelectedIndex());
            System.out.println("Car has been removed from the left list");

            // Draw the cars in the garage
            _paintGarage();
        }
    }

    private void _paintGarage(){
        DrawingController draw = new DrawingController(this.garage, drawPane);

        draw.DrawGarage();
    }

    // Depricated method, was used for drawing cars manually and individually
    private void _paintCar(ActionEvent event, Auto auto) {
        DrawingController draw = new DrawingController(this.garage, drawPane);

        // Get the button so we can know where to draw underneath
        Button source = (Button) event.getSource();
        Bounds boundsInScene = source.localToScene(source.getBoundsInLocal());

        // Find the action positions where we want to draw the car
        int xTruePosition = (int) boundsInScene.getMaxX() - (int) boundsInScene.getWidth();
        int yTruePosition = (int) boundsInScene.getMaxY() + (int) boundsInScene.getHeight();

        draw.DrawCar(xTruePosition, yTruePosition, auto);

        System.out.println("Car has been painted");
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