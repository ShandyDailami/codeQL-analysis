import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_16812_CredentialValidator_A08 {
    private Map<String, String> userCredentials;

    public java_16812_CredentialValidator_A08() {
        this.userCredentials = new HashMap<>();
        userCredentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        userCredentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    public boolean validateCredentials(String username, String password) {
        if (userCredentials.containsKey(username)) {
            byte[] decodedBytes = Base64.getDecoder().decode(userCredentials.get(username));
            return password.equals(new String(decodedBytes));
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Test valid credentials
        System.out.println(validator.validateCredentials("user1", "password1")); // Should print true
        System.out.println(validator.validateCredentials("user2", "password2")); // Should print true

        // Test invalid credentials
        System.out.println(validator.validateCredentials("user1", "wrongpassword")); // Should print false
        System.out.println(validator.validateCredentials("unknownuser", "password")); // Should print false
    }
}