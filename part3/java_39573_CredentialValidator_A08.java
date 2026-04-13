public class java_39573_CredentialValidator_A08 implements CredentialValidator {

    // Define the possible special characters
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()";

    @Override
    public boolean validate(UsernamePasswordCredentials creds) {
        String password = creds.getPassword();

        // Check if password is null or less than 8 characters
        if (password == null || password.length() < 8) {
            return false;
        }

        // Check if password contains at least one uppercase letter, one lowercase letter, one number, one special character
        if (!hasUpperCase(password) || !hasLowerCase(password) || !hasDigit(password) || !hasSpecialCharacter(password)) {
            return false;
        }

        // If all checks passed, password is valid
        return true;
    }

    // Helper methods to check for each character type
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
            if (SPECIAL_CHARACTERS.indexOf(c) != -1) {
                return true;
            }
        }
        return false;
    }
}