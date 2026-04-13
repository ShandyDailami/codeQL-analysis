import java.util.HashMap;
import java.util.Map;

public class java_15465_CredentialValidator_A03 {

    // A map to store the known passwords
    private Map<String, String> knownPasswords;

    // Constructor
    public java_15465_CredentialValidator_A03() {
        knownPasswords = new HashMap<>();
        knownPasswords.put("admin", "password");
        knownPasswords.put("user1", "password1");
        knownPasswords.put("user2", "password2");
    }

    // Method to validate the password
    public boolean validatePassword(String username, String password) {
        // Check if the password matches the known password
        return knownPasswords.get(username).equals(password);
    }

    public static void main(String[] args) {
        // Create a new validator
        LegacyCredentialValidator validator = new LegacyCredentialValidator();

        // Try to validate the password for the user 'admin'
        boolean isValid = validator.validatePassword("admin", "password");
        System.out.println("Is valid? " + isValid);

        // Try to validate the password for the user 'wrong'
        isValid = validator.validatePassword("wrong", "password");
        System.out.println("Is valid? " + isValid);
    }
}