import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_14751_CredentialValidator_A07 {
    private Map<String, String> credentials;

    public java_14751_CredentialValidator_A07() {
        this.credentials = new HashMap<>();
        // Add some default credentials
        this.credentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        this.credentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    public boolean validate(String username, String password) {
        if (credentials.containsKey(username) && credentials.get(username).equals(password)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        System.out.println(validator.validate("user1", "password1")); // Expected output: true
        System.out.println(validator.validate("user3", "password1")); // Expected output: false
    }
}