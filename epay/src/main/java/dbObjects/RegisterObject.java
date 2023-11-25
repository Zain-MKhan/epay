package dbObjects;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import business.User;
import business.CustomUnmatchedIDException;

public class RegisterObject {

    private Connection connection;
    private String myQuery;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public RegisterObject(Connection connection) {
        this.connection = connection;
    }


    public boolean setCode(User user) throws SQLException {
           boolean result = false;
  

    try{
            myQuery = "INSERT INTO user" +"  (email, password, usertype) VALUES " +" (?,?,?);";
            preparedStatement = this.connection.prepareStatement(myQuery);
            preparedStatement.setInt(1, 1); //should we keep id or no
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getPermission());
            System.out.println(preparedStatement);
            resultSet = preparedStatement.executeQuery();

        //change later the exception
         throw new CustomUnmatchedIDException();
    
    }    catch (CustomUnmatchedIDException e) {
        System.out.println(e.getMessage());

      }
      return result;
}
}
