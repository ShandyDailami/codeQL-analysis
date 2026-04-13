import java.util.HashMap;
import java.util.Map;

public class java_01459_CredentialValidator_A01 {

    private Map<String, String> credentials;

    public java_01459_CredentialValidator_A01() {
        this.credentials = new HashMap<>();
        this.credentials.put("admin", "password");
    }

    public boolean validateCredentials(String username, String password) {
        if (credentials.containsKey(username) && credentials.get(username).equals(password)) {
            System.out.println("Access granted for " + username);
            return true;
        } else {
            System.out.println("Access denied for " + username);
            return false;
        }
    }

    public static void main(String[] args) {
        LegacyCredentialValidator validator = new LegacyCredentialValidator();
        validator.validateCredentials("admin", "password");
        validator.validateCredentials("admin", "wrongpassword");
    }
}