public class java_18921_CredentialValidator_A08 {

    public boolean validatePassword(String password) {
        // Check if password is null or empty
        if (password == null || password.isEmpty()) {
            return false;
        }

        // Check if password is at least 8 characters long
        if (password.length() < 8) {
            return false;
        }

        // Check if password contains at least one uppercase letter
        if (!hasUpperCase(password)) {
            return false;
        }

        // Check if password contains at least one lowercase letter
        if (!hasLowerCase(password)) {
            return false;
        }

        // Check if password contains at least one digit
        if (!hasDigit(password)) {
            return false;
        }

        // If all checks passed, the password is strong
        return true;
    }

    private boolean hasUpperCase(String password) {
        // Iterate through each character in the password
        for (int i = 0; i < password.length(); i++) {
            // If a character is an uppercase letter, return true
            if (Character.isUpperCase(password.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private boolean hasLowerCase(String password) {
        // Iterate through each character in the password
        for (int i = 0; i < password.length(); i++) {
            // If a character is a lowercase letter, return true
            if (Character.isLowerCase(password.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private boolean hasDigit(String password) {
        // Iterate through each character in the password
        for (int i = 0; i < password.length(); i++) {
            // If a character is a digit, return true
            if (Character.getNumericValue(password.charAt(i)) >= 0) {
                return true;
            }
        }
        return false;
    }
}