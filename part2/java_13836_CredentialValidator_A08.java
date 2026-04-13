import java.util.HashMap;
import java.util.Map;

public class java_13836_CredentialValidator_A08 {

    // Use a HashMap to store credentials and passwords.
    private Map<String, String> credentials;

    public java_13836_CredentialValidator_A08() {
        this.credentials = new HashMap<>();
    }

    // Method to add a new credential.
    public void addCredential(String username, String password) {
        this.credentials.put(username, password);
    }

    // Method to authenticate a user.
    public boolean authenticate(String username, String password) {
        // Check if the credentials map contains the user.
        if (!this.credentials.containsKey(username)) {
            return false;
        }

        // Compare the stored password with the provided password.
        // If they match, return true, else return false.
        return this.credentials.get(username).equals(password);
    }

    // This method is used to create a static main method for testing purposes.
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        validator.addCredential("admin", "password");
        System.out.println(validator.authenticate("admin", "password")); // prints: true
        System.out.println(validator.authenticate("admin", "wrongPassword")); // prints: false
    }
}