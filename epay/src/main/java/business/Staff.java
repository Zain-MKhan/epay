package business;

public class Staff extends User{
    private String userName;
    private String password;

    public Staff(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public Staff() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User [userName=" + userName + ", password=" + password + "]";
    }
}
