import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_26458_CredentialValidator_A08 {

    // Static map to hold the credentials
    private static Map<String, String> credentials = new HashMap<>();

    // Initialize static block to fill credentials map
    static {
        credentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        credentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    // Method to validate the credential
    public boolean validateCredential(String username, String password) {
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        return encodedPassword.equals(credentials.get(username));
    }

    // Main method to test the class
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        System.out.println(validator.validateCredential("user1", "password1")); // Outputs: true
        System.out.println(validator.validateCredential("user1", "wrongpassword")); // Outputs: false
        System.out.println(validator.validateCredential("user2", "password2")); // Outputs: true
        System.out.println(validator.validateCredential("user3", "password3")); // Outputs: false
    }
}