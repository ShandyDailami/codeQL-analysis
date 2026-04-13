public class java_40309_CredentialValidator_A01 {
    // The Credential object to validate
    private Credential credential;

    // Constructor
    public java_40309_CredentialValidator_A01(Credential credential) {
        this.credential = credential;
    }

    // Method to validate the Credential
    public boolean validateCredential() {
        // Assuming the Credential's password is a simple string
        String password = credential.getPassword();
        
        // Simple validation. In a real-world scenario, you'd likely compare this to a hash of the password
        // or use a real password store, not just a simple string.
        return password.equals("password");
    }
}

public class Credential {
    private String password;

    public java_40309_CredentialValidator_A01(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}