import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_03671_CredentialValidator_A01 {
    // Storing username and password in a map
    private Map<String, String> userCredentials;

    // Constructor to initialize the userCredentials map
    public java_03671_CredentialValidator_A01() {
        userCredentials = new HashMap<>();
        userCredentials.put("admin", Base64.getEncoder().encodeToString("password".getBytes()));
    }

    // Method to validate the user credentials
    public boolean validateCredentials(String username, String password) {
        // Decoding the password from Base64
        String decodedPassword = new String(Base64.getDecoder().decode(userCredentials.get(username)));

        // Checking if the provided password matches the decoded password
        return password.equals(decodedPassword);
    }

    public static void main(String[] args) {
        LegacyCredentialValidator validator = new LegacyCredentialValidator();

        // Username and password to test the validation
        String username = "admin";
        String password = "password";

        // Validate the credentials
        if (validator.validateCredentials(username, password)) {
            System.out.println("Access granted for user: " + username);
        } else {
            System.out.println("Access denied for user: " + username);
        }
    }
}