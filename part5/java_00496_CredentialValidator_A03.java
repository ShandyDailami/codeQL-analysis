import java.util.HashMap;
import java.util.Map;

public class java_00496_CredentialValidator_A03 {

    private Map<String, String> credentials;

    public java_00496_CredentialValidator_A03() {
        // Initialize credentials as a HashMap
        credentials = new HashMap<>();

        // Add some default users for testing
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
        credentials.put("user3", "password3");
    }

    public boolean validate(String username, String password) {
        // Return true if credentials are valid, false otherwise
        if(credentials.containsKey(username) && credentials.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}