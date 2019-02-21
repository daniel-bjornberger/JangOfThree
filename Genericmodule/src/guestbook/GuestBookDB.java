package guestbook;

import java.sql.*;
import java.util.ArrayList;

public class GuestBookDB {

    String path = "jdbc:sqlite:visitors.db";

    public GuestBookDB() {
        try {
            Connection sqliteConnection = DriverManager.getConnection(path);

            //Skapa tabell för visitors om den inte finns
            String sql_create_tabel = "CREATE TABLE IF NOT EXISTS visitors(" +
                    "ID integer PRIMARY KEY," +
                    "firstname TEXT," +
                    "messages TEXT);";

            Statement stmt = sqliteConnection.createStatement();
            stmt.execute(sql_create_tabel);
            stmt.close();
            sqliteConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addVisitor(String firstname,String messages) {
        try {
            Connection sqliteConnection = DriverManager.getConnection(path);

            //Lägg till en kund i tabellen visitors
            String sql_insert_customer = "INSERT INTO visitors(firstname,messages)" +
                    " VALUES('"+ firstname + "','"+ messages + "');";

            Statement stmt = sqliteConnection.createStatement();
            stmt.execute(sql_insert_customer);
            stmt.close();
            sqliteConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList findAllVisitors() {
    Visitors visitors;
    ArrayList<Visitors> visitorList= new ArrayList <Visitors> ();

        try {
            Connection sqliteConnection = DriverManager.getConnection(path);

            //Hämta alla besökare
            String sql_select_customer = "SELECT * FROM visitors";
            System.out.println(sql_select_customer);

            Statement stmt = sqliteConnection.createStatement();

            ResultSet rs = stmt.executeQuery(sql_select_customer);

            while (rs.next()) {
                visitorList.add(visitors = new Visitors(rs.getString("firstname"), rs.getString("messages")));
            }
            rs.close();
            stmt.close();
            sqliteConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return visitorList;
    }

    public void close(){

    }




}

