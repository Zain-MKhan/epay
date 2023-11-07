package dbObjects;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import business.Customer;

public class CustomerObject {
    private Connection connection;
    private String myQuery;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public CustomerObject(Connection connection) {
        this.connection = connection;
    }

    public Customer customerLogin(String email, String password) {
        Customer customer = null;
        try {
            myQuery = "select * from customers where email=? and password=?";
            preparedStatement = this.connection.prepareStatement(myQuery);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                customer = new Customer();
                customer.setEmail(resultSet.getString("email"));
                customer.setPassword(resultSet.getString("password"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customer;
    }
}
