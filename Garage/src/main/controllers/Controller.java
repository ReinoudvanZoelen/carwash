package main.controllers;

import main.models.Auto;
import main.persistance.auto.AutoController;
import main.persistance.wasplaats.WasplaatsController;

public class Controller {

    private AutoController autoData = new AutoController();
    private WasplaatsController wasplaatsData = new WasplaatsController();

    private DrawingController draw;
    private TimingController time;
    private JavaFXController javaFx;

    public void start(JavaFXController javaFXController){
        time = new TimingController(wasplaatsData.GetAll());
        javaFx = javaFXController;
        draw = new DrawingController(javaFx.getDrawPane());

        // Fill all the lists with data
        javaFx.populateLists(autoData.GetAll());
    }

    public void moveCar() {
        if (javaFx.GetLeftListIndex() >= 0) {
            // Get the car that we have selected
            Auto auto = autoData.GetSingle(javaFx.GetLeftListID());
            System.out.println("Selected Car has been picked up and saved in a temp Car object");

            // Assign the car to the Garage object Wasplaats (w1/w2/w3) depending on the clicked button
            switch (javaFx.GetButtonText()) {
                case "Wasplaats 1":
                    // TODO: Maak een entry aan in de tabel WASPLAATSAUTO die wasplaats 1, 2 of 3 gebruikt
                    // garage.setWp1(auto);
                    System.out.println("Car has been saved to Garage.WP1");
                    break;
                case "Wasplaats 2":
                    // garage.setWp2(auto);
                    System.out.println("Car has been saved to Garage.WP2");
                    break;
                case "Wasplaats 3":
                    // garage.setWp3(auto);
                    System.out.println("Car has been saved to Garage.WP3");
                    break;
                default:
                    System.out.println("Button was not picked up correctly");
                    break;
            }

            // Remove the car from the left list
            // TODO verander dit in: haal alle data opnieuw op en vul het opnieuw in
            javaFx.RemoveSelectedItemFromLeftList();
            System.out.println("Car has been removed from the left list");

            // Draw the cars in the garage
            draw.DrawGarage();

            // Start the timer
            // Initialize a new TimingController, this re-initializes everything
            time = new TimingController(wasplaatsData.GetAll());
        }
    }
}