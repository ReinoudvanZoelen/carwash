package main.controllers;

import main.models.Auto;
import main.models.Garage;
import main.models.Wasplaats;
import main.persistance.auto.AutoController;
import main.persistance.serialize.SerializeWasplaats;
import main.persistance.wasplaats.WasplaatsController;

import java.util.ArrayList;

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
        javaFx = javaFXController;
        draw = new DrawingController(javaFx.getDrawPane());
        data = new DataLogicController();

        // Fill all the lists with data
        data.CleanConnections();
        javaFx.populateLists();
        draw.Draw();
    }

    public void AssignAutoClick(Auto auto, Wasplaats wasplaats) {
        data.Assign(auto, wasplaats);

        javaFx.populateLists();

        Redraw();

        time = new TimingController(this);
    }

    public void Redraw(){
        draw.Draw();
    }
}