package dbObjects;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import business.Customer;

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
}
