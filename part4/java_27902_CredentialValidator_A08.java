import java.util.HashMap;
import java.util.Map;

public class java_27902_CredentialValidator_A08 {

    // A map to store valid users and their passwords
    private Map<String, String> users;

    public java_27902_CredentialValidator_A08() {
        // Initialize users map
        users = new HashMap<>();
        users.put("user1", "password1");
        users.put("user2", "password2");
        users.put("user3", "password3");
    }

    // Method to validate username and password
    public boolean validate(String username, String password) {
        if (users.containsKey(username) && users.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}