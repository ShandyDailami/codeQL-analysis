// Class for Credential
public class java_38625_CredentialValidator_A01 {
    private String username;
    private String password;

    public java_38625_CredentialValidator_A01(String username, String password) {
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

    // Method for validating credentials
    public boolean validate() {
        // For now, we'll just check if the username and password is not empty
        // You should probably use a more secure way of checking credentials
        return !(getUsername().isEmpty() || getPassword().isEmpty());
    }
}

// CredentialValidator class
public class CredentialValidator {
    // Method to validate credentials
    public boolean validateCredential(Credential credential) {
        if (credential == null) {
            throw new IllegalArgumentException("Credential cannot be null");
        }
        return credential.validate();
    }
}