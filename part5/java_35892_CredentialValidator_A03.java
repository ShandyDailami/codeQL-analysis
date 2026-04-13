import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class java_35892_CredentialValidator_A03 {

    private java_35892_CredentialValidator_A03() {
    }

    public static ValidationResult validate(Credential credential) {
        // Validate password length
        if (credential.getPassword() == null || credential.getPassword().length() < 8) {
            return new ValidationResult("Password should be at least 8 characters long", false);
        }

        // Validate username
        if (credential.getUsername() == null || credential.getUsername().length() < 3) {
            return new ValidationResult("Username should be at least 3 characters long", false);
        }

        // If no errors found, return success
        return new ValidationResult("Success", true);
    }

    public static class Credential {
        private String username;
        private String password;

        public java_35892_CredentialValidator_A03(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }
    }

    public static class ValidationResult {
        private String message;
        private boolean isValid;

        public java_35892_CredentialValidator_A03(String message, boolean isValid) {
            this.message = message;
            this.isValid = isValid;
        }

        public String getMessage() {
            return message;
        }

        public boolean isValid() {
            return isValid;
        }
    }
}