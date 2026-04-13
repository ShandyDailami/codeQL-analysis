public class java_35395_CredentialValidator_A08 implements CredentialValidator {

    // The minimum required strength of a password
    private static final int STRONG_PASSWORD_STRENGTH = 3;

    @Override
    public String validate(Credential credential) {
        String password = credential.getPassword();
        if (isPasswordStrong(password)) {
            return "Password is strong";
        } else {
            return "Password is weak";
        }
    }

    private boolean isPasswordStrong(String password) {
        // Check if password is null
        if (password == null) {
            return false;
        }

        // Check if password is at least 8 characters long
        if (password.length() < STRONG_PASSWORD_STRENGTH) {
            return false;
        }

        // Check if password contains at least one uppercase letter, one lowercase letter, one digit, and one special character
        boolean hasUpperCase = hasUpperCase(password);
        boolean hasLowerCase = hasLowerCase(password);
        boolean hasDigit = hasDigit(password);
        boolean hasSpecialChar = hasSpecialChar(password);

        // If all conditions are met, password is strong
        return (hasUpperCase && hasLowerCase && hasDigit && hasSpecialChar);
    }

    private boolean hasUpperCase(String password) {
        return password.matches(".*[A-Z].*");
    }

    private boolean hasLowerCase(String password) {
        return password.matches(".*[a-z].*");
    }

    private boolean hasDigit(String password) {
        return password.matches(".*[0-9].*");
    }

    private boolean hasSpecialChar(String password) {
        return password.matches(".*[!@#$%^&*(),.?\\':{}|<>].*");
    }
}