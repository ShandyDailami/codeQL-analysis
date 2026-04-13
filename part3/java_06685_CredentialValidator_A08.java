public class java_06685_CredentialValidator_A08 implements CredentialValidator {

    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()";

    @Override
    public boolean validate(UsernamePasswordCredentials credentials) throws AuthenticationException {
        String password = credentials.getPassword();

        // Check if password is null or empty
        if (password == null || password.isEmpty()) {
            return false;
        }

        // Check if password is too short (<8 characters)
        if (password.length() < 8) {
            return false;
        }

        // Check if password contains at least one digit
        if (!hasDigit(password)) {
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

        // Check if password contains at least one special character
        if (!hasSpecialCharacter(password)) {
            return false;
        }

        // Password is valid
        return true;
    }

    private boolean hasDigit(String password) {
        return password.matches(".*[0-9].*");
    }

    private boolean hasUpperCase(String password) {
        return password.matches(".*[A-Z].*");
    }

    private boolean hasLowerCase(String password) {
        return password.matches(".*[a-z].*");
    }

    private boolean hasSpecialCharacter(String password) {
        return password.matches(".*[" + SPECIAL_CHARACTERS + "].*");
    }
}