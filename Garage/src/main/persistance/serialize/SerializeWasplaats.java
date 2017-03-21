package main.persistance.serialize;

import main.models.Wasplaats;
import main.persistance.wasplaats.WasplaatsController;

import java.io.*;
import java.util.ArrayList;

public class SerializeWasplaats {

    public void writer() {
        ArrayList<Wasplaats> wps = new WasplaatsController().GetAll();

        try {
            FileOutputStream fileOut =
                    new FileOutputStream("wasplaatsen.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(wps);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public ArrayList<Wasplaats> reader(){
        ArrayList<Wasplaats> wpl = null;

        try {
            FileInputStream fileIn = new FileInputStream("wasplaatsen.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            wpl = (ArrayList<main.models.Wasplaats>) in.readObject();
            in.close();
            fileIn.close();
        }catch(IOException i) {
            i.printStackTrace();
        }catch(ClassNotFoundException c) {
            System.out.println("Employee class not found");
            c.printStackTrace();
        }

        return wpl;
    }
}
