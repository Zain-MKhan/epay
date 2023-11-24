package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnection {
    private static Connection connection = null;

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        // checking if there is an existing connection, if not create one
        if (connection == null) {
            Class.forName("org.sqlite.JDBC");

            // *** CHANGE TO YOUR OWN ABSOLUTE PATH: ***
            // due to read/write issues,
            // copy 'epay.db' (soen387\epay.db) to your machine and include that path below:
            connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Ashiqur\\Desktop\\epay\\epay\\soen387\\epay.db");

            System.out.println("Successfully connected to SQLite database!");
        }
        return connection;
    }

    public static void closeConnection() throws SQLException {
        if (connection != null) {
            connection.close();
            System.out.println("Connection closed.");
        }
    }

    public static void beginTransaction() throws SQLException {
        if (connection != null) {
            connection.setAutoCommit(false);
            System.out.println("Transaction started.");
        }
    }

    public static void commitTransaction() throws SQLException {
        if (connection != null) {
            connection.commit();
            connection.setAutoCommit(true);
            System.out.println("Transaction committed.");
        }
    }
}

// CONNECTION FOR MYSQL:
// public class dbConnection {
// private static Connection connection = null;

// public static Connection getConnection() throws ClassNotFoundException,
// SQLException {
// // checking if there is existing connection, if not create one
// if (connection == null) {
// Class.forName("com.mysql.cj.jdbc.Driver");

// // replace 'cocacola' with your own password for root in your mysql:
// connection =
// DriverManager.getConnection("jdbc:mysql://localhost:3306/epay_db", "root",
// "cocacola");
// System.out.println("Successfully connected to epay_db!");
// }
// return connection;
// }
// }
