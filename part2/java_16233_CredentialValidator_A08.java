import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_16233_CredentialValidator_A08 {
    // A strong password must contain at least one lowercase letter, one uppercase letter,
    // one digit, and one special character. It must also be at least 8 characters long.
    public boolean isStrongPassword(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }

        boolean hasLowerCase = false, hasUpperCase = false, hasDigit = false, hasSpecialChar = false;

        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else {
                hasSpecialChar = true;
            }

            if (hasLowerCase && hasUpperCase && hasDigit && hasSpecialChar) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        StrongPasswordValidator validator = new StrongPasswordValidator();
        String password = "StrongPassword1";
        if (validator.isStrongPassword(password)) {
            System.out.println("Password is strong.");
        } else {
            System.out.println("Password is not strong.");
        }
    }
}