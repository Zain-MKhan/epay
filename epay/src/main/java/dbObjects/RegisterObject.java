package dbObjects;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import business.User;
import connection.dbConnection;
import business.CustomUnmatchedIDException;
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
    try{

            dbConnection.beginTransaction(); 
            myQuery = "INSERT INTO customers (email, password) VALUES (?, ?);";
            preparedStatement = connection.prepareStatement(myQuery);
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getPassword());
            int rowsInserted = preparedStatement.executeUpdate();
            dbConnection.commitTransaction(); // Commit transaction
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return false;
        }
    }
}
