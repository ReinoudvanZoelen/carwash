package main.javaFX;

import javafx.scene.layout.Pane;
import javafx.scene.shape.*;
import main.models.Auto;

public class DrawingController {

    private Pane pane;

    public DrawingController(Pane pane) {
        this.pane = pane;
    }

    public void DrawCar(int xPosition, int yPosition, Auto auto) {


        Rectangle body = new Rectangle(xPosition, yPosition, 120, 40);

        Line line = new Line(xPosition, yPosition, xPosition + 100, yPosition+100);

        pane.getChildren().add(body);
    }
}
