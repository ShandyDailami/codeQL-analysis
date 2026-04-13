import java.util.HashMap;
import java.util.Map;

public class java_25279_CredentialValidator_A07 {

    // A map that simulates a database. It stores user credentials.
    private static Map<String, String> userDatabase = new HashMap<>();

    // Default constructor.
    public java_25279_CredentialValidator_A07() {
        // Adding default users to the database.
        userDatabase.put("user1", "password1");
        userDatabase.put("user2", "password2");
    }

    // Method to validate the credentials.
    public boolean validateCredentials(String user, String password) {
        // Check if the user exists in the database.
        if (userDatabase.containsKey(user)) {
            // Check if the password matches the one in the database.
            if (userDatabase.get(user).equals(password)) {
                // If both conditions are met, return true.
                return true;
            }
        }
        // If any condition is not met, return false.
        return false;
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Trying to login with valid credentials.
        boolean isLoggedIn = validator.validateCredentials("user1", "password1");
        if (isLoggedIn) {
            System.out.println("User has successfully logged in!");
        } else {
            System.out.println("Invalid credentials!");
        }

        // Trying to login with invalid credentials.
        isLoggedIn = validator.validateCredentials("user3", "password3");
        if (isLoggedIn) {
            System.out.println("User has successfully logged in!");
        } else {
            System.out.println("Invalid credentials!");
        }
    }
}