package dbObjects;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import business.Customer;
import connection.dbConnection;

import java.io.FileReader;
//The following imports are for json customer authentication:
import java.nio.file.Files;
import java.nio.file.Paths;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

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
        // String json = "";
        try {

            // ******THE FOLLOWING IS IF WE WANT TO CHECK DATABASE AND NOT JSON FILE******
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
            // ***************************************************************************

            // ************THE FOLLOWING IS IF WE WANT TO CHECK THE JSON FILE*************
            // // Read the JSON file into a string
            // String filePath = "CustomerPasswords.json";
            // String json = new String(
            // Files.readAllBytes(Paths.get(getClass().getClassLoader().getResource(filePath).toURI())));

            // JsonElement element = JsonParser.parseString(json);
            // JsonArray jsonArray = element.getAsJsonArray();

            // for (JsonElement user : jsonArray) {
            // JsonObject jsonObject = user.getAsJsonObject();
            // String storedEmail = jsonObject.get("email").getAsString();
            // String storedPassword = jsonObject.get("password").getAsString();

            // if (email.equals(storedEmail) && password.equals(storedPassword)) {
            // customer = new Customer();
            // customer.setEmail(email);
            // customer.setPassword(password);
            // break;
            // }
            // }
            // ***************************************************************************

        } catch (Exception e) {
            e.printStackTrace();
        }
        return customer;
    }

    public Customer customerLogin(String password) {
        Customer customer = null;
        try {
            myQuery = "select * from customers where password=?";
            preparedStatement = this.connection.prepareStatement(myQuery);
            preparedStatement.setString(1, password);
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

    public String getPassword(String email) {
        String password = null;
        try {
            myQuery = "SELECT password FROM customers WHERE email=?";
            preparedStatement = this.connection.prepareStatement(myQuery);
            preparedStatement.setString(1, email);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                password = resultSet.getString("password");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return password;
    }

    public void grantStaffPrivileges(String email) {
        try {
            dbConnection.beginTransaction();

            myQuery = "UPDATE customers SET isStaff = ? WHERE email = ?";
            preparedStatement = this.connection.prepareStatement(myQuery);
            preparedStatement.setString(1, "true");
            preparedStatement.setString(2, email);
            preparedStatement.executeUpdate();

            dbConnection.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void revokeStaffPrivileges(String email) {
        try {
            dbConnection.beginTransaction();

            myQuery = "UPDATE customers SET isStaff = ? WHERE email = ?";
            preparedStatement = this.connection.prepareStatement(myQuery);
            preparedStatement.setString(1, "false");
            preparedStatement.setString(2, email);
            preparedStatement.executeUpdate();

            dbConnection.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Customer> allCustomers() {
        List<Customer> customerList = new ArrayList<>();

        try {
            myQuery = "select * from customers";
            preparedStatement = this.connection.prepareStatement(myQuery);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Customer customer = new Customer();
                customer.setEmail(resultSet.getString("email"));
                customer.setPassword(resultSet.getString("password"));
                customer.setIsStaff(resultSet.getString("isStaff"));

                customerList.add(customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return customerList;
    }

}
