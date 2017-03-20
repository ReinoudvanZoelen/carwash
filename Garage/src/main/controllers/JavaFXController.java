package main.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import main.models.Auto;
import main.models.Wasplaats;
import main.persistance.auto.AutoController;
import main.persistance.wasplaats.WasplaatsController;

// GOAL OF THE CLASS IS TO PASS INPUT TO THE CONTROLLER
// AND TO MODIFY THINGS ON THE JAVAFX PANEL
// IT IS NOT USED FOR LOGIC
public class JavaFXController {

    private Controller controller = new Controller();
    private AutoController autoController = new AutoController();
    private WasplaatsController wasplaatsController = new WasplaatsController();

    @FXML
    private Pane drawPane;
    @FXML
    private ListView AutoLijst;
    @FXML
    private ListView WasplaatsLijst;

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

    public void RemoveAutoFromList() {
        AutoLijst.getItems().remove(GetAutolistIndex());
    }

    public void populateLists() {
        AutoLijst.getItems().clear();
        WasplaatsLijst.getItems().clear();

        for (Auto auto : autoController.GetAll()) {
            AutoLijst.getItems().add(auto);
        }
        for (Wasplaats wasplaats : wasplaatsController.GetAll()) {
            WasplaatsLijst.getItems().add(wasplaats);
        }
    }

    //region Getters & Setters
    public int GetAutolistIndex() {
        return AutoLijst.getSelectionModel().getSelectedIndex();
    }

    public int GetAutoID() {
        return ((Auto) AutoLijst.getSelectionModel().getSelectedItem()).getId();
    }

    public int GetWasplaatslistIndex() {
        return WasplaatsLijst.getSelectionModel().getSelectedIndex();
    }

    public int GetWasplaatsID() {
        return ((Wasplaats) WasplaatsLijst.getSelectionModel().getSelectedItem()).getId();
    }

    public Pane getDrawPane() {
        return drawPane;
    }
    //endregion
}
