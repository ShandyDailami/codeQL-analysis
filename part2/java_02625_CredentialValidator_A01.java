import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_02625_CredentialValidator_A01 {
    private Map<String, String> credentials;

    public java_02625_CredentialValidator_A01() {
        // Initialize the credentials as a map, where the username is the key and the password is the value
        credentials = new HashMap<>();
        credentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        credentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    public boolean validateCredentials(String username, String password) {
        // Check if the password for the given username is correct
        if (credentials.containsKey(username)) {
            return Base64.getDecoder().decode(credentials.get(username)).equals(password.getBytes());
        }

        // If the username does not exist, return false
        return false;
    }
}