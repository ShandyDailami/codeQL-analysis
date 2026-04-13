import java.util.HashMap;
import java.util.Map;

public class java_06745_CredentialValidator_A01 {

    private Map<String, String> userCredentials;

    public java_06745_CredentialValidator_A01() {
        userCredentials = new HashMap<>();
        // Add some dummy user credentials
        userCredentials.put("user1", "password1");
        userCredentials.put("user2", "password2");
    }

    public boolean validateCredentials(String user, String password) {
        // Check if the entered credentials match with the stored ones
        return userCredentials.get(user).equals(password);
    }

    public static void main(String[] args) {
        LegacyCredentialValidator validator = new LegacyCredentialValidator();

        // Attempt to login with incorrect credentials
        if (!validator.validateCredentials("user1", "wrongPassword")) {
            System.out.println("Incorrect password for user1");
        }

        // Attempt to login with correct credentials
        if (validator.validateCredentials("user2", "password2")) {
            System.out.println("Correct password for user2");
        }
    }
}