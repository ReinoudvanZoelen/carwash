package main.javaFX;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.*;
import main.models.Auto;

public class DrawingController {

    private Pane pane;

    public DrawingController(Pane pane) {
        this.pane = pane;
    }

    public void DrawCar(int xPosition, int yPosition, Auto auto) {
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
