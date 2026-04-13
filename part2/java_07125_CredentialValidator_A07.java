import java.util.HashMap;
import java.util.Map;

public class java_07125_CredentialValidator_A07 {

    // Simulate a database of users and their passwords
    private Map<String, String> userDatabase = new HashMap<>();

    public java_07125_CredentialValidator_A07() {
        userDatabase.put("user1", "password1");
        userDatabase.put("user2", "password2");
        userDatabase.put("user3", "password3");
    }

    public boolean validateCredentials(String username, String password) {
        // Check if the user exists in the database
        if (userDatabase.containsKey(username)) {
            // Compare the entered password with the password in the database
            return userDatabase.get(username).equals(password);
        }
        return false;
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        boolean isValid = validator.validateCredentials("user1", "password1");

        if (isValid) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Login failed!");
        }
    }
}