import java.util.HashMap;
import java.util.Map;

public class java_05865_CredentialValidator_A01 {

    // Predefined credentials
    private static final Map<String, String> credentials = new HashMap<>();

    static {
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
        credentials.put("user3", "password3");
    }

    // Constructor
    public java_05865_CredentialValidator_A01() {
        // Do nothing
    }

    // Method to validate the credentials
    public boolean validate(String username, String password) {
        // Check if the username and password match the predefined set
        return credentials.get(username).equals(password);
    }
}