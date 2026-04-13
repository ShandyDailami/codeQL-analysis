import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_38483_CredentialValidator_A03 {
    private Map<String, String> userCredentials;

    public java_38483_CredentialValidator_A03() {
        this.userCredentials = new HashMap<>();
        userCredentials.put("user1", "password1");
        userCredentials.put("user2", "password2");
        userCredentials.put("user3", "password3");
    }

    public boolean isValidCredentials(String username, String password) {
        // Convert the password from base64 to plain text
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());

        // Validate the credentials
        return userCredentials.containsKey(username) && userCredentials.get(username).equals(encodedPassword);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        System.out.println(validator.isValidCredentials("user1", "password1")); // Should print: true
        System.out.println(validator.isValidCredentials("user1", "wrongPassword")); // Should print: false
    }
}