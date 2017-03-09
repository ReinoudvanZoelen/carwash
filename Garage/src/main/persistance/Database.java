package main.persistance;

import java.sql.*;

public class Database {
    private Connection connection;

    //connect database
    public static Connection connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://studmysql01.fhict.local/dbi354261?autoReconnect=true&useSSL=false&useUnicode=true", "dbi354261", "EYECT4RAILS");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void disconnect() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
