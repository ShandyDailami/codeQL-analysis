import java.util.HashMap;
import java.util.Map;

public class java_10180_CredentialValidator_A03 {

    // A map of valid usernames and passwords
    private Map<String, String> validCredentials;

    public java_10180_CredentialValidator_A03() {
        validCredentials = new HashMap<>();
        validCredentials.put("user1", "password1");
        validCredentials.put("user2", "password2");
        validCredentials.put("user3", "password3");
    }

    public boolean validateCredentials(String username, String password) {
        // If the username and password match the ones in the map, return true
        // Otherwise, return false
        if (validCredentials.containsKey(username) && validCredentials.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    // You could also add additional methods to add new valid credentials or remove existing ones
}