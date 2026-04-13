import java.util.HashMap;
import java.util.Map;

public class java_30893_CredentialValidator_A08 {

    // Create a HashMap to store user information.
    private Map<String, String> userMap;

    public java_30893_CredentialValidator_A08() {
        userMap = new HashMap<>();
    }

    // Add a user to the map.
    public void addUser(String username, String password) {
        userMap.put(username, password);
    }

    // Validate the provided user and password.
    public boolean validateUser(String username, String password) {
        // Check if the username and password are in the map.
        if (userMap.containsKey(username) && userMap.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}