package main.persistance.auto;

import main.models.Auto;
import main.models.Wasplaats;

import java.util.ArrayList;

public class AutoController implements IAutoRepository {

    private IAutoRepository repository = new MySQLAutoRepository();

    @Override
    public Auto GetSingle(int id) {
        return repository.GetSingle(id);
    }

    @Override
    public Auto GetSingleByWasplaatsId(int id) {
        return repository.GetSingleByWasplaatsId(id);
    }

    @Override
    public ArrayList<Auto> GetAll() {
        return repository.GetAll();
    }

    @Override
    public ArrayList<Auto> GetAll(boolean washed) {
        return repository.GetAll(washed);
    }

    @Override
    public void insert(Auto auto) { repository.insert(auto); }

    @Override
    public void update(Auto auto) {
        repository.update(auto);
    }

    @Override
    public void delete(Auto auto) {
        repository.delete(auto);
    }
}
