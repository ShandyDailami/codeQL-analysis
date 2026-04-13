import java.util.HashMap;
import java.util.Map;

public class java_10674_CredentialValidator_A07 {

    // Create a HashMap to store user credentials
    private Map<String, String> userCredentials = new HashMap<>();

    public java_10674_CredentialValidator_A07() {
        // Add some users to the map
        userCredentials.put("user1", "password1");
        userCredentials.put("user2", "password2");
    }

    public boolean validate(String user, String password) {
        // Check if the entered password matches the password in the map
        if (password.equals(userCredentials.get(user))) {
            return true;
        } else {
            return false;
        }
    }
}