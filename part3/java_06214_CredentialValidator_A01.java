import java.util.HashMap;
import java.util.Map;

public class java_06214_CredentialValidator_A01 {

    private Map<String, String> credentials;

    public java_06214_CredentialValidator_A01() {
        // Initialize credentials in a secure manner
        credentials = new HashMap<>();
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
        // In a real-world application, the credentials should be stored securely
    }

    public boolean validateCredentials(String user, String password) {
        // Use a secure hash function (like SHA-256) to compare the hash of the password
        // with the hash of the stored password
        // In a real-world application, this should be done securely as well
        String expectedPassword = credentials.get(user);
        if (expectedPassword != null && expectedPassword.equals(password)) {
            return true;
        }
        return false;
    }
}