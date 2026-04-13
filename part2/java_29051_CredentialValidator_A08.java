import java.security.Credential;
import java.security.AccessControlException;

public class java_29051_CredentialValidator_A08 {

    // Define a Credential object to hold the username and password
    private Credential credential;

    // Constructor to initialize the Credential object
    public java_29051_CredentialValidator_A08(String username, String password) {
        this.credential = new Credential() {
            public String getName() {
                return username;
            }
            public char[] getPassword() {
                return password.toCharArray();
            }
        };
    }

    // Method to validate the Credential
    public boolean validate(String enteredUsername, String enteredPassword) {
        // If the entered username and password match the stored username and password, return true
        // Otherwise, return false
        return enteredUsername.equals(credential.getName()) &&
                enteredPassword.equals(new String(credential.getPassword()));
    }
}