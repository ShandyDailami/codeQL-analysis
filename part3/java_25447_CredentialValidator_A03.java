import java.util.HashMap;
import java.util.Map;

public class java_25447_CredentialValidator_A03 {

    private Map<String, String> credentials;

    public java_25447_CredentialValidator_A03() {
        // Initialize the credentials
        this.credentials = new HashMap<String, String>();
        this.credentials.put("admin", "password");
    }

    public boolean validate(String username, String password) {
        // Verify the credentials
        if (this.credentials.containsKey(username) && this.credentials.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}