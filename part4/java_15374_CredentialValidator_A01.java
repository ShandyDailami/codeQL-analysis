import java.util.HashMap;
import java.util.Map;

public class java_15374_CredentialValidator_A01 {

    // Define a map of known users and their passwords
    private Map<String, String> knownUsers;

    public java_15374_CredentialValidator_A01() {
        knownUsers = new HashMap<>();
        knownUsers.put("user1", "password1");
        knownUsers.put("user2", "password2");
        knownUsers.put("user3", "password3");
    }

    // CredentialValidator method
    public boolean validate(String username, String password) {
        // Check if the username and password are in the map
        if (knownUsers.containsKey(username) && knownUsers.get(username).equals(password)) {
            return true; // Credentials are valid
        } else {
            return false; // Credentials are invalid
        }
    }
}