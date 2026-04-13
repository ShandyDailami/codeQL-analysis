import java.util.Arrays;

public class java_35378_CredentialValidator_A01 {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    // Using a simple array to hold the hard-coded credentials
    private String[][] credentials = {
            {"admin", "password"},
            {"user1", "password1"},
            {"user2", "password2"}
    };

    // The CredentialValidator is a public method that can be used to validate credentials
    public boolean validate(String username, String password) {
        // Check if the provided username and password match the hard-coded credentials
        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            return true;
        }

        // If the username and password do not match the hard-coded credentials, return false
        return false;
    }

    // A method to get the hard-coded credentials
    public String[][] getCredentials() {
        return credentials;
    }
}