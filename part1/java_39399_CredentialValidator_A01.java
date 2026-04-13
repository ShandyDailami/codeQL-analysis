import java.util.HashMap;
import java.util.Map;

public class java_39399_CredentialValidator_A01 {
    private Map<String, String> users = new HashMap<>();

    public java_39399_CredentialValidator_A01() {
        users.put("alice", "password1");
        users.put("bob", "password2");
        users.put("charlie", "password3");
    }

    public boolean validateCredentials(String username, String password) {
        // Check if the username exists in the database
        if (users.containsKey(username)) {
            // Check if the provided password matches the password in the database
            return users.get(username).equals(password);
        }

        return false;
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        boolean isValid = validator.validateCredentials("alice", "password1");
        if (isValid) {
            System.out.println("Logged in as Alice");
        } else {
            System.out.println("Invalid credentials");
        }

        isValid = validator.validateCredentials("bob", "wrongpassword");
        if (isValid) {
            System.out.println("Logged in as Bob");
        } else {
            System.out.println("Invalid credentials");
        }
    }
}