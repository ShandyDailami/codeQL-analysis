import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_09269_CredentialValidator_A08 {
    private Map<String, String> userCredentials = new HashMap<>();

    public java_09269_CredentialValidator_A08() {
        // Add some dummy users
        userCredentials.put("user1", hash("password1"));
        userCredentials.put("user2", hash("password2"));
    }

    public boolean validateCredentials(String user, String password) {
        String hashedPassword = hash(password);
        return userCredentials.get(user).equals(hashedPassword);
    }

    private String hash(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(input.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Validate user1
        boolean user1Validated = validator.validateCredentials("user1", "password1");
        System.out.println("Is user1 valid? " + user1Validated);

        // Validate user2
        boolean user2Validated = validator.validateCredentials("user2", "password2");
        System.out.println("Is user2 valid? " + user2Validated);
    }
}