package main.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import main.models.Auto;
import main.persistance.auto.AutoController;

import java.util.ArrayList;

// GOAL OF THE CLASS IS TO PASS INPUT TO THE CONTROLLER
// AND TO MODIFY THINGS ON THE JAVAFX PANEL
// IT IS NOT USED FOR LOGIC
public class JavaFXController {

    private Controller controller = new Controller();

    @FXML
    private Pane drawPane;
    @FXML
    private ListView viezeAutoLijst;
    @FXML
    private ListView schoneAutoLijst;

    private Button lastPressed;

    @FXML
    public void startPressed(ActionEvent event) {
        controller.start(this);
    }

    @FXML
    public void buttonPressed(ActionEvent event) {
        System.out.println("Button " + ((Button) event.getSource()).getText() + " has been clicked.");

        lastPressed = (Button) event.getSource();

        controller.WasplaatsButtonClick();
    }

    public int GetLeftListIndex() {
        return viezeAutoLijst.getSelectionModel().getSelectedIndex();
    }

    public int GetLeftListID() {
        return ((Auto) viezeAutoLijst.getSelectionModel().getSelectedItem()).getId();
    }

    public void RemoveSelectedItemFromLeftList() {
        viezeAutoLijst.getItems().remove(GetLeftListIndex());
    }

    public Pane getDrawPane() {
        return drawPane;
    }

    public String GetButtonText() {
        if (lastPressed != null) {
            return lastPressed.getText();
        } else
            System.out.println("GetButtonText was not performed correctly. A button should have been clicked, but wasn't");
        return null;
    }

    public void populateLists(ArrayList<Auto> autos) {
        schoneAutoLijst.getItems().clear();
        viezeAutoLijst.getItems().clear();
        System.out.println("Left and Right listboxes have been cleared");

        // TODO Een auto kan ook in een wasstraat staan, moet ik een beetje creatief met queries oplossen
        for (Auto auto : autos) {
            if (auto.isVies() == true) {
                viezeAutoLijst.getItems().add(auto);
                System.out.println("Auto " + auto.getNaam() + " has been added to the left list");
            } else {
                schoneAutoLijst.getItems().add(auto);
                System.out.println("Auto " + auto.getNaam() + " has been added to the right list");
            }
        }
    }
}
