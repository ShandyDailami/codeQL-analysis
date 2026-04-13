import java.util.HashMap;
import java.util.Map;

public class java_13394_CredentialValidator_A08 {
    private Map<String, String> credentials;

    public java_13394_CredentialValidator_A08() {
        credentials = new HashMap<>();
        credentials.put("admin", "password");
    }

    public boolean validate(String username, String password) {
        if (credentials.containsKey(username) && credentials.get(username).equals(password)) {
            System.out.println("Authentication successful.");
            return true;
        } else {
            System.out.println("Authentication failed.");
            return false;
        }
    }
}