package main.persistance.wasplaats;

import main.models.Auto;
import main.models.Wasplaats;
import main.persistance.Database;
import main.persistance.auto.MySQLAutoRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MySQLWasplaatsRepository implements IWasplaatsRepository {

    Database db = new Database();
    private MySQLAutoRepository autoRepo = new MySQLAutoRepository();

    private Wasplaats CreateObject(ResultSet result) {
        Wasplaats wasplaats = null;

        try {
            int id = result.getInt("id");
            Auto auto = autoRepo.GetSingle(result.getInt(""))
            String type = result.getString("type");
            if(result.getInt("previousWasplaatsId") > 0){
                GetChild(id);
            }
            Wasplaats verbondenwasplaats
        } catch (SQLException exception) {

        }

        return wasplaats;
    }

    @Override
    public Wasplaats GetSingle(int id) {
        String sql = "Select * from wasplaats where id = ?";
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

    private Wasplaats GetChild(int parentId){
        String sql = "Select * from wasplaats where previousWasplaatsID = ?";
        Wasplaats wasplaats = null;

        try {
            PreparedStatement preparedStatement = Database.connect().prepareStatement(sql);
            preparedStatement.setInt(1, parentId);

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

    @Override
    public ArrayList<Wasplaats> GetAll() {
        String sql = "Select * from wasplaats where previousWasplaatsId is null";
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
        String sql = "Insert into wasplaats(type, previousWasplaatsId)values(?,?)";

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
        String sql = "Update wasplaats set type = ?, previousWasplaatsId = ?) where id = ?";

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
        String sql = "Delete from wasplaats where id = ?";

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
