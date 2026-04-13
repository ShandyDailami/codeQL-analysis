import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class java_27271_CredentialValidator_A07 {
    private Map<String, String> credentials = new HashMap<>();

    public java_27271_CredentialValidator_A07() {
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
        credentials.put("user3", "password3");
    }

    public boolean validateCredentials(String username, String password) {
        String expectedPassword = credentials.get(username);
        return password.equals(expectedPassword);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        System.out.println(validator.validateCredentials("user1", "password1")); // Outputs: true
        System.out.println(validator.validateCredentials("user1", "wrongpassword")); // Outputs: false
        System.out.println(validator.validateCredentials("nonexistentuser", "anypassword")); // Outputs: false
    }
}