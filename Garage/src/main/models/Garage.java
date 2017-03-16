package main.models;

import java.util.ArrayList;

public class Garage {
    public ArrayList<Auto> autos = new ArrayList<>();
    private Wasplaats[] wasplaatsen = new Wasplaats[3];

    public Garage() {
        wasplaatsen[0] = new Wasplaats();
        wasplaatsen[1] = new Wasplaats();
        wasplaatsen[2] = new Wasplaats();
    }

    public void setWp1(Auto auto) {
        wasplaatsen[0].plaatsAuto(auto);
    }
    public void setWp2(Auto auto) {
        wasplaatsen[1].plaatsAuto(auto);
    }
    public void setWp3(Auto auto) {
        wasplaatsen[2].plaatsAuto(auto);
    }

    public Wasplaats[] getWasplaatsen() {
        return wasplaatsen;
    }
}
