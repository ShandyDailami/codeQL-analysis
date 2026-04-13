import java.util.HashMap;
import java.util.Map;

public class java_23026_CredentialValidator_A03 {

    private Map<String, String> credentials;

    public java_23026_CredentialValidator_A03() {
        this.credentials = new HashMap<>();
        // Add some dummy credentials
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
    }

    public boolean isValid(String user, String password) {
        return credentials.get(user) != null && credentials.get(user).equals(password);
    }
}

public class Main {

    public static void main(String[] args) {
        CustomValidator validator = new CustomValidator();

        // Valid credentials
        System.out.println(validator.isValid("user1", "password1")); // prints: true

        // Invalid credentials
        System.out.println(validator.isValid("user1", "invalid")); // prints: false
    }
}