package main.persistance.wasplaatsauto;

import main.models.Auto;
import main.models.Wasplaats;

public class WasplaatsAutoController implements IWasplaatsAutoRepository {

    private IWasplaatsAutoRepository context = new MySQLWasplaatsAutoRepository();

    @Override
    public void clean() {
        context.clean();
    }

    @Override
    public void disconnect(Auto auto) { context.disconnect(auto); }

    @Override
    public void connect(Auto auto, Wasplaats wasplaats) {
        context.connect(auto, wasplaats);
    }


}
