import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class java_34891_CredentialValidator_A07 {

    // Simple in-memory credential store
    private static Map<String, String> credentialStore = new HashMap<>();

    // Static block to initialize the credentials
    static {
        credentialStore.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        credentialStore.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    // Method to validate the credential
    public Optional<String> validate(String user, String password) {
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        return Optional.ofNullable(credentialStore.get(user)).filter(pw -> pw.equals(encodedPassword));
    }

    // Main method for testing
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        Optional<String> user1 = validator.validate("user1", "password1");
        if (user1.isPresent()) {
            System.out.println("Credential Validation for user1 succeeded: " + user1.get());
        } else {
            System.out.println("Invalid Credentials for user1");
        }

        Optional<String> user2 = validator.validate("user2", "wrongpassword");
        if (user2.isPresent()) {
            System.out.println("Credential Validation for user2 succeeded: " + user2.get());
        } else {
            System.out.println("Invalid Credentials for user2");
        }
    }
}