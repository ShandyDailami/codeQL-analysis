import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_38386_CredentialValidator_A07 {

    private static final String AUTHENTICATION_FAILURE = "A07_AuthFailure";
    private Map<String, String> userCredentials;

    public java_38386_CredentialValidator_A07() {
        userCredentials = new HashMap<>();
        // Add some dummy user credentials for demonstration
        userCredentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        userCredentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    public boolean validateCredentials(String user, String password) {
        if (userCredentials.containsKey(user) && userCredentials.get(user).equals(password)) {
            return true;
        } else {
            // Simulate an authentication failure
            throw new AuthenticationFailureException(AUTHENTICATION_FAILURE);
        }
    }

    private static class AuthenticationFailureException extends RuntimeException {
        public java_38386_CredentialValidator_A07(String message) {
            super(message);
        }
    }

    public static void main(String[] args) {
        VanillaJavaCredentialValidator validator = new VanillaJavaCredentialValidator();

        try {
            validator.validateCredentials("user1", "password1"); // should be accepted
            validator.validateCredentials("user1", "wrongpassword"); // should fail
        } catch (AuthenticationFailureException e) {
            System.out.println("Authentication failed. Error: " + e.getMessage());
        }
    }
}