import java.util.HashMap;
import java.util.Map;

public class java_04356_CredentialValidator_A01 {
    // In a real-world application, the credentials would be stored in a secure way (e.g., encrypted)
    private Map<String, String> credentials = new HashMap<>();

    public java_04356_CredentialValidator_A01() {
        // Add some dummy credentials for demonstration
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
        credentials.put("user3", "password3");
    }

    public boolean validateCredentials(String username, String password) {
        // This is a very basic implementation. In a real-world application,
        // we would want to use a more secure method to compare the passwords
        // and would also need to check for cases where the username or password may be null.
        // Also, we would want to handle the case where the username or password do not match our records.

        String expectedPassword = credentials.get(username);

        if (expectedPassword != null && expectedPassword.equals(password)) {
            return true;
        }

        return false;
    }
}