import java.security.GeneralSecurityException;
import java.security.Credential;

public class java_21475_CredentialValidator_A01 {

    public static boolean isValid(Credential credential) {
        String password = credential.getPassword();
        if (password == null || password.length() == 0) {
            return false;
        }

        // Assume that we have a method to check the password strength
        // This is a simplification and should be replaced with actual code
        boolean isStrongPassword = checkPasswordStrength(password);
        return isStrongPassword;
    }

    private static boolean checkPasswordStrength(String password) {
        // Check for common passwords (e.g., "password", "123456", etc.)
        if (password.matches(".*password.*") || password.matches(".*123456.*")) {
            return false;
        }

        // Check for common patterns (e.g., "123456", "abcdef", etc.)
        if (password.matches(".*[a-zA-Z0-9]{6,}") || password.matches(".*[0-9]{3,}")) {
            return false;
        }

        // All checks passed
        return true;
    }

    public static void main(String[] args) {
        // Test the CredentialValidator
        Credential credential = new Credential() {
            @Override
            public String getPassword() {
                return "password";
            }
        };
        if (CredentialValidator.isValid(credential)) {
            System.out.println("Password is valid.");
        } else {
            System.out.println("Password is not valid.");
        }
    }
}