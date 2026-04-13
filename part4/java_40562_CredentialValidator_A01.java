import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_40562_CredentialValidator_A01 {
    // Store credentials in a HashMap.
    private Map<String, String> credentials;

    public java_40562_CredentialValidator_A01() {
        credentials = new HashMap<>();
        // Add sample credentials.
        credentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        credentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    public boolean validate(String user, String password) {
        // Check if the user exists in the map.
        if (credentials.containsKey(user)) {
            // If so, compare the encoded passwords.
            if (credentials.get(user).equals(Base64.getEncoder().encodeToString(password.getBytes()))) {
                return true;
            }
        }
        // If not, return false.
        return false;
    }
}