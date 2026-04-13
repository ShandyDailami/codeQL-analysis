import java.util.HashMap;
import java.util.Map;

public class java_20623_CredentialValidator_A07 {
    private Map<String, String> credentials;

    public java_20623_CredentialValidator_A07() {
        this.credentials = new HashMap<>();
        this.credentials.put("admin", "password");
    }

    public boolean validate(String username, String password) {
        if (credentials.containsKey(username) && credentials.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}