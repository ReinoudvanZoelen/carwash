package main.persistance;

import main.models.Auto;

import java.util.ArrayList;

public class AutoController implements IAutoRepository {

    private IAutoRepository repository;

    public AutoController(){
        repository = new MySQLAutoRepository();
    }

    @Override
    public Auto GetSingle(int id) {
        return repository.GetSingle(id);
    }

    @Override
    public ArrayList<Auto> GetAll() {
        return null;
    }

    @Override
    public void insert(Auto auto) {

    }

    @Override
    public void update(Auto auto) {

    }

    @Override
    public void delete(Auto auto) {

    }
}
