package main.persistance.auto;

import main.models.Auto;
import main.models.Wasplaats;

import java.util.ArrayList;

interface IAutoRepository {
    public Auto GetSingle(int id);
    public Auto GetSingleByWasplaatsId(int id);
    public ArrayList<Auto> GetAll();
    public void assign(Auto auto, Wasplaats wasplaats);
    public void insert(Auto auto);
    public void update (Auto auto);
    public void delete (Auto auto);
}
