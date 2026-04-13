import java.util.HashMap;
import java.util.Map;

public class java_08239_CredentialValidator_A03 {

    // A map of users and their passwords
    private Map<String, String> credentials;

    // Initialize the credentials map
    public java_08239_CredentialValidator_A03() {
        this.credentials = new HashMap<>();
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
        this.credentials.put("user3", "password3");
    }

    // Method to validate the user's credentials
    public boolean validateCredentials(String username, String password) {
        // If the user exists in the map and the password is correct
        if (this.credentials.containsKey(username) && this.credentials.get(username).equals(password)) {
            return true;
        }

        // If the user doesn't exist in the map or the password is incorrect
        return false;
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Trying to login with valid credentials
        if (validator.validateCredentials("user1", "password1")) {
            System.out.println("User has successfully logged in!");
        } else {
            System.out.println("Invalid credentials!");
        }

        // Trying to login with invalid credentials
        if (validator.validateCredentials("user4", "wrongpassword")) {
            System.out.println("User has successfully logged in!");
        } else {
            System.out.println("Invalid credentials!");
        }
    }
}