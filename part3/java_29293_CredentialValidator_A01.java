import java.util.HashMap;
import java.util.Map;

public class java_29293_CredentialValidator_A01 {

    // Map of known users and their passwords
    private Map<String, String> userDatabase;

    public java_29293_CredentialValidator_A01() {
        userDatabase = new HashMap<>();
        // Add known users to the database
        userDatabase.put("user1", "password1");
        userDatabase.put("user2", "password2");
        userDatabase.put("user3", "password3");
    }

    // Validate the username and password
    public boolean validate(String username, String password) {
        if (userDatabase.containsKey(username) && userDatabase.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}