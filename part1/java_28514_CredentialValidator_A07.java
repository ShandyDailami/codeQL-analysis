import java.util.HashMap;
import java.util.Map;

public class java_28514_CredentialValidator_A07 {
    // Create a map to store usernames and passwords
    private Map<String, String> userDatabase;

    public java_28514_CredentialValidator_A07() {
        // Initialize userDatabase
        userDatabase = new HashMap<>();
        userDatabase.put("user1", "password1");
        userDatabase.put("user2", "password2");
        userDatabase.put("user3", "password3");
    }

    public boolean validateCredentials(String username, String password) {
        // If username and password match the ones in the database
        if (userDatabase.get(username).equals(password)) {
            return true;
        }
        // If not, return false
        return false;
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Validate credentials
        if (validator.validateCredentials("user1", "password1")) {
            System.out.println("Access granted for user1");
        } else {
            System.out.println("Access denied for user1");
        }

        if (validator.validateCredentials("user4", "password4")) {
            System.out.println("Access granted for user4");
        } else {
            System.out.println("Access denied for user4");
        }
    }
}