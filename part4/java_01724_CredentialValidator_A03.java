public class java_01724_CredentialValidator_A03 implements CredentialValidator {
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()";
    private static final String SPECIAL_CHARACTER_REGEX = "[%s]";

    // Method to check if a password is strong enough
    private boolean isPasswordStrongEnough(String password) {
        if (password == null) {
            return false;
        }

        if (password.length() < 8) {
            return false;
        }

        if (!hasDigit(password)) {
            return false;
        }

        if (!hasUpperCase(password)) {
            return false;
        }

        if (!hasLowerCase(password)) {
            return false;
        }

        if (!hasSpecialCharacter(password)) {
            return false;
        }

        return true;
    }

    // Method to check if password contains a digit
    private boolean hasDigit(String password) {
        return password.matches(".*[0-9].*");
    }

    // Method to check if password contains an uppercase letter
    private boolean hasUpperCase(String password) {
        return password.matches(".*[A-Z].*");
    }

    // Method to check if password contains a lowercase letter
    private boolean hasLowerCase(String password) {
        return password.matches(".*[a-z].*");
    }

    // Method to check if password contains a special character
    private boolean hasSpecialCharacter(String password) {
        return password.matches(String.format(SPECIAL_CHARACTER_REGEX, SPECIAL_CHARACTERS));
    }

    @Override
    public boolean validate(UsernamePasswordCredential credential) {
        return isPasswordStrongEnough(credential.getPasswordAsString());
    }
}