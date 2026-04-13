import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_41672_CredentialValidator_A01 {
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        Map<String, String> userCredentials = new HashMap<>();
        userCredentials.put("user1", "password1");
        userCredentials.put("user2", "password2");

        boolean isValid = validator.validate(userCredentials);
        System.out.println("Is valid: " + isValid);
    }
}

class CredentialValidator {
    public boolean validate(Map<String, String> userCredentials) {
        // Simulating access control checks
        // We're assuming the input contains a base64 encoded username and password
        String decodedCredentials = new String(Base64.getDecoder().decode(userCredentials.get("user")), "UTF-8");
        String[] credentials = decodedCredentials.split(":");
        String username = credentials[0];
        String password = credentials[1];

        // We're simulating a password check using a simple string comparison
        String dbPassword = "$2a$10$.t4BwM8FvRxFzqj98sYzQ...qz22.PzxZC/Qv3vq8Z793.dP2s"; // This is a hashed password from a database

        return password.equals(dbPassword);
    }
}