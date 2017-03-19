package main.persistance.wasplaats;

import main.models.Wasplaats;

import java.util.ArrayList;

public class WasplaatsController implements IWasplaatsRepository {

    private IWasplaatsRepository context = new MySQLWasplaatsRepository();

    @Override
    public Wasplaats GetSingle(int id) {
        return context.GetSingle(id);
    }

    @Override
    public ArrayList<Wasplaats> GetAll() {
        return context.GetAll();
    }

    @Override
    public void insert(Wasplaats wasplaats) {

    }

    @Override
    public void update(Wasplaats wasplaats) {

    }

    @Override
    public void delete(Wasplaats wasplaats) {

    }
}
