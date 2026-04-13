import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_38500_CredentialValidator_A03 {

    private Map<String, String> userCredentials = new HashMap<>();

    public java_38500_CredentialValidator_A03() {
        userCredentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        userCredentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    public boolean validateCredentials(String username, String password) {
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        return userCredentials.get(username).equals(encodedPassword);
    }

    // Using a static inner class to encapsulate the CredentialValidator logic
    public static class CredentialValidator {

        private SecureCredentialValidator credentialValidator;

        public java_38500_CredentialValidator_A03() {
            this.credentialValidator = new SecureCredentialValidator();
        }

        public boolean validateCredentials(String username, String password) {
            // Remove the comment and replace with real logic
            // For example, return credentialValidator.validateCredentials(username, password);
            return true;
        }
    }
}