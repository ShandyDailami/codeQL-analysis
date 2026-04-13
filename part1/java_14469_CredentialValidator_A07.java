import java.util.HashMap;

public class java_14469_CredentialValidator_A07 {

    // UserCredentials is a simple data container for holding user credentials.
    private HashMap<String, String> userCredentials;

    public java_14469_CredentialValidator_A07() {
        userCredentials = new HashMap<>();
    }

    // Method to add user credentials.
    public void addCredential(String username, String password) {
        userCredentials.put(username, password);
    }

    // Method to authenticate a user.
    public boolean authenticate(String username, String password) {
        // Check if the username and password exist in our credentials.
        // Note: This is a very basic form of authentication and should not be used in a real application.
        if (userCredentials.containsKey(username) && userCredentials.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    // Method to validate authentication.
    public String validateAuthentication(String username, String password) {
        if (authenticate(username, password)) {
            return "Successfully authenticated.";
        } else {
            return "Failed to authenticate.";
        }
    }
}