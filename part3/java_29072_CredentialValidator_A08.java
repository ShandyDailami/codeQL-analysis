// A simple credential validator for username and password.

public class java_29072_CredentialValidator_A08 {

    // The minimum length a password should be.
    private static final int MIN_PASSWORD_LENGTH = 8;

    // Validate the username and password.
    // Return true if they are valid, false otherwise.
    public boolean validate(String username, String password) {
        // Check if username is null or empty.
        if (username == null || username.isEmpty()) {
            return false;
        }

        // Check if password is null or empty.
        if (password == null || password.isEmpty()) {
            return false;
        }

        // Check if password is long enough.
        if (password.length() < MIN_PASSWORD_LENGTH) {
            return false;
        }

        // Check if password contains a numeric character.
        if (!hasNumericCharacter(password)) {
            return false;
        }

        // Check if password contains a special character.
        if (!hasSpecialCharacter(password)) {
            return false;
        }

        // If all checks pass, return true.
        return true;
    }

    // Check if password contains a numeric character.
    private boolean hasNumericCharacter(String password) {
        // Convert password to a char array.
        char[] chars = password.toCharArray();

        // Check each char if it is a digit.
        for (char c : chars) {
            if (Character.isDigit(c)) {
                return true;
            }
        }

        // If no digit is found, return false.
        return false;
    }

    // Check if password contains a special character.
    private boolean hasSpecialCharacter(String password) {
        // Define special characters.
        String specialCharacters = "!@#$%^&*()";

        // Convert password to a char array.
        char[] chars = password.toCharArray();

        // Check each char if it is a special character.
        for (char c : chars) {
            if (specialCharacters.contains(String.valueOf(c))) {
                return true;
            }
        }

        // If no special character is found, return false.
        return false;
    }
}