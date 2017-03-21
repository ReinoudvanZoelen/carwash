package main.controllers;

import main.models.Auto;
import main.persistance.auto.AutoController;
import main.persistance.wasplaats.WasplaatsController;
import main.persistance.wasplaatsauto.WasplaatsAutoController;

import java.util.Timer;
import java.util.TimerTask;

public class TimingController {

    private AutoController autoService = new AutoController();

    public TimingController() {
        for (Auto auto : autoService.GetAll(true)) {
            Timer timer = new Timer();
            timer.schedule(new TimerCarWash(auto), auto.getWasTijd() * 1000);
        }
    }
}

class TimerCarWash extends TimerTask {

    private WasplaatsAutoController wpaService = new WasplaatsAutoController();

    private Auto auto;

    public TimerCarWash(Auto auto) {
        this.auto = auto;
    }

    public void run() {
        // Remove the car from the connection with Wasplaats



        // Repaint the canvas

        // Refill the lists

    }
}

