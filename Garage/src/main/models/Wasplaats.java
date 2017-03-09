package main.models;

import java.sql.Time;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

public class Wasplaats {
    private Auto GeplaatsdeAuto;
    private Time Geplaatst;

    public void plaatsAuto(Auto auto){
        this.GeplaatsdeAuto = auto;
        this.Geplaatst = Time.valueOf(LocalTime.now());
    }
}
