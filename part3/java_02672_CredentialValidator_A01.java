import java.util.HashMap;
import java.util.Map;

public class java_02672_CredentialValidator_A01 {

    // Dummy data
    private static Map<String, String> userData = new HashMap<>();

    static {
        userData.put("user1", "password1");
        userData.put("user2", "password2");
        userData.put("user3", "password3");
    }

    public boolean validateCredentials(String username, String password) {
        if(userData.containsKey(username) && userData.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Test valid credentials
        System.out.println(validator.validateCredentials("user1", "password1")); // Should print true

        // Test invalid credentials
        System.out.println(validator.validateCredentials("user4", "password4")); // Should print false
    }
}