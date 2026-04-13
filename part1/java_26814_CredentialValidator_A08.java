public class java_26814_CredentialValidator_A08 {

    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()";

    public boolean validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }

        // Check for length
        if (password.length() < 8) {
            return false;
        }

        // Check for uppercase letters
        if (!hasUpperCase(password)) {
            return false;
        }

        // Check for lowercase letters
        if (!hasLowerCase(password)) {
            return false;
        }

        // Check for numbers
        if (!hasDigit(password)) {
            return false;
        }

        // Check for special characters
        if (!hasSpecialCharacter(password)) {
            return false;
        }

        // If password passes all checks
        return true;
    }

    private boolean hasUpperCase(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasLowerCase(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasDigit(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasSpecialCharacter(String password) {
        for (char c : password.toCharArray()) {
            if (SPECIAL_CHARACTERS.contains(String.valueOf(c))) {
                return true;
            }
        }
        return false;
    }
}