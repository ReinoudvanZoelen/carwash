package main.controllers;

import main.models.Auto;
import main.models.Wasplaats;
import main.persistance.auto.AutoController;
import main.persistance.wasplaats.WasplaatsController;
import main.persistance.wasplaatsauto.WasplaatsAutoController;

public class DataLogicController {
    private AutoController autoController = new AutoController();
    private WasplaatsController wasplaatsController = new WasplaatsController();
    private WasplaatsAutoController koppelController = new WasplaatsAutoController();

    public boolean Assign(Auto auto, Wasplaats wasplaats){
        koppelController.connect(auto, wasplaats);
        return true;
    }
}
