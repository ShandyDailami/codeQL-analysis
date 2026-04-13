import java.util.HashMap;
import java.util.Map;

public class java_05236_CredentialValidator_A03 {
    private Map<String, String> credentials;

    public java_05236_CredentialValidator_A03() {
        credentials = new HashMap<>();
        credentials.put("admin", "password");
    }

    public boolean validateCredentials(String username, String password) {
        if (credentials.containsKey(username) && credentials.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}