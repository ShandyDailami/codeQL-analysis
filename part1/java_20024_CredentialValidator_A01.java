import java.util.HashMap;
import java.util.Map;

public class java_20024_CredentialValidator_A01 {

    // In a real-world application, this data would be retrieved from a database or other source.
    private Map<String, String> userCredentials;

    public java_20024_CredentialValidator_A01() {
        userCredentials = new HashMap<>();
        userCredentials.put("user1", "password1");
        userCredentials.put("user2", "password2");
    }

    public boolean validateCredentials(String username, String password) {
        // In a real-world application, you should use a secure hashing method to compare the passwords.
        // In this example, we're just checking if the passwords match.
        return userCredentials.get(username).equals(password);
    }
}