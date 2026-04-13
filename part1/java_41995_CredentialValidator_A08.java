import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_41995_CredentialValidator_A08 {
    private Map<String, String> credentials;

    public java_41995_CredentialValidator_A08() {
        credentials = new HashMap<>();
        credentials.put("admin", Base64.getEncoder().encodeToString("admin:admin".getBytes()));
    }

    public boolean validate(String username, String password) {
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        return credentials.containsKey(username) && encodedPassword.equals(credentials.get(username));
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Validate with the default credentials
        System.out.println(validator.validate("admin", "admin")); // Outputs: true

        // Try to validate with incorrect credentials
        System.out.println(validator.validate("user", "wrongpassword")); // Outputs: false
    }
}