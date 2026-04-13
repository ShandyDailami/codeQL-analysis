import java.util.regex.Pattern;

public class java_29880_CredentialValidator_A01 {
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()";
    private static final String SCRAMBLE_PASSWORD = "^&*()";

    public boolean isPasswordStrong(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null.");
        }

        // Check for uppercase letter
        if (!hasUpperCase(password)) {
            return false;
        }

        // Check for lowercase letter
        if (!hasLowerCase(password)) {
            return false;
        }

        // Check for number
        if (!hasNumber(password)) {
            return false;
        }

        // Check for special character
        if (!hasSpecialCharacter(password)) {
            return false;
        }

        // Check for scramble password
        if (isScramble(password)) {
            return false;
        }

        return true;
    }

    private boolean hasUpperCase(String password) {
        return password.matches(".*[A-Z].*");
    }

    private boolean hasLowerCase(String password) {
        return password.matches(".*[a-z].*");
    }

    private boolean hasNumber(String password) {
        return password.matches(".*[0-9].*");
    }

    private boolean hasSpecialCharacter(String password) {
        return password.matches(".*[" + SPECIAL_CHARACTERS + "].*");
    }

    private boolean isScramble(String password) {
        return password.equals(reverse(password));
    }

    private String reverse(String s) {
        String reverse = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            reverse = reverse + s.charAt(i);
        }
        return reverse;
    }
}