public class java_36022_CredentialValidator_A01 {
    // The Credential object holds username and password
    private Credential credential;

    public java_36022_CredentialValidator_A01(Credential credential) {
        this.credential = credential;
    }

    // Check if the given password matches the credential
    public boolean isPasswordValid() {
        // Here you can put your actual logic to validate the password
        // For the sake of simplicity, let's assume the password is always valid
        return true;
    }

    // Method to authenticate the user
    public boolean authenticate(String username, String password) {
        if (isPasswordValid()) {
            // Assuming a successful login, return true
            return true;
        } else {
            // If password is invalid, return false
            return false;
        }
    }
}

public class Credential {
    private String username;
    private String password;

    public java_36022_CredentialValidator_A01(String username, String password) {
        this.username = username;
        this.password = password;
    }

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

// Usage
public class Main {
    public static void main(String[] args) {
        Credential credential = new Credential("user", "password");
        CredentialValidator validator = new CredentialValidator(credential);

        boolean isAuthenticated = validator.authenticate("user", "wrong_password");
        if (isAuthenticated) {
            System.out.println("Authentication successful!");
        } else {
            System.out.println("Authentication failed!");
        }
    }
}