package business;

public class Customer extends User {
    private String email;
    private String password;
    private String isStaff;

    public Customer(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Customer(String email, String password, String isStaff) {
        this.email = email;
        this.password = password;
        this.isStaff = isStaff;
    }

    public Customer() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIsStaff() {
        return isStaff;
    }

    public void setIsStaff(String isStaff) {
        this.isStaff = isStaff;
    }

    @Override
    public String toString() {
        return "User [email=" + email + ", password=" + password + "]";
    }
}
