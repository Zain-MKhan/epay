package dbObjects;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import business.Staff;

public class StaffObject {
    private Connection connection;
    private String myQuery;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public StaffObject(Connection connection) {
        this.connection = connection;
    }

    public Staff staffLogin(String userName, String password) {
        Staff staff = null;
        try {
            myQuery = "select * from staff where userName=? and password=?";
            preparedStatement = this.connection.prepareStatement(myQuery);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                staff = new Staff();
                staff.setUserName(resultSet.getString("userName"));
                staff.setPassword(resultSet.getString("password"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return staff;
    }

    public Staff staffLogin(String password) {
        Staff staff = null;
        try {
            myQuery = "select * from staff where password=?";
            preparedStatement = this.connection.prepareStatement(myQuery);
            preparedStatement.setString(1, password);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                staff = new Staff();
                staff.setUserName(resultSet.getString("userName"));
                staff.setPassword(resultSet.getString("password"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return staff;
    }

    public boolean createMember(String userName, String password) {
        try {
            myQuery = "INSERT INTO staff (userName, password) VALUES (?, ?)";
            preparedStatement = this.connection.prepareStatement(myQuery);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);

            int rowsAffected = preparedStatement.executeUpdate();

            return rowsAffected == 1;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean removeStaffMember(String userName) {
        try {
            myQuery = "DELETE FROM staff WHERE userName=?";
            preparedStatement = this.connection.prepareStatement(myQuery);
            preparedStatement.setString(1, userName);

            int rowsAffected = preparedStatement.executeUpdate();

            // If the query was successful and one row was affected, return true
            return rowsAffected == 1;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
