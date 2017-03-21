package main.controllers;

import main.models.Auto;
import main.persistance.auto.AutoController;
import main.persistance.wasplaatsauto.WasplaatsAutoController;

import java.util.Timer;
import java.util.TimerTask;

public class TimingController {

    private AutoController autoService = new AutoController();

    public TimingController(Controller controller){
        for (Auto auto : autoService.GetAll(true)) {
            Timer timer = new Timer();
            timer.schedule(new TimerCarWash(auto, controller), auto.getWasTijd() * 1000);
        }
    }
}

class TimerCarWash extends TimerTask {

    private WasplaatsAutoController wpaService = new WasplaatsAutoController();

    private Auto auto;
    private Controller controller;

    public TimerCarWash(Auto auto, Controller controller) {
        this.auto = auto; this.controller = controller;
    }

    public void run() {
        // Remove the car from the connection with Wasplaats
        wpaService.disconnect(auto);

        // Repaint the canvas and refill the lists
        controller.Redraw();
    }
}

