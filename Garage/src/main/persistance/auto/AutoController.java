package main.persistance.auto;

import main.models.Auto;

import java.util.ArrayList;

public class AutoController implements IAutoRepository {

    private IAutoRepository repository;

    public AutoController() {
        repository = new MySQLAutoRepository();
    }

    public void AssignToWasplaats(Auto auto, int wasplaatsID){
        // TODO: Create a query that created an entry in the WasplaatsAuto table
    }

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
    public void insert(Auto auto) {
        repository.insert(auto);
    }

    @Override
    public void update(Auto auto) {
        repository.update(auto);
    }

    @Override
    public void delete(Auto auto) {
        repository.delete(auto);
    }
}
