import java.util.HashMap;
import java.util.Map;

public class java_34328_CredentialValidator_A03 {
    // A simple map that stores user credentials
    private Map<String, String> userCredentials;

    // Constructor
    public java_34328_CredentialValidator_A03() {
        userCredentials = new HashMap<>();

        // Add some default users
        userCredentials.put("user1", "password1");
        userCredentials.put("user2", "password2");
    }

    // Method for authenticating a user
    public boolean authenticate(String username, String password) {
        // Check if the provided password matches the hashed password in the database
        return password.equals(userCredentials.get(username));
    }
}