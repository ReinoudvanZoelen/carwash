package main.persistance.wasplaats;

import main.models.Wasplaats;
import main.persistance.Database;
import main.persistance.auto.AutoController;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

class MySQLWasplaatsRepository implements IWasplaatsRepository {

    Database db = new Database();
    private AutoController autoRepo = new AutoController();

    private Wasplaats CreateObject(ResultSet result) {
        Wasplaats wasplaats = null;

        try {
            int id = result.getInt("id");
            String type = result.getString("type");
            Wasplaats child = GetChild(id);
            //if (result.getInt("previousWasplaatsId") != 0) {
            //    child = GetChild(result.getInt("previousWasplaatsId"));
            //}

            wasplaats = new Wasplaats(id, type, child);
        } catch (SQLException exception) {
            System.out.println(exception);
        }
        return wasplaats;
    }

    @Override
    public Wasplaats GetSingle(int id) {
        String sql = "SELECT * FROM wasplaats WHERE id = ?";
        Wasplaats wasplaats = null;

        try {
            PreparedStatement preparedStatement = Database.connect().prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                CreateObject(resultSet);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            db.disconnect();
        }

        return wasplaats;
    }

    private Wasplaats GetChild(int parentId) {
        String sql = "SELECT * FROM wasplaats WHERE previousWasplaatsID = ?";
        Wasplaats wasplaats = null;

        try {
            PreparedStatement preparedStatement = Database.connect().prepareStatement(sql);
            preparedStatement.setInt(1, parentId);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                wasplaats = CreateObject(resultSet);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            db.disconnect();
        }

        return wasplaats;
    }

    @Override
    public ArrayList<Wasplaats> GetAll() {
        // Haalt alle Wasplaatsen op die top-parent zijn en al ze een auto hebben wordt deze ook opgeslagen
        // String sql = "Select * From wasplaats as WP left join wasplaatsauto as WPA on WP.id = WPA.wasplaatsID where WP.previousWasplaatsId is null";

        String sql = "SELECT * FROM wasplaats WHERE previousWasplaatsId IS NULL";

        ArrayList<Wasplaats> wasplaatsen = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = Database.connect().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                wasplaatsen.add(CreateObject(resultSet));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            db.disconnect();
        }

        return wasplaatsen;
    }

    @Override
    public void insert(Wasplaats wasplaats) {
        String sql = "INSERT INTO wasplaats(type, previousWasplaatsId)VALUES(?,?)";

        try {
            PreparedStatement ex = db.connect().prepareStatement(sql);
            ex.setString(1, wasplaats.getType());
            ex.setInt(2, wasplaats.getVerbondenWasplaats().getId());
            ex.executeUpdate();
        } catch (SQLException var7) {
            var7.printStackTrace();
        } finally {
            db.disconnect();
        }
    }

    @Override
    public void update(Wasplaats wasplaats) {
        String sql = "UPDATE wasplaats SET type = ?, previousWasplaatsId = ?) WHERE id = ?";

        try {
            PreparedStatement ex = db.connect().prepareStatement(sql);
            ex.setString(1, wasplaats.getType());
            ex.setInt(2, wasplaats.getVerbondenWasplaats().getId());
            ex.setInt(3, wasplaats.getId());
            ex.executeUpdate();
        } catch (SQLException var7) {
            var7.printStackTrace();
        } finally {
            db.disconnect();
        }
    }

    @Override
    public void delete(Wasplaats wasplaats) {
        String sql = "DELETE FROM wasplaats WHERE id = ?";

        try {
            PreparedStatement ex = db.connect().prepareStatement(sql);
            ex.setInt(1, wasplaats.getId());
            ex.executeUpdate();
        } catch (SQLException var7) {
            var7.printStackTrace();
        } finally {
            db.disconnect();
        }
    }
}
