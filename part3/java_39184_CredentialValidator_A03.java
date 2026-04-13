import java.util.HashMap;
import java.util.Map;

public class java_39184_CredentialValidator_A03 {

    private Map<String, String> credentials;

    public java_39184_CredentialValidator_A03() {
        // Initialization of credentials in a map for simplicity
        this.credentials = new HashMap<String, String>();
        this.credentials.put("admin", "password");
    }

    public boolean validateCredentials(String username, String password) {
        // Assuming credentials are case-sensitive
        if (this.credentials.containsKey(username) &&
            this.credentials.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}