import java.security.GeneralSecurityException;

public class java_05860_CredentialValidator_A08 {

    public static boolean validatePassword(String password) {
        // check password is not null
        if (password == null) {
            return false;
        }

        // check password length
        if (password.length() < 8) {
            return false;
        }

        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (!"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".indexOf(c) != -1) {
                hasSpecialChar = true;
            }
            if (hasUpperCase && hasLowerCase && hasDigit && hasSpecialChar) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        // Test the password validator
        System.out.println(validatePassword("Aa123456!")); // Should print true
        System.out.println(validatePassword("abc123456!")); // Should print false
        System.out.println(validatePassword("abc!123456!")); // Should print false
    }
}