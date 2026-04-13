import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_21340_CredentialValidator_A01 {

    private Map<String, String> credentials;

    public java_21340_CredentialValidator_A01() {
        // Create dummy credentials for the example.
        // This should ideally come from a secure source.
        this.credentials = new HashMap<>();
        this.credentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        this.credentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    public boolean validateCredentials(String username, String password) {
        // Decode the password and compare it to the stored one.
        // Note: This is a very simplistic example and should not be used in a real application.
        byte[] storedPassword = Base64.getDecoder().decode(this.credentials.get(username));
        return password.equals(new String(storedPassword));
    }

    public static void main(String[] args) {
        // Create a new instance of the validator.
        LegacyCredentialValidator validator = new LegacyCredentialValidator();

        // Try to validate the credentials.
        boolean isValid = validator.validateCredentials("user1", "password1");
        System.out.println("Is valid? " + isValid);

        isValid = validator.validateCredentials("user2", "password2");
        System.out.println("Is valid? " + isValid);
    }
}