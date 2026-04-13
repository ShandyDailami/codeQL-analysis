import java.util.HashMap;
import java.util.Map;

public class java_38889_CredentialValidator_A01 {
    private Map<String, String> credentials;

    public java_38889_CredentialValidator_A01() {
        this.credentials = new HashMap<>();
        this.credentials.put("admin", "password");
    }

    public boolean validateCredentials(String username, String password) {
        if (username == null || password == null) {
            return false;
        }

        if (this.credentials.containsKey(username) && this.credentials.get(username).equals(password)) {
            return true;
        }

        return false;
    }
}