import java.util.HashMap;
import java.util.Map;

public class java_41966_CredentialValidator_A03 {

    // Create a map to hold credentials
    private Map<String, String> credentials;

    public java_41966_CredentialValidator_A03() {
        this.credentials = new HashMap<>();

        // Add sample credentials
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
    }

    // Method to validate a credential
    public boolean validateCredential(String username, String password) {
        if(this.credentials.containsKey(username) && this.credentials.get(username).equals(password)) {
            System.out.println("Credentials validated successfully!");
            return true;
        } else {
            System.out.println("Credentials do not match!");
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Try to validate a user's credential
        validator.validateCredential("user1", "password1"); // should print "Credentials validated successfully!"
        validator.validateCredential("user3", "password3"); // should print "Credentials do not match!"
    }
}