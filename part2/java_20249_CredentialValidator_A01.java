import java.util.HashMap;
import java.util.Map;

public class java_20249_CredentialValidator_A01 {

    private Map<String, String> credentials;

    public java_20249_CredentialValidator_A01() {
        credentials = new HashMap<>();
        // Add some default credentials
        credentials.put("admin", "password");
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
    }

    public boolean validateCredentials(String username, String password) {
        // If the username and password match one of the predefined credentials, return true
        // Otherwise, return false
        return credentials.get(username).equals(password);
    }
}

// Usage
public class Main {
    public static void main(String[] args) {
        CustomCredentialValidator validator = new CustomCredentialValidator();

        String username = "admin";
        String password = "password";

        if (validator.validateCredentials(username, password)) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}