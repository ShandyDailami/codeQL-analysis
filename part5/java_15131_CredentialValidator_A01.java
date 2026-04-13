public class java_15131_CredentialValidator_A01 {
    private static final String STRONG_PASSWORD = "StrongPassword";

    public boolean isPasswordStrong(String password) {
        // Check if password is not null
        if (password == null) {
            return false;
        }

        // Check if password is not empty
        if (password.isEmpty()) {
            return false;
        }

        // Check if password is strong enough
        if (password.equals(STRONG_PASSWORD)) {
            return false;
        }

        // Check if password contains a certain set of characters
        if (password.matches(".*[0-9].*")) {
            return false;
        }

        if (password.matches(".*[!@#$%^&*(),.?" + "_`~{}|\\\\;:'\\\"?].*")) {
            return false;
        }

        return true;
    }
}