import java.util.HashMap;
import java.util.Map;

public class java_38205_CredentialValidator_A08 {
    // A map to store the rules
    private Map<String, String> rules = new HashMap<>();

    public java_38205_CredentialValidator_A08() {
        // Initialize the rules
        rules.put("user1", "password1");
        rules.put("user2", "password2");
        rules.put("user3", "password3");
    }

    // A method to validate a username and password
    public boolean validate(String username, String password) {
        // Check if the username and password match the rules
        if (rules.containsKey(username) && rules.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}