package business;

import java.util.ArrayList;
import java.util.List;

public class User {
    private long userId; // Unique identifier for the user
    private String username;
    private String email;
    private String password;
    private String permission;

    // Default constructor
    public User() {
        this.userId = 0;
        this.username = "defaultUsername";
        this.email = "email";
        this.password = "password";
        this.permission = "defaultrole";
    }

    // Constructor
       public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

     public User(String email, String password,String permission) {
        this.email = email;
        this.password = password;
        this.permission=permission;
    }
    public User(long userId, String username, String email, String password) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.password = password;
    }

      public User(long userId,String permission, String username, String email, String password) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.permission=permission;
        
    }

    // Copy constructor
    public User(User u, long userId, String username, String email, String password) {
        this.userId = u.userId;
        this.username = u.username;
        this.email = u.email;
        this.password = u.password;
    }

    // Getters and setters for attributes
    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Additional methods for user-related functionality
    public boolean authenticate(String inputPassword) {
        // Implement user authentication logic (e.g., compare inputPassword with stored
        // password)
        return this.password.equals(inputPassword);
    }

    // Other common user-related methods can be added as needed

    // toString to display all the pertinent info
    public String toString() {
        return "The [userId=" + userId + ", The username=" + username
                + ", The email=" + email + ", The password=" + password + "]";
    }

}