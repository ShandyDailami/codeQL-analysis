public class java_00400_CredentialValidator_A01 {
    // Storing expected username and password
    private String expectedUsername;
    private String expectedPassword;

    // Constructor
    public java_00400_CredentialValidator_A01(String expectedUsername, String expectedPassword) {
        this.expectedUsername = expectedUsername;
        this.expectedPassword = expectedPassword;
    }

    // Method to validate the Credential
    public boolean validate(Credential credential) {
        // Check if the provided username and password match the expected ones
        if (credential.getUsername().equals(expectedUsername) 
            && credential.getPassword().equals(expectedPassword)) {
            return true;
        }
        return false;
    }
}

public class Credential {
    private String username;
    private String password;

    public java_00400_CredentialValidator_A01(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a new CredentialValidator
        CredentialValidator validator = new CredentialValidator("username", "password");

        // Create a new Credential
        Credential credential = new Credential("username", "password");

        // Validate the Credential
        if (validator.validate(credential)) {
            System.out.println("Access granted.");
        } else {
            System.out.println("Access denied.");
        }
    }
}