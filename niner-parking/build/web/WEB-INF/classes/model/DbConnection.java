package model;


import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DbConnection {

    private static String dbURL = "jdbc:sqlserver://auxpskisql01.uncc.edu;" + 
            "databaseName=PARK_DB;user=unccap;password=CCounter3Signs2017!";
    private static Connection connection;

    public DbConnection() {
        try {
            // load the DB driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // get a DB connection
            connection = DriverManager.getConnection(dbURL);
        } catch (ClassNotFoundException ex) {
            System.out.println("ERROR: Driver not found");
            connection = null;

        } catch (SQLException ex) {
            System.out.println("ERROR: Could not create DB connection");
        }

    }

    public static Statement getNewStatement() {
        Statement statement;
        try {
            if (connection == null) {
                Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, "ERROR: Problem with DB connection: ");
                System.out.println("ERROR: Problem with DB connection:");
            }
            /* Creating a statement object that we can use for running
             * SQL statements commands against the database.*/
            statement = connection.createStatement();
        } catch (SQLException e) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, e);
            System.out.println("ERROR: Could not create SQL statement object: " + e);
            statement = null;
        }
        return statement;
    }

    public static Connection getConnection() {
        if (connection == null) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, "ERROR: Problem with DB connection: ");
            System.out.println("ERROR: Problem with DB connection:");
            return null;
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
