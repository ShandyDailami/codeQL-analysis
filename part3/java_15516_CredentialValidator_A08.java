import java.security.InvalidParameterException;

public class java_15516_CredentialValidator_A08 {
    private String username;
    private String password;

    // default constructor
    public java_15516_CredentialValidator_A08() {
        this.username = "";
        this.password = "";
    }

    // parameterized constructor
    public java_15516_CredentialValidator_A08(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setUsername(String username) {
        if (username == null || username.isEmpty()) {
            throw new InvalidParameterException("Username cannot be null or empty");
        }
        this.username = username;
    }

    public void setPassword(String password) {
        if (password == null || password.isEmpty()) {
            throw new InvalidParameterException("Password cannot be null or empty");
        }
        this.password = password;
    }

    public boolean validateCredentials() {
        // This is a placeholder for a method that checks if the username and password are valid
        // It's not actually security-sensitive, but it's a start to get you started in a Legacy style program
        return this.username.equals("admin") && this.password.equals("password");
    }
}