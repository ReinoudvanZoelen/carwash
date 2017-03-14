package main.models;

import java.util.ArrayList;

/**
 * Created by Reino on 21-2-2017.
 */
public class Garage {
    public ArrayList<Auto> autos = new ArrayList<>();
    private Wasplaats[] wasplaatsen = new Wasplaats[3];

    public Garage() {
        autos.add(new Auto("Audi A7", true, 10));
        autos.add(new Auto("Volkswagen Polo", true, 5));
        autos.add(new Auto("Volvo CS40", true, 15));
        autos.add(new Auto("BMS M7", true, 5));
        autos.add(new Auto("Nissan Picanto", true, 20));
        autos.add(new Auto("Subaru Impreza", true, 25));

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
