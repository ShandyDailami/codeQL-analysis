import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_04609_CredentialValidator_A01 {

    // Sample credentials
    private static Map<String, String> credentials = new HashMap<>();

    // Initialize credentials
    static {
        credentials.put("admin", Base64.getEncoder().encodeToString("admin:admin".getBytes()));
        credentials.put("user", Base64.getEncoder().encodeToString("user:user".getBytes()));
    }

    // Credential validator
    public boolean validate(String username, String password) {
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        return credentials.get(username).equals(encodedPassword);
    }

    // Main method for testing
    public static void main(String[] args) {
        CustomCredentialValidator validator = new CustomCredentialValidator();

        System.out.println("Valid Credentials: " + validator.validate("admin", "admin"));
        System.out.println("Valid Credentials: " + validator.validate("admin", "wrongpassword"));
        System.out.println("Invalid Credentials: " + validator.validate("user", "wrongpassword"));
    }
}