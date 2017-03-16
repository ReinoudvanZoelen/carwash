package main.persistance.wasplaats;

import main.models.Wasplaats;

import java.util.ArrayList;

public interface IWasplaatsRepository {
    public Wasplaats GetSingle(int id);
    public ArrayList<Wasplaats> GetAll();
    public void insert(Wasplaats wasplaats);
    public void update(Wasplaats wasplaats);
    public void delete(Wasplaats wasplaats);
}
