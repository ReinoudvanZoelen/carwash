package main.models;

import java.sql.Time;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

public class Wasplaats {
    private int id;
    private Auto GeplaatsdeAuto;
    private String type;
    private Time Geplaatst;
    private Wasplaats verbondenWasplaats;

    public Wasplaats() {
    }

    public Wasplaats(Auto auto, Wasplaats verbondenWasplaats) {
        GeplaatsdeAuto = auto;
        this.Geplaatst = Time.valueOf(LocalTime.now());
        this.verbondenWasplaats = verbondenWasplaats;
    }

    public void plaatsAuto(Auto auto){
        this.GeplaatsdeAuto = auto;
        this.Geplaatst = Time.valueOf(LocalTime.now());
    }

    //region Getters & Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Auto getGeplaatsdeAuto() {
        return GeplaatsdeAuto;
    }

    public void setGeplaatsdeAuto(Auto geplaatsdeAuto) {
        GeplaatsdeAuto = geplaatsdeAuto;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Time getGeplaatst() {
        return Geplaatst;
    }

    public void setGeplaatst(Time geplaatst) {
        Geplaatst = geplaatst;
    }

    public Wasplaats getVerbondenWasplaats() {
        return verbondenWasplaats;
    }

    public void setVerbondenWasplaats(Wasplaats verbondenWasplaats) {
        this.verbondenWasplaats = verbondenWasplaats;
    }
    //endregion
}
