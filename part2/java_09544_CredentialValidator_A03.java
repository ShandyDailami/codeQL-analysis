import java.util.HashMap;
import java.util.Map;

public class java_09544_CredentialValidator_A03 {
    // Store username and password pairs in a map
    private Map<String, String> userMap;

    public java_09544_CredentialValidator_A03() {
        userMap = new HashMap<>();
        userMap.put("user1", "password1");
        userMap.put("user2", "password2");
        userMap.put("user3", "password3");
    }

    public boolean validateCredentials(String username, String password) {
        // Check if the username and password match in the map
        if (userMap.containsKey(username) && userMap.get(username).equals(password)) {
            System.out.println("Credentials validated successfully");
            return true;
        } else {
            System.out.println("Invalid username or password");
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Validate user1's credentials
        validator.validateCredentials("user1", "password1"); // Should print "Credentials validated successfully"

        // Validate user4's credentials
        validator.validateCredentials("user4", "password4"); // Should print "Invalid username or password"
    }
}