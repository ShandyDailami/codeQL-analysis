import java.util.HashMap;
import java.util.Map;

public class java_33895_CredentialValidator_A01 {

    // Store user passwords in a map
    private Map<String, String> userPasswords = new HashMap<>();

    public java_33895_CredentialValidator_A01() {
        // Add some users for testing
        userPasswords.put("user1", "password1");
        userPasswords.put("user2", "password2");
    }

    public boolean validateCredentials(String username, String password) {
        // Return true if the username and password match, false otherwise
        return userPasswords.get(username).equals(hashPassword(password));
    }

    // This is a very simple password hashing function for demonstration purposes
    private String hashPassword(String password) {
        // In real world, you would use a more secure method of hashing passwords
        return password;
    }
}

// Example usage
public class Main {

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        if(validator.validateCredentials("user1", "password1")) {
            System.out.println("Access granted for user1");
        } else {
            System.out.println("Access denied for user1");
        }

        if(validator.validateCredentials("user2", "password2")) {
            System.out.println("Access granted for user2");
        } else {
            System.out.println("Access denied for user2");
        }
    }
}