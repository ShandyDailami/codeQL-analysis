import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_39160_CredentialValidator_A03 {

    private Map<String, String> credentials;

    public java_39160_CredentialValidator_A03() {
        // Hardcoded for simplicity. In a real application, this should come from secure storage or a database.
        this.credentials = new HashMap<>();
        this.credentials.put("admin", Base64.getEncoder().encodeToString("admin:admin".getBytes()));
        this.credentials.put("user1", Base64.getEncoder().encodeToString("user1:user1".getBytes()));
    }

    public boolean validateCredentials(String username, String password) {
        if (!this.credentials.containsKey(username)) {
            System.out.println("Invalid username");
            return false;
        }

        String storedPassword = this.credentials.get(username);
        String[] storedCredentials = new String(Base64.getDecoder().decode(storedPassword));

        if (!storedCredentials[1].equals(password)) {
            System.out.println("Invalid password");
            return false;
        }

        return true;
    }
}

// Usage
public class Main {
    public static void main(String[] args) {
        LegacyCredentialValidator validator = new LegacyCredentialValidator();

        // Validate admin credentials
        if (validator.validateCredentials("admin", "admin")) {
            System.out.println("Access granted to admin!");
        }

        // Validate user1 credentials
        if (validator.validateCredentials("user1", "user1")) {
            System.out.println("Access granted to user1!");
        }
    }
}