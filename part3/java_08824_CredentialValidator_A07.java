import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_08824_CredentialValidator_A07 {
    private Map<String, String> credentials;

    public java_08824_CredentialValidator_A07() {
        this.credentials = new HashMap<>();
        // Initializing with dummy credentials
        this.credentials.put("admin", Base64.getEncoder().encodeToString("admin:password".getBytes()));
        this.credentials.put("user1", Base64.getEncoder().encodeToString("user1:password1".getBytes()));
        this.credentials.put("user2", Base64.getEncoder().encodeToString("user2:password2".getBytes()));
    }

    public boolean validateCredentials(String username, String password) {
        if (credentials.containsKey(username) && credentials.get(username).equals(password)) {
            return true;
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        System.out.println(validator.validateCredentials("admin", "admin")); // Should print true
        System.out.println(validator.validateCredentials("user1", "password1")); // Should print true
        System.out.println(validator.validateCredentials("user3", "password3")); // Should print false
    }
}