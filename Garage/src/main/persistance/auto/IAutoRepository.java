package main.persistance.auto;

import main.models.Auto;

import java.util.ArrayList;

public interface IAutoRepository {
    public Auto GetSingle(int id);
    public Auto GetSingleByWasplaatsId(int id);
    public ArrayList<Auto> GetAll();
    public void insert(Auto auto);
    public void update (Auto auto);
    public void delete (Auto auto);
}
