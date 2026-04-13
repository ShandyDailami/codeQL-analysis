import java.util.HashMap;
import java.util.Map;

public class java_25947_CredentialValidator_A07 {

    private Map<String, String> userDatabase;

    public java_25947_CredentialValidator_A07() {
        this.userDatabase = new HashMap<>();
        userDatabase.put("user1", "password1"); // This is a placeholder, in a real-world application you'd want to use secure methods to store and verify user credentials.
    }

    public boolean validateCredentials(String username, String password) {
        // Check if the username exists in our database
        if (userDatabase.containsKey(username)) {
            // Check if the password is correct
            if (userDatabase.get(username).equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        System.out.println(validator.validateCredentials("user1", "password1")); // This should print true
        System.out.println(validator.validateCredentials("user2", "password1")); // This should print false
    }
}