public class java_02876_CredentialValidator_A08 {

    // User object to hold user credentials
    private User user;

    // Constructor for the validator
    public java_02876_CredentialValidator_A08(User user) {
        this.user = user;
    }

    // Method to validate user credentials
    public boolean validateCredentials() {
        // Check if username or password is empty
        if (user.getUsername().isEmpty() || user.getPassword().isEmpty()) {
            // If so, return false
            return false;
        }
        // If not, return true
        return true;
    }
}

public class User {

    private String username;
    private String password;

    // Getters and setters for username and password
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}