import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_38658_CredentialValidator_A03 {

    // Storing all valid credentials
    private static final Map<String, String> VALID_CREDENTIALS = new HashMap<>();

    // Static block to initialize the valid credentials map
    static {
        VALID_CREDENTIALS.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        VALID_CREDENTIALS.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    // Method to validate a user's credentials
    public boolean validate(String username, String password) {
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        return VALID_CREDENTIALS.get(username).equals(encodedPassword);
    }
}