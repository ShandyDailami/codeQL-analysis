import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_23622_CredentialValidator_A03 {

    // A map to store username and password pairs
    private Map<String, String> credentials = new HashMap<>();

    // Add a new username and password pair
    public void addCredential(String username, String password) {
        credentials.put(username, password);
    }

    // Validate a username and password pair
    public boolean validateCredentials(String username, String password) {
        String correctPassword = credentials.get(username);
        return correctPassword != null && correctPassword.equals(password);
    }

    // Main method to test the CredentialValidator
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        validator.addCredential("user1", "password1");
        validator.addCredential("user2", "password2");

        System.out.println(validator.validateCredentials("user1", "password1")); // should print true
        System.out.println(validator.validateCredentials("user1", "wrongpassword")); // should print false
        System.out.println(validator.validateCredentials("user3", "password3")); // should print false
    }
}