import java.util.HashMap;
import java.util.Map;

public class java_21924_CredentialValidator_A01 implements CredentialValidator {

    private Map<String, String> credentials = new HashMap<>();

    public java_21924_CredentialValidator_A01() {
        // Add some dummy credentials for the example
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
    }

    @Override
    public boolean validate(String username, String password) {
        // Validate the username and password using the dummy credentials
        if (credentials.containsKey(username) && credentials.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}