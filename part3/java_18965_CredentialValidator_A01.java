import java.util.HashMap;
import java.util.Map;

public class java_18965_CredentialValidator_A01 {

    private Map<String, String> credentials;

    public java_18965_CredentialValidator_A01() {
        this.credentials = new HashMap<>();
        this.credentials.put("admin", "password");
    }

    public boolean validateCredentials(String username, String password) {
        if (this.credentials.containsKey(username) && this.credentials.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    // You can add more methods to this class if needed for other operations
}