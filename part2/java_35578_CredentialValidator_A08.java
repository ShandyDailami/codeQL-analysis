import java.util.HashMap;
import java.util.Map;

public class java_35578_CredentialValidator_A08 {

    // Hardcoded username and password
    private static final Map<String, String> hardCodedCredentials = new HashMap<>();

    static {
        hardCodedCredentials.put("user1", "password1");
        hardCodedCredentials.put("user2", "password2");
    }

    // Method to validate credentials
    public boolean validateCredentials(String username, String password) {
        // Check if the username is in the hardcoded credentials map
        if (hardCodedCredentials.containsKey(username)) {
            // Check if the password is the same as the hardcoded password
            return hardCodedCredentials.get(username).equals(password);
        }
        return false;
    }
}