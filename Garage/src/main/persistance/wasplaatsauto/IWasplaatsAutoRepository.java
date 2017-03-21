package main.persistance.wasplaatsauto;

import main.models.Auto;
import main.models.Wasplaats;

interface IWasplaatsAutoRepository {
    void clean();
    void disconnect(Auto auto);
    void connect(Auto auto, Wasplaats wasplaats);
}
