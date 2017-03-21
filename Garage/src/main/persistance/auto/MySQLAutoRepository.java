package main.persistance.auto;

import main.models.Auto;
import main.persistance.Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

class MySQLAutoRepository implements IAutoRepository {

    private Auto CreateObject(ResultSet result) {
        Auto auto = null;

        try {
            String naam = result.getString("naam");
            Boolean vies = result.getBoolean("vies");
            int wasTijd = result.getInt("wasTijd");
            int backId = result.getInt("id");

            auto = new Auto(backId, naam, vies, wasTijd);
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }

        return auto;
    }

    @Override
    public Auto GetSingle(int id) {
        String sql = "SELECT * FROM autos WHERE id = ?";
        Auto auto = null;

        try {
            PreparedStatement ex = Database.connect().prepareStatement(sql);
            ex.setInt(1, id);

            ResultSet resultSet = ex.executeQuery();

            while (resultSet.next()) {
                auto = CreateObject(resultSet);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            Database.disconnect();
        }

        return auto;
    }

    @Override
    public Auto GetSingleByWasplaatsId(int id) {
        String sql = "SELECT * FROM autos INNER JOIN wasplaatsauto ON wasplaatsauto.autoID = autos.ID WHERE wasplaatsauto.wasplaatsID = ?";
        Auto auto = null;

        try {
            PreparedStatement ex = Database.connect().prepareStatement(sql);
            ex.setInt(1, id);

            ResultSet resultSet = ex.executeQuery();

            while (resultSet.next()) {
                auto = CreateObject(resultSet);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            Database.disconnect();
        }

        return auto;
    }

    @Override
    public ArrayList<Auto> GetAll() {
        String sql = "SELECT * FROM autos";
        ArrayList<Auto> autos = new ArrayList<>();

        try {
            PreparedStatement ex = Database.connect().prepareStatement(sql);

            ResultSet resultSet = ex.executeQuery();

            while (resultSet.next()) {
                autos.add(CreateObject(resultSet));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            Database.disconnect();
        }

        return autos;
    }

    @Override
    public ArrayList<Auto> GetAll(boolean washed) {
        String sql = "";
        if (washed == true) {
            sql = "SELECT * FROM autos AS A inner join wasplaatsauto as WA on WA.autoID = A.id";
        } else {
            sql = "Select * from autos where (SELECT COUNT(*) FROM wasplaatsauto where autoID = autos.id) = 0";
        }

        ArrayList<Auto> autos = new ArrayList<>();

        try {
            PreparedStatement ex = Database.connect().prepareStatement(sql);

            ResultSet resultSet = ex.executeQuery();

            while (resultSet.next()) {
                autos.add(CreateObject(resultSet));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            Database.disconnect();
        }

        return autos;
    }

    @Override
    public void insert(Auto auto) {
        String sql = "INSERT INTO autos(naam, vies, wasTijd)VALUES(?,?,?)";

        try {
            PreparedStatement ex = Database.connect().prepareStatement(sql);
            ex.setString(1, auto.getNaam());
            ex.setBoolean(2, auto.isVies());
            ex.setInt(3, auto.getWasTijd());
            ex.executeUpdate();
        } catch (Exception var7) {
            var7.printStackTrace();
        } finally {
            Database.disconnect();
        }
    }

    @Override
    public void update(Auto auto) {
        String sql = "UPDATE autos SET naam = ?, vies = ?, wasTijd = ? WHERE id = ?";

        try {
            PreparedStatement ex = Database.connect().prepareStatement(sql);
            ex.setString(1, auto.getNaam());
            ex.setBoolean(2, auto.isVies());
            ex.setInt(3, auto.getWasTijd());
            ex.setInt(4, auto.getId());
            ex.executeUpdate();
        } catch (Exception var7) {
            var7.printStackTrace();
        } finally {
            Database.disconnect();
        }
    }

    @Override
    public void delete(Auto auto) {
        String sql = "DELETE FROM autos WHERE id = ?";

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

    public Auto GetLastByWasplaatsID(int id) {
        return null; // TODO
    }
}
