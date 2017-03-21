package main.persistance.wasplaatsauto;

import main.models.Auto;
import main.models.Wasplaats;
import main.persistance.Database;

import java.sql.PreparedStatement;
import java.sql.SQLException;

class MySQLWasplaatsAutoRepository implements IWasplaatsAutoRepository{

    @Override
    public void clean() {
        String sql = "Delete from wasplaatsauto";

        try {
            PreparedStatement ex = Database.connect().prepareStatement(sql);
            ex.executeUpdate();
        } catch (Exception var7) {
            var7.printStackTrace();
        } finally {
            Database.disconnect();
        }
    }

    @Override
    public void connect(Auto auto, Wasplaats wasplaats) {
        String sql = "Insert into wasplaatsauto(wasplaatsID, autoID)values(?,?)";

        try {
            PreparedStatement ex = Database.connect().prepareStatement(sql);
            ex.setInt(1, wasplaats.getId());
            ex.setInt(2, auto.getId());
            ex.executeUpdate();
        } catch (Exception var7) {
            var7.printStackTrace();
        } finally {
            Database.disconnect();
        }
    }

    @Override
    public void disconnect(Auto auto) {
        String sql = "DELETE FROM wasplaatsauto WHERE autoID = ?";

        try {
            PreparedStatement ex = Database.connect().prepareStatement(sql);
            ex.setInt(1, auto.getId());
            ex.executeUpdate();
        } catch (Exception var7) {
            var7.printStackTrace();
        } finally {
            Database.disconnect();
        }
    }
}
