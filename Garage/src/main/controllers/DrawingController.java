package main.controllers;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.*;
import main.models.Auto;
import main.persistance.auto.AutoController;

import java.util.concurrent.ThreadLocalRandom;

public class DrawingController {

    private Pane pane;
    private AutoController autoService = new AutoController();

    public DrawingController(Pane pane) {
        this.pane = pane;
    }

    //Method draws all cars in the Garage
    public void Draw() {
        pane.getChildren().clear();
        //System.out.println("Children of the drawing Pane have been wiped");

        int minX = 5;
        int maxX = 410 - 120 - 5;

        int randomnumberX;

        int minY = 5;
        int maxY = 326 - 40 - 5;

        int randomnumberY;


        // For every car that is currently connected to a wasplaats
        for (Auto auto : autoService.GetAll(true)) {
            randomnumberX = ThreadLocalRandom.current().nextInt(minX, maxX + 1);
            randomnumberY = ThreadLocalRandom.current().nextInt(minY, maxY + 1);

            DrawCar(randomnumberX, randomnumberY, null);
        }

    }

    private void DrawCar(int xPosition, int yPosition, Auto auto) {
        Rectangle background = new Rectangle(xPosition - 5, yPosition - 20 - 5, 120 + 10, 80 + 5);
        background.setFill(Paint.valueOf("FFFFFF"));

        Ellipse roof = new Ellipse(xPosition + 60, yPosition, 35, 20);
        roof.setFill(Paint.valueOf("222D4A"));

        Rectangle body = new Rectangle(xPosition, yPosition, 120, 40);
        body.setFill(Paint.valueOf("222D4A"));

        Circle frontWheel = new Circle(xPosition + 20, yPosition + 40, 10);
        Circle backWheel = new Circle(xPosition + 100, yPosition + 40, 10);

        pane.getChildren().add(background);
        pane.getChildren().add(body);
        pane.getChildren().add(roof);
        pane.getChildren().add(frontWheel);
        pane.getChildren().add(backWheel);
    }
}
