package main.models;

import java.io.Serializable;
import java.util.Date;

public class Wasplaats implements Serializable {
    private int id;
    private String type;
    private Wasplaats verbondenWasplaats;

    public Wasplaats() {
    }

    public Wasplaats(int id, String type, Auto auto, Date date, Wasplaats verbondenWasplaats) {
        this.id = id;
        this.type = type;
        this.verbondenWasplaats = verbondenWasplaats;
    }

    public Wasplaats(int id, String type, Wasplaats verbondenWasplaats) {
        this.id = id;
        this.type = type;
        this.verbondenWasplaats = verbondenWasplaats;
    }

    @Override
    public String toString(){
        String wasplaatsString = this.type;

        Wasplaats wasplaatsTemp = this;

        while(wasplaatsTemp.verbondenWasplaats != null){
            wasplaatsString = wasplaatsString + ", " + wasplaatsTemp.verbondenWasplaats.type;
            wasplaatsTemp = verbondenWasplaats;
        }

        return wasplaatsString;
    }

    //region Getters & Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Wasplaats getVerbondenWasplaats() {
        return verbondenWasplaats;
    }

    public void setVerbondenWasplaats(Wasplaats verbondenWasplaats) {
        this.verbondenWasplaats = verbondenWasplaats;
    }
    //endregion
}
