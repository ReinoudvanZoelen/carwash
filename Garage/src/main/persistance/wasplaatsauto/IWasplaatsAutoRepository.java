package main.persistance.wasplaatsauto;

import main.models.Auto;
import main.models.Wasplaats;

interface IWasplaatsAutoRepository {
    void clean();
    void connect(Auto auto, Wasplaats wasplaats);
}
