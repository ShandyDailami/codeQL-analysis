public class java_32642_CredentialValidator_A07 {

    // Static credentials for testing
    private static final String USERNAME = "test";
    private static final String PASSWORD = "test";

    // Real credentials should be stored in a secure way in a real application
    private String storedUsername;
    private String storedPassword;

    // Default constructor for testing
    public java_32642_CredentialValidator_A07() {
        this.storedUsername = USERNAME;
        this.storedPassword = PASSWORD;
    }

    // Real constructor with actual credentials
    public java_32642_CredentialValidator_A07(String username, String password) {
        this.storedUsername = username;
        this.storedPassword = password;
    }

    public boolean validate(String username, String password) {
        return (username.equals(storedUsername) && password.equals(storedPassword));
    }
}