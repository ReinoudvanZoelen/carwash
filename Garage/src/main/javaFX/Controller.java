package main.javaFX;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import main.models.Auto;
import main.models.Garage;

public class Controller {

    private Garage garage;
    private GraphicsContext gc;

    @FXML
    private Canvas ToPaintOn;

    @FXML
    private ListView viezeAutoLijst;

    @FXML
    public void buttonPressed(ActionEvent event) {
        System.out.println("Button has been clicked.");
        if (viezeAutoLijst.getSelectionModel().getSelectedIndex() >= 0) {
            Auto auto = (Auto) viezeAutoLijst.getItems().get(viezeAutoLijst.getSelectionModel().getSelectedIndex());

            Button button = (Button) event.getSource();

            button.setText(auto.toString());

            viezeAutoLijst.getItems().remove(viezeAutoLijst.getSelectionModel().getSelectedIndex());
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