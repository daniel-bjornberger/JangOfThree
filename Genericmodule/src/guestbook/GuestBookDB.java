package guestbook;

import java.sql.*;
import java.util.ArrayList;

public class GuestBookDB {

    String path = "jdbc:sqlite:visitors.db";

    public GuestBookDB() {

        /**
         * @author Joel Gunnarsson
         */

        try {
            Connection sqliteConnection = DriverManager.getConnection(path);


            String sqlstart = "CREATE TABLE IF NOT EXISTS visitors(" +
                    "ID integer PRIMARY KEY," +
                    "firstname TEXT," +
                    "messages TEXT);";

            Statement stmt = sqliteConnection.createStatement();
            stmt.execute(sqlstart);
            stmt.close();
            sqliteConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addVisitor(String firstname,String messages) {
        try {
            Connection sqliteConnection = DriverManager.getConnection(path);


            String sqlInsert = "INSERT INTO visitors(firstname,messages)" +
                    " VALUES('"+ firstname + "','"+ messages + "');";

            Statement stmt = sqliteConnection.createStatement();
            stmt.execute(sqlInsert);
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

            String sqlSelect= "SELECT * FROM visitors";


            Statement stmt = sqliteConnection.createStatement();

            ResultSet rs = stmt.executeQuery(sqlSelect);

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

