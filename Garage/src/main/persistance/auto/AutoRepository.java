package main.persistance.auto;

import main.models.Auto;
import main.models.Wasplaats;

import java.util.ArrayList;

class AutoRepository implements IAutoRepository {

    private IAutoRepository data = new MySQLAutoRepository();

    @Override
    public Auto GetSingle(int id) {
        return data.GetSingle(id);
    }

    @Override
    public Auto GetSingleByWasplaatsId(int id) {
        return data.GetSingleByWasplaatsId(id);
    }

    @Override
    public ArrayList<Auto> GetAll() {
        return data.GetAll();
    }

    @Override
    public void assign(Auto auto, Wasplaats wasplaats) {
        data.assign(auto,wasplaats);
    }

    @Override
    public void insert(Auto auto) {
        data.insert(auto);
    }

    @Override
    public void update(Auto auto) {
        data.update(auto);
    }

    @Override
    public void delete(Auto auto) {
        data.delete(auto);
    }
}
