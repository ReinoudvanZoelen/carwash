package main.persistance.wasplaats;

import main.models.Wasplaats;

import java.util.ArrayList;

interface IWasplaatsRepository {
    Wasplaats GetSingle(int id);
    ArrayList<Wasplaats> GetAll();
    void insert(Wasplaats wasplaats);
    void update(Wasplaats wasplaats);
    void delete(Wasplaats wasplaats);
}
