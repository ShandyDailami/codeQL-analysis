import java.util.Base64;

public class java_17998_CredentialValidator_A08 {
    private String username;
    private String password;

    // Default Constructor
    public java_17998_CredentialValidator_A08() {
        this.username = "user";
        this.password = "password";
    }

    // Parameterized Constructor
    public java_17998_CredentialValidator_A08(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters and Setters
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Method to validate the credentials
    public boolean validate(String providedUsername, String providedPassword) {
        return (this.username.equals(providedUsername) && this.password.equals(providedPassword));
    }

    public static void main(String[] args) {
        // Test the CredentialValidator
        CredentialValidator validator = new CredentialValidator("admin", "password");
        System.out.println(validator.validate("admin", "password")); // Should print: true
        System.out.println(validator.validate("wrongUser", "password")); // Should print: false
        System.out.println(validator.validate("admin", "wrongPassword")); // Should print: false
    }
}