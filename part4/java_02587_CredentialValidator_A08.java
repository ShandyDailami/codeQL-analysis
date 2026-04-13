public class java_02587_CredentialValidator_A08 {
    private String username;
    private String password;

    // Constructor
    public java_02587_CredentialValidator_A08(String username, String password) {
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
}

public class CredentialValidator {
    // Instance variable to store the valid credentials
    private Credential validCredential;

    // Constructor
    public java_02587_CredentialValidator_A08(String username, String password) {
        this.validCredential = new Credential(username, password);
    }

    // Method to check if the provided credentials match the valid ones
    public boolean validate(String username, String password) {
        if (this.validCredential.getUsername().equals(username) &&
            this.validCredential.getPassword().equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}