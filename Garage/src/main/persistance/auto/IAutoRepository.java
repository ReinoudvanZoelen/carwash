package main.persistance.auto;

import main.models.Auto;
import main.models.Wasplaats;

import java.util.ArrayList;

interface IAutoRepository {
    Auto GetSingle(int id);
    Auto GetSingleByWasplaatsId(int id);
    ArrayList<Auto> GetAll();
    void insert(Auto auto);
    void update (Auto auto);
    void delete (Auto auto);
}
