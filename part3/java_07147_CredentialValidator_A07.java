import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_07147_CredentialValidator_A07 {
    // Map to hold user credentials
    private Map<String, String> userCredentials;

    public java_07147_CredentialValidator_A07() {
        userCredentials = new HashMap<>();
        userCredentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        userCredentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    public boolean validateCredentials(String user, String password) {
        // Check if the user is in the map
        if (!userCredentials.containsKey(user)) {
            return false;
        }

        // Compare the encoded passwords
        String encodedPassword = userCredentials.get(user);
        String encodedProvidedPassword = Base64.getEncoder().encodeToString(password.getBytes());

        return encodedPassword.equals(encodedProvidedPassword);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // User 1
        if (validator.validateCredentials("user1", "password1")) {
            System.out.println("User 1 authenticated successfully");
        } else {
            System.out.println("Invalid credentials for user 1");
        }

        // User 2
        if (validator.validateCredentials("user2", "password2")) {
            System.out.println("User 2 authenticated successfully");
        } else {
            System.out.println("Invalid credentials for user 2");
        }
    }
}