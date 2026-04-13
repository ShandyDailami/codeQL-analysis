public class java_22035_CredentialValidator_A08 {

    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()";

    // Method to check if the password is strong enough
    public boolean isStrongEnough(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }

        if (password.length() < 8) {
            return false;
        }

        if (!hasUpperCase(password)) {
            return false;
        }

        if (!hasLowerCase(password)) {
            return false;
        }

        if (!hasDigit(password)) {
            return false;
        }

        if (!hasSpecialCharacter(password)) {
            return false;
        }

        return true;
    }

    // Method to check if the password contains an uppercase letter
    private boolean hasUpperCase(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }

    // Method to check if the password contains a lowercase letter
    private boolean hasLowerCase(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) {
                return true;
            }
        }
        return false;
    }

    // Method to check if the password contains a digit
    private boolean hasDigit(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    // Method to check if the password contains a special character
    private boolean hasSpecialCharacter(String password) {
        for (char c : password.toCharArray()) {
            if (SPECIAL_CHARACTERS.indexOf(c) != -1) {
                return true;
            }
        }
        return false;
    }
}