package main.controllers;

import main.models.Auto;
import main.models.Garage;
import main.persistance.wasplaats.WasplaatsController;

import java.util.Timer;
import java.util.TimerTask;

public class TimingController {

    public TimingController(Garage garage) {
        for (Auto auto : garage.wasplaatsen) {
            if (auto != null) {
                Timer timer = new Timer();
                timer.schedule(new TimerCarWash(auto), auto.getWasTijd() * 1000);
            }
        }
    }
}

class TimerCarWash extends TimerTask {

    private WasplaatsController wasplaatsController = new WasplaatsController();

    private Auto auto;

    public TimerCarWash(Auto auto) {
        this.auto = auto;
    }

    public void run() {
        //wasplaatsController.RemoveAutoFromWasplaats(auto);
        // TODO nu moet de pagina opnieuw worden getekend anders merkt niemand dat de auto weg is
    }
}

