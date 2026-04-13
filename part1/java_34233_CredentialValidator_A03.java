import java.util.HashMap;
import java.util.Map;

public class java_34233_CredentialValidator_A03 {
    public static void main(String[] args) {
        Map<String, String> credentials = new HashMap<>();
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
        // Add more credentials as needed...

        CredentialValidator validator = new CredentialValidator(credentials);

        // Usage example:
        if (validator.validateCredentials("user1", "password1")) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}