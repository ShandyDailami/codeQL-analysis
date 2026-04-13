import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_29060_CredentialValidator_A03 {

    private Map<String, String> users = new HashMap<>();

    public java_29060_CredentialValidator_A03() {
        users.put("admin", Base64.getEncoder().encodeToString("password".getBytes())); // This is a placeholder password. Please replace it with a secure one.
    }

    public boolean validateCredentials(String username, String password) {
        String encodedPassword = users.get(username);
        if (encodedPassword != null) {
            byte[] decodedBytes = Base64.getDecoder().decode(encodedPassword);
            String decodedPassword = new String(decodedBytes);
            return decodedPassword.equals(password);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Test with valid credentials
        boolean isValid = validator.validateCredentials("admin", "password");
        System.out.println("Is valid: " + isValid); // Outputs: Is valid: true

        // Test with invalid credentials
        isValid = validator.validateCredentials("admin", "wrongpassword");
        System.out.println("Is valid: " + isValid); // Outputs: Is valid: false
    }
}