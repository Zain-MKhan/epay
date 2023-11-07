package business;

public class Customer {
    private String email;
    private String password;

    public Customer(String email, String password) {
        this.email = email;
        this.password = password;
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

    @Override
    public String toString() {
        return "User [email=" + email + ", password=" + password + "]";
    }
}
