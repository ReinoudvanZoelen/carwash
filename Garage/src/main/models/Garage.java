package main.models;

import java.util.ArrayList;

public class Garage {
    public Auto[] wasplaatsen = new Auto[3];

    public void setWp1(Auto auto) {
        wasplaatsen[0] = auto;
    }
    public void setWp2(Auto auto) {
        wasplaatsen[1] = auto;
    }
    public void setWp3(Auto auto) { wasplaatsen[2] = auto; }

    public Auto[] getWasplaatsen() {
        return wasplaatsen;
    }
}
