import java.util.HashMap;
import java.util.Map;

public class java_34712_CredentialValidator_A07 {
    // create a map to store credentials
    private Map<String, String> credentials = new HashMap<>();

    // constructor to initialize credentials
    public java_34712_CredentialValidator_A07() {
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
    }

    // method to validate credentials
    public boolean validateCredentials(String username, String password) {
        // check if username and password exist in the map
        if (credentials.containsKey(username) && credentials.get(username).equals(password)) {
            return true;
        }
        return false;
    }
}