import java.util.HashMap;
import java.util.Map;

public class java_23436_CredentialValidator_A07 {
    // A simple user store for testing
    private Map<String, String> userStore;

    public java_23436_CredentialValidator_A07() {
        userStore = new HashMap<>();
        userStore.put("user1", "password1");
        userStore.put("user2", "password2");
        userStore.put("user3", "password3");
    }

    public boolean validate(String username, String password) {
        if (userStore.containsKey(username) && userStore.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Test with valid credentials
        if (validator.validate("user1", "password1")) {
            System.out.println("Access granted for user1");
        } else {
            System.out.println("Access denied for user1");
        }

        // Test with invalid credentials
        if (validator.validate("user4", "password4")) {
            System.out.println("Access granted for user4");
        } else {
            System.out.println("Access denied for user4");
        }
    }
}