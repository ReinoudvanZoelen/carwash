package main.persistance.auto;

import main.models.Auto;
import main.persistance.Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MySQLAutoRepository implements IAutoRepository {

    Database db = new Database();

    private Auto CreateObject(ResultSet result) {
        Auto auto = null;

        try{
            String naam = result.getString("naam");
            Boolean vies = result.getBoolean("vies");
            int wasTijd = result.getInt("wasTijd");
            int backId = result.getInt("id");

            auto = new Auto(backId, naam, vies, wasTijd);
        }
        catch(SQLException exception){
            System.out.println(exception.getMessage());
        }

        return auto;
    }

    @Override
    public Auto GetSingle(int id) {
        String sql = "Select * from autos where id = ?";
        Auto auto = null;

        try {
            PreparedStatement preparedStatement = Database.connect().prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                auto = CreateObject(resultSet);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            db.disconnect();
        }

        return auto;
    }

    @Override
    public Auto GetSingleByWasplaatsId(int id) {
        String sql = "Select * from autos inner join wasplaatsauto on wasplaatsauto.autoID = autos.ID where wasplaatsauto.wasplaatsID = ?";
        Auto auto = null;

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

        return auto;
    }

    @Override
    public ArrayList<Auto> GetAll() {
        String sql = "Select * from autos";
        ArrayList<Auto> autos = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = Database.connect().prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                autos.add(CreateObject(resultSet));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            db.disconnect();
        }

        return autos;
    }

    @Override
    public void insert(Auto auto) {
        String sql = "Insert into autos(naam, vies, wasTijd)values(?,?,?)";

        try {
            PreparedStatement ex = db.connect().prepareStatement(sql);
            ex.setString(1, auto.getNaam());
            ex.setBoolean(2, auto.isVies());
            ex.setInt(3, auto.getWasTijd());
            ex.executeUpdate();
        } catch (SQLException var7) {
            var7.printStackTrace();
        } finally {
            db.disconnect();
        }
    }

    @Override
    public void update(Auto auto) {
        String sql = "Update autos set naam = ?, vies = ?, wasTijd = ? where id = ?";

        try {
            PreparedStatement ex = db.connect().prepareStatement(sql);
            ex.setString(1, auto.getNaam());
            ex.setBoolean(2, auto.isVies());
            ex.setInt(3, auto.getWasTijd());
            ex.setInt(4, auto.getId());
            ex.executeUpdate();
        } catch (SQLException var7) {
            var7.printStackTrace();
        } finally {
            db.disconnect();
        }
    }

    @Override
    public void delete(Auto auto) {
        String sql = "Delete from autos where id = ?";

        try {
            PreparedStatement ex = db.connect().prepareStatement(sql);
            ex.setInt(1, auto.getId());
            ex.executeUpdate();
        } catch (SQLException var7) {
            var7.printStackTrace();
        } finally {
            db.disconnect();
        }
    }

    public Auto GetLastByWasplaatsID(int id){
        return null; // TODO
    }
}
