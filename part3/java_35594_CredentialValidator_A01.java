import java.util.HashMap;
import java.util.Map;

public class java_35594_CredentialValidator_A01 {
    private Map<String, String> userCredentials;

    public java_35594_CredentialValidator_A01() {
        userCredentials = new HashMap<>();
        userCredentials.put("user1", "password1");
        userCredentials.put("user2", "password2");
    }

    public boolean validateAccess(String username, String password) {
        // We're assuming a broken access control mechanism where we check if a username and password
        // match our hardcoded map of usernames and passwords.

        // This is a very basic form of access control and should not be used in a real application.
        if (username.equals("admin") && password.equals("admin")) {
            return true;
        }

        String expectedPassword = userCredentials.get(username);
        return expectedPassword != null && expectedPassword.equals(password);
    }
}