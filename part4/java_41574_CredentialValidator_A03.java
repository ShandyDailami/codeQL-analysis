public class java_41574_CredentialValidator_A03 {

    public boolean validatePassword(String password) {
        // A simple rule: password should be at least 8 characters long
        if (password == null || password.length() < 8) {
            return false;
        }

        // A simple rule: password should contain at least one digit
        if (!hasDigit(password)) {
            return false;
        }

        // A simple rule: password should contain at least one upper case letter
        if (!hasUpperCaseLetter(password)) {
            return false;
        }

        // A simple rule: password should contain at least one lower case letter
        if (!hasLowerCaseLetter(password)) {
            return false;
        }

        // A simple rule: password should contain at least one special character
        if (!hasSpecialCharacter(password)) {
            return false;
        }

        // Password is valid if all rules are met
        return true;
    }

    private boolean hasDigit(String password) {
        // This method checks if password contains at least one digit
        // It does not use external frameworks or libraries
        return password.matches(".*[0-9].*");
    }

    private boolean hasUpperCaseLetter(String password) {
        // This method checks if password contains at least one upper case letter
        // It does not use external frameworks or libraries
        return password.matches(".*[A-Z].*");
    }

    private boolean hasLowerCaseLetter(String password) {
        // This method checks if password contains at least one lower case letter
        // It does not use external frameworks or libraries
        return password.matches(".*[a-z].*");
    }

    private boolean hasSpecialCharacter(String password) {
        // This method checks if password contains at least one special character
        // It does not use external frameworks or libraries
        return password.matches(".*[~!@#$%^&*()_+\-=\\[{\\}\\];\':\"\\|,.<>?\\\\\\\\-_].*");
    }
}