// Import necessary libraries
import java.util.HashMap;
import java.util.Map;

// Define the CredentialValidator interface
interface CredentialValidator {
    Map<String, String> validate(String username, String password);
}

// Define a class java_25526_CredentialValidator_A07 a simple credential validator
class SimpleCredentialValidator implements CredentialValidator {

    // A hardcoded map for user data
    private static final Map<String, String> USER_DATA = new HashMap<>();
    static {
        USER_DATA.put("user1", "password1");
        USER_DATA.put("user2", "password2");
        USER_DATA.put("user3", "password3");
    }

    // Validate the login credentials
    @Override
    public Map<String, String> validate(String username, String password) {
        Map<String, String> errors = new HashMap<>();

        // Check if username and password are correct
        if(!USER_DATA.containsKey(username) || !USER_DATA.get(username).equals(password)) {
            errors.put("username", "Invalid username or password");
        }

        return errors;
    }
}

// Main class to test the credential validator
public class Main {
    public static void main(String[] args) {
        // Create a credential validator
        CredentialValidator validator = new SimpleCredentialValidator();

        // Validate the login credentials
        Map<String, String> errors = validator.validate("user1", "password1");

        // Print out the errors
        if(!errors.isEmpty()) {
            System.out.println("Errors: " + errors);
        } else {
            System.out.println("Login successful");
        }
    }
}