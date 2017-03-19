package main.controllers;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.*;
import main.models.Auto;
import main.models.Garage;
import main.models.Wasplaats;
import main.persistance.wasplaats.WasplaatsLogic;

import java.util.ArrayList;

public class DrawingController {

    private Pane pane;

    public DrawingController(Pane pane) {
        this.pane = pane;
    }

    private WasplaatsLogic wasplaatsLogic = new WasplaatsLogic();

    //Method draws all cars in the Garage
    public void DrawGarage(Garage garage) {
        pane.getChildren().clear();
        System.out.println("Children of the drawing Pane have been wiped");

        for (int x = 0; x < 3; x++) {
            System.out.println("Start For-iteration of DrawGarage number " + x);

            // start X: 225
            // start Y: 14
            // Position: top left

            // centerX: sX + difference between buttons * x = starting position
            // centerY: sY + 25 (button height) + 50 extra height

            // Check if the Wasplaats has a Car

            for (Auto auto : garage.wasplaatsen)
            {
                if (auto != null) {
                    DrawCar(225 + (135 * x), 14 + 75, auto);
                    System.out.println("Drawn wasplaats " + x + " with car " + auto.getNaam());
                } else {
                    System.out.println("No car was found in wasplaats with index " + x);
                }
            }
        }
    }

    private void DrawCar(int xPosition, int yPosition, Auto auto) {
        Ellipse roof = new Ellipse(xPosition + 60, yPosition, 35, 20);
        roof.setFill(Paint.valueOf("222D4A"));

        Rectangle body = new Rectangle(xPosition, yPosition, 120, 40);
        body.setFill(Paint.valueOf("222D4A"));

        Circle frontWheel = new Circle(xPosition + 20, yPosition + 40, 10);
        Circle backWheel = new Circle(xPosition + 100, yPosition + 40, 10);

        pane.getChildren().add(body);
        pane.getChildren().add(roof);
        pane.getChildren().add(frontWheel);
        pane.getChildren().add(backWheel);
    }
}
