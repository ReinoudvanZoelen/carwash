package main.controllers;

import main.models.Auto;
import main.models.Garage;
import main.persistance.auto.AutoController;
import main.persistance.wasplaats.WasplaatsController;

public class Controller {

    private AutoController autoData = new AutoController();
    private WasplaatsController wasplaatsData = new WasplaatsController();

    private Garage garage;
    private DrawingController draw;
    private TimingController time;
    private JavaFXController javaFx;

    public void start(JavaFXController javaFXController) {
        garage = new Garage();
        time = new TimingController(garage);
        javaFx = javaFXController;
        draw = new DrawingController(javaFx.getDrawPane());

        // Fill all the lists with data
        javaFx.populateLists(autoData.GetAll());
    }

    private Auto GetSelectedCar() {
        if (javaFx.GetLeftListIndex() >= 0) {
            return autoData.GetSingle(javaFx.GetLeftListID());
        }
        return null;
    }

    private int GetClickedButtonID(){
        switch (javaFx.GetButtonText()) {
            case "Wasplaats 1":
                return 1; break;
            case "Wasplaats 2":
                return 2; break;
            case "Wasplaats 3":
                return 3; break;
            default:
                System.out.println("Button was not picked up correctly");
                break;
        }
    }

    public void WasplaatsButtonClick() {
        if (javaFx.GetLeftListIndex() >= 0) {
            // Get the car that we have selected
            Auto auto = autoData.GetSingle(javaFx.GetLeftListID());
            System.out.println("Selected Car has been picked up and saved in a temp Car object");

            // Assign the car to the Garage object Wasplaats (w1/w2/w3) depending on the clicked button


            // Remove the car from the left list
            // TODO verander dit in: haal alle data opnieuw op en vul het opnieuw in
            javaFx.RemoveSelectedItemFromLeftList();
            System.out.println("Car has been removed from the left list");

            // Draw the cars in the garage
            draw.DrawGarage(garage);

            // Start the timer
            // Initialize a new TimingController, this re-initializes everything
            time = new TimingController(garage);
        }
    }
}