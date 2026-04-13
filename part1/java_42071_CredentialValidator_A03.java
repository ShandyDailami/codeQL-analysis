// Import required libraries
import java.util.HashMap;
import java.util.Map;

// Define CredentialValidator interface
public interface CredentialValidator {
    boolean isValid(String username, String password);
}

// Define CredentialValidatorImpl class java_42071_CredentialValidator_A03 class CredentialValidatorImpl implements CredentialValidator {
    private Map<String, String> users;

    public Main() {
        users = new HashMap<>();
        users.put("user1", "password1");
        users.put("user2", "password2");
    }

    @Override
    public boolean isValid(String username, String password) {
        String expectedPassword = users.get(username);
        return expectedPassword != null && expectedPassword.equals(password);
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidatorImpl();

        if (validator.isValid("user1", "password1")) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}