package dbObjects;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import connection.dbConnection;
import business.Customer;

public class RegisterObject {

    private Connection connection;
    private String myQuery;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public RegisterObject(Connection connection) {
        super();
        this.connection = connection;
    }

    public boolean setCode(Customer user) throws SQLException {
        boolean result = false;
        try {

            dbConnection.beginTransaction();
            myQuery = "INSERT INTO customers (email, password, isStaff) VALUES (?, ?, ?);";
            preparedStatement = connection.prepareStatement(myQuery);
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getIsStaff());
            int rowsInserted = preparedStatement.executeUpdate();
            dbConnection.commitTransaction(); // Commit transaction
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean updateCode(Customer user) {
        try {
            dbConnection.beginTransaction(); // Begin transaction

            myQuery = "UPDATE customers SET password = ? WHERE email = ?";
            preparedStatement = connection.prepareStatement(myQuery);
            preparedStatement.setString(1, user.getPassword());
            preparedStatement.setString(2, user.getEmail());

            int rowsUpdated = preparedStatement.executeUpdate();

            dbConnection.commitTransaction(); // Commit transaction

            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return false;
        }
    }

}
