package main.persistance.wasplaats;

import main.models.Wasplaats;

import java.util.ArrayList;

class WasplaatsRepository implements IWasplaatsRepository {

    private IWasplaatsRepository data = new WasplaatsController();

    @Override
    public Wasplaats GetSingle(int id) {
        return data.GetSingle(id);
    }

    @Override
    public ArrayList<Wasplaats> GetAll() {
        return data.GetAll();
    }

    @Override
    public void insert(Wasplaats wasplaats) {
        data.insert(wasplaats);
    }

    @Override
    public void update(Wasplaats wasplaats) {
        data.update(wasplaats);
    }

    @Override
    public void delete(Wasplaats wasplaats) {
        data.delete(wasplaats);
    }
}
