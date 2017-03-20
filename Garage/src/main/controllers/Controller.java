package main.controllers;

import main.models.Auto;
import main.models.Garage;
import main.models.Wasplaats;
import main.persistance.auto.AutoController;
import main.persistance.wasplaats.WasplaatsController;

public class Controller {

    private AutoController autoData = new AutoController();
    private WasplaatsController wasplaatsData = new WasplaatsController();

    private Garage garage;
    private DrawingController draw;
    private TimingController time;
    private JavaFXController javaFx;
    private DataLogicController data;

    public void start(JavaFXController javaFXController) {
        garage = new Garage();
        time = new TimingController(garage);
        javaFx = javaFXController;
        draw = new DrawingController(javaFx.getDrawPane());
        data = new DataLogicController();

        // Fill all the lists with data
        javaFx.populateLists();
    }

    public void AssignAutoClick(Auto auto, Wasplaats wasplaats) {
        //data.Assign(auto, wasplaats);

        javaFx.populateLists();

        draw.DrawCar(200, 200, auto);

        time = new TimingController(garage);
    }

    private Auto GetSelectedAuto() {
        if (javaFx.GetAutoID() >= 0) {
            return autoData.GetSingle(javaFx.GetAutoID());
        }
        return null;
    }

    private Wasplaats GetSelectedWasplaats() {
        if (javaFx.GetWasplaatsID() >= 0) {
            return wasplaatsData.GetSingle(javaFx.GetWasplaatsID());
        }
        return null;
    }

    private void AssignAutoToGarage() {
        garage.wasplaatsen[javaFx.GetWasplaatslistIndex()] = GetSelectedAuto();
    }
}