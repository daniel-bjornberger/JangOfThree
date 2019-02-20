package guestbook;

import requestpackage.Request;

import java.sql.*;

/** Class that loads the driver class and handles the connection to the database.
 * @author Joel Gunnarsson
 */


public class GuestBookDB {

    /** The database URL.
     */
    private final static String dbConnection = "jdbc:sqlite:" + System.getProperty("user.dir") + "\\Database1";

    /** The connection to the database.
     */
    private static Connection con;
    static {

        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }

    /** The method getCon returns the connection to the database.
     * @return The connection to the database.
     */
    public static Connection getCon() {
        return con;
    }

    /** Constructor
     */
    public GuestBookDB() {
        getConnection();
    }

    /** The method getConnection establishes a connection to the database.
     */
    private void getConnection() {

        try {
            con = DriverManager.getConnection(dbConnection);
        } catch (SQLException sqle) {
            System.err.println(sqle.getMessage());
        }
    }

    public static void closeConnection(){

        if ( con!= null) {
            try {
                con.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }

    /** The method hasConnection checks if a connection to the database has been established.
     * @return Boolean value, true if a connection was successfully established, fail if no connection has been established.
     */
    public boolean hasConnection(){
        if (con != null){
            return true;
        }
        else {
            return false;
        }
    }

    public static boolean callDb(Request request) {

        String firstname="Joel";
        String lastname="Gunnarsson";
        String messages="This is a messages";

        int rowCount = -1;

        String SQL = "INSERT INTO guestbook(firstname, lastname, message) VALUES(" +
                firstname + ", '" + lastname+ "', '" + messages + "');";


        if (getCon() != null) {

            try {
                Statement stm = getCon().createStatement();

                rowCount = stm.executeUpdate(SQL);

                stm.close();
            }
            catch (SQLException e) {
                System.err.println(e.getMessage());
            }

        }

        return rowCount == 1;

    }


}

