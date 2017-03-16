package main.controllers;

import main.models.Wasplaats;
import main.persistance.wasplaats.WasplaatsLogic;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class TimingController {

    public TimingController(ArrayList<Wasplaats> wasplaatsen) {
        for (Wasplaats wp : wasplaatsen) {
            if (wp.getAuto() != null) {
                Timer timer = new Timer();
                timer.schedule(new TimerCarWash(wp), wp.getAuto().getWasTijd() * 1000);
            }
        }
    }
}

class TimerCarWash extends TimerTask {

    private WasplaatsLogic wasplaatsLogic = new WasplaatsLogic();

    private Wasplaats wasplaats;

    public TimerCarWash(Wasplaats wasplaats) {
        this.wasplaats = wasplaats;
    }

    public void run() {
        wasplaatsLogic.RemoveAutoFromWasplaats(wasplaats);
        // TODO nu moet de pagina opnieuw worden getekend anders merkt niemand dat de auto weg is
    }
}

