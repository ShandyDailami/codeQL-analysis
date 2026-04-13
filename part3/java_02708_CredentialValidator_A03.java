import java.util.HashMap;
import java.util.Map;

public class java_02708_CredentialValidator_A03 {

    // Hardcoded credentials for demonstration purposes
    private static final Map<String, String> hardcodedCredentials = new HashMap<>();

    static {
        hardcodedCredentials.put("user1", "password1");
        hardcodedCredentials.put("user2", "password2");
        // add more users as needed
    }

    // Method for authenticating a user
    public boolean authenticate(String username, String password) {
        if (hardcodedCredentials.containsKey(username) &&
            hardcodedCredentials.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }

}