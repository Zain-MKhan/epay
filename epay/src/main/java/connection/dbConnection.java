package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnection {
    private static Connection connection = null;

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        // checking if there is existing connection, if not create one
        if (connection == null) {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // replace 'cocacola' with your own password for root in your mysql:
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/epay_db", "root", "cocacola");
            System.out.println("Successfully connected to epay_db!");
        }
        return connection;
    }
}
