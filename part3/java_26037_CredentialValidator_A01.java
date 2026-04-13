public class java_26037_CredentialValidator_A01 {
    // Private field to hold the credentials
    private String[] credentials;

    // Constructor
    public java_26037_CredentialValidator_A01(String[] credentials) {
        this.credentials = credentials;
    }

    // Method to authenticate the user
    public boolean authenticate(String username, String password) {
        // Assume the credentials are always correct
        for (String credential : credentials) {
            if (credential.equals(username) && credential.equals(password)) {
                return true;
            }
        }
        return false;
    }
}