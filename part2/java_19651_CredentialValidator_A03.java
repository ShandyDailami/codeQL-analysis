import java.util.HashMap;
import java.util.Map;

public class java_19651_CredentialValidator_A03 {
    private Map<String, String> credentials = new HashMap<>();

    public java_19651_CredentialValidator_A03() {
        credentials.put("admin", "password"); // Adding dummy credentials
    }

    public boolean isValidCredentials(String username, String password) {
        if (credentials.containsKey(username) && credentials.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}