import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_11303_CredentialValidator_A01 implements CredentialValidator {

    // Create a map to store user credentials
    private Map<String, String> userCredentials;

    public java_11303_CredentialValidator_A01() {
        this.userCredentials = new HashMap<>();

        // Add some dummy credentials for demonstration purposes
        this.userCredentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        this.userCredentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    @Override
    public boolean validate(String username, String password) {
        // Check if username and password combination is valid
        if (this.userCredentials.containsKey(username) && this.userCredentials.get(username).equals(password)) {
            System.out.println("Access granted to " + username);
            return true;
        } else {
            System.out.println("Access denied for " + username);
            return false;
        }
    }
}