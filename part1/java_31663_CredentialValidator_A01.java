import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_31663_CredentialValidator_A01 {
    private Map<String, String> credentials = new HashMap<>();

    public java_31663_CredentialValidator_A01() {
        credentials.put("admin", Base64.getEncoder().encodeToString("admin:admin".getBytes()));
        credentials.put("user", Base64.getEncoder().encodeToString("user:user".getBytes()));
    }

    public boolean validate(String username, String password) {
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        return credentials.get(username).equals(encodedPassword);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Username and password for valid user
        System.out.println(validator.validate("admin", "admin")); // prints: true

        // Username and password for invalid user
        System.out.println(validator.validate("admin", "wrongpassword")); // prints: false
    }
}