import java.util.HashMap;
import java.util.Map;

public class java_23057_CredentialValidator_A01 {
    private Map<String, String> credentials;

    public java_23057_CredentialValidator_A01() {
        // Using a HashMap for simplicity, in a real application you would use a database
        credentials = new HashMap<>();
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
    }

    public boolean validateCredentials(String user, String password) {
        // In a real application, the password would not be sent in plain text,
        // and you would need to hash and salt the password
        return credentials.get(user) != null && credentials.get(user).equals(password);
    }
}

// Usage
public class Main {
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        boolean isValid = validator.validateCredentials("user1", "password1");

        if (isValid) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}