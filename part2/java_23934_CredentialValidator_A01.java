import java.util.HashMap;
import java.util.Map;

public class java_23934_CredentialValidator_A01 {
    private Map<String, String> credentials;

    public java_23934_CredentialValidator_A01() {
        this.credentials = new HashMap<>();
        this.credentials.put("admin", "password");
    }

    public boolean validateCredentials(String username, String password) {
        if (credentials.containsKey(username) && credentials.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}