package guestbook;

import java.sql.*;

public class GuestBookDB {

    String path = "jdbc:sqlite:visitors.db";

    public GuestBookDB() {
        try {
            Connection sqliteConnection = DriverManager.getConnection(path);

            //Skapa tabell för visitors om den inte finns
            String sql_create_tabel = "CREATE TABLE IF NOT EXISTS visitors(" +
                    "ID integer PRIMARY KEY," +
                    "Name TEXT);";

            Statement stmt = sqliteConnection.createStatement();
            stmt.execute(sql_create_tabel);
            stmt.close();
            sqliteConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addCustomer(String name) {
        try {
            Connection sqliteConnection = DriverManager.getConnection(path);

            //Lägg till en kund i tabellen visitors
            String sql_insert_customer = "INSERT INTO visitors(Name)" +
                    " VALUES('"+ name + "');";

            Statement stmt = sqliteConnection.createStatement();
            stmt.execute(sql_insert_customer);
            stmt.close();
            sqliteConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void close(){

    }




}

