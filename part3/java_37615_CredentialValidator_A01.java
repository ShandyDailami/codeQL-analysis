import java.security.InvalidParameterException;

public class java_37615_CredentialValidator_A01 {

    // Constants
    private static final String USERNAME_REGEX = "^[a-zA-Z0-9_.+-]+$";
    private static final String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";

    // Attributes
    private String username;
    private String password;

    // Constructor
    public java_37615_CredentialValidator_A01(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    // Setters
    public void setUsername(String username) {
        if (username.matches(USERNAME_REGEX)) {
            this.username = username;
        } else {
            throw new InvalidParameterException("Invalid username format.");
        }
    }

    public void setPassword(String password) {
        if (password.matches(PASSWORD_REGEX)) {
            this.password = password;
        } else {
            throw new InvalidParameterException("Invalid password format.");
        }
    }

    // Method to validate credential
    public boolean validateCredential() {
        // Implement security sensitive operations here
        // For example:
        // return password.equals(encryptPassword(password));
        return true;
    }

    // Method to encrypt password
    private String encryptPassword(String password) {
        // Implement encryption logic here
        // For example:
        // return new StringBuilder(password).reverse().toString();
        return password;
    }
}