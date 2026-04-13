import java.security.InvalidParameterException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_04316_CredentialValidator_A07 {

    // This should be a secure hash stored in a database
    private Map<String, String> users = new HashMap<>();

    public java_04316_CredentialValidator_A07() {
        // Add some dummy users
        users.put("alice", Base64.getEncoder().encodeToString("alice".getBytes()));
        users.put("bob", Base64.getEncoder().encodeToString("bob".getBytes()));
    }

    public boolean authenticate(String username, String password) {
        if (users.containsKey(username) && users.get(username).equals(password)) {
            return true;
        } else {
            throw new InvalidParameterException("Invalid username or password");
        }
    }
}