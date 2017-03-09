package main.persistance;

import main.models.Auto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MySQLAutoRepository implements IAutoRepository {

    Database db = new Database();

    @Override
    public Auto GetSingle(int id) {
        String sql = "Select * from autos where id = ?";
        Auto auto = null;

        try {
            PreparedStatement preparedStatement = Database.connect().prepareStatement(sql);
            preparedStatement.setInt(1,id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String naam =   resultSet.getString("naam");
                Boolean vies = resultSet.getBoolean("vies");
                int wasTijd = resultSet.getInt("wasTijd");
                int backId = resultSet.getInt("id");

                auto = new Auto(backId, naam, vies, wasTijd);
            }
        }

        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        finally {
            db.disconnect();
        }

        return auto;
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
