public class java_32973_CredentialValidator_A03 {
    // Define a Credential object
    private Credential credential;

    public java_32973_CredentialValidator_A03() {
        // Initialize the Credential object
        credential = new Credential();
    }

    public boolean validateCredentials(String username, String password) {
        // Validate the credentials
        if (credential.getUsername().equals(username) &&
                credential.getPassword().equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}

public class Credential {
    private String username;
    private String password;

    public java_32973_CredentialValidator_A03() {
        // Initialize the credentials with default values
        this.username = "admin";
        this.password = "password";
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}