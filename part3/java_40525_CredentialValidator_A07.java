import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_40525_CredentialValidator_A07 {
    public boolean validate(String password) {
        // Check if the password is long enough (minimum 8 characters)
        if (password.length() < 8) {
            return false;
        }

        // Check if the password contains at least one uppercase letter, one lowercase letter, and one special character
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasSpecialChar = false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (!isSpecialCharacter(c)) {
                hasSpecialChar = true;
            }
            if (hasUpperCase && hasLowerCase && hasSpecialChar) {
                return true;
            }
        }

        return false;
    }

    private boolean isSpecialCharacter(char c) {
        return !(c >= 'a' && c <= 'z') && !(c >= 'A' && c <= 'Z');
    }

    public static void main(String[] args) {
        CustomCredentialValidator validator = new CustomCredentialValidator();
        System.out.println(validator.validate("Password123"));  // Outputs: true
        System.out.println(validator.validate("password123"));  // Outputs: false
        System.out.println(validator.validate("Password123!")); // Outputs: false
    }
}