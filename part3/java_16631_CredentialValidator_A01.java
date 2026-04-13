import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_16631_CredentialValidator_A01 {

    // Static map to hold users and their passwords.
    private static Map<String, String> userDB = new HashMap<>();

    // Static block to initialize userDB map.
    static {
        userDB.put("alice", "password1");
        userDB.put("bob", "password2");
        userDB.put("charlie", "password3");
    }

    // Main method for testing.
    public static void main(String[] args) {
        new CredentialValidator().validate("alice", "password1");
        new CredentialValidator().validate("bob", "password2");
        new CredentialValidator().validate("charlie", "password3");
        new CredentialValidator().validate("dave", "wrongpassword");
    }

    // Method to validate username and password.
    public void validate(String username, String password) {
        // Check if password is correct.
        if (userDB.get(username).equals(password)) {
            System.out.println("Access granted to user: " + username);
        } else {
            System.out.println("Access denied for user: " + username);
        }
    }
}