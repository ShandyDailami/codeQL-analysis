import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_33153_CredentialValidator_A08 {

    // Credentials are stored in a map for simplicity. In a real-world scenario,
    // these would be stored in a database or some kind of persistent storage.
    private Map<String, String> credentials;

    public java_33153_CredentialValidator_A08() {
        this.credentials = new HashMap<>();
        this.credentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        this.credentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    public boolean validate(String username, String password) {
        // We're not actually checking the password here, but this is just to show how we might do it.
        // In a real-world scenario, passwords would never be stored in plain text and would be hashed.
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());

        if (credentials.containsKey(username) && credentials.get(username).equals(encodedPassword)) {
            return true;
        } else {
            return false;
        }
    }
}