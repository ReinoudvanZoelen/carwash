package main.models;

import java.util.ArrayList;

/**
 * Created by Reino on 21-2-2017.
 */
public class Garage {
public ArrayList<Auto> autos = new ArrayList<>();
    private Wasplaats wp1 = new Wasplaats();
    private Wasplaats wp2 = new Wasplaats();
    private Wasplaats wp3 = new Wasplaats();


    public Garage(){
        autos.add(new Auto("Audi A7",true, 10));
        autos.add(new Auto("Volkswagen Polo",true, 5));
        autos.add(new Auto("Volvo CS40",true, 15));
        autos.add(new Auto("BMS M7",true, 5));
        autos.add(new Auto("Nissan Picanto",true, 20));
        autos.add(new Auto("Subaru Impreza",true, 25));
    }


}
