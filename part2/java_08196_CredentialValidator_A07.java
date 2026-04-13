import java.util.HashMap;
import java.util.Map;

public class java_08196_CredentialValidator_A07 {

    private Map<String, String> expectedCredentials;

    public java_08196_CredentialValidator_A07() {
        this.expectedCredentials = new HashMap<>();
        this.expectedCredentials.put("admin", "password");
    }

    public boolean validate(String username, String password) {
        if (expectedCredentials.containsKey(username) && expectedCredentials.get(username).equals(password)) {
            System.out.println("Authentication successful.");
            return true;
        } else {
            System.out.println("Authentication failed.");
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        validator.validate("admin", "password");  // Should succeed
        validator.validate("admin", "wrongpassword");  // Should fail
    }
}