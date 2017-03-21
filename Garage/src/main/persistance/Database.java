package main.persistance;

import java.sql.*;

public class Database {
    private static Connection connection = connect();

    //connect database
    public static Connection connect() {
        if(connection == null){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                return DriverManager.getConnection("jdbc:mysql://studmysql01.fhict.local/dbi354261?autoReconnect=true&useSSL=false&useUnicode=true", "dbi354261", "EYECT4RAILS");
                //return Database.connection;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static void disconnect() {
        try {
            //connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
