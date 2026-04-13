import java.util.HashMap;
import java.util.Map;

public class java_38533_CredentialValidator_A01 {
    private Map<String, String> credentials;

    public java_38533_CredentialValidator_A01() {
        // Add some default credentials.
        credentials = new HashMap<String, String>();
        credentials.put("admin", "password");
    }

    public boolean validateCredentials(String username, String password) {
        // If the username and password match our predefined set of credentials, return true.
        // Otherwise, return false.
        if (credentials.containsKey(username) && credentials.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}