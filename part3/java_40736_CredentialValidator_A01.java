public class java_40736_CredentialValidator_A01 {
    // Constants for password length and presence of numbers
    private static final int MIN_PASSWORD_LENGTH = 8;
    private static final int MAX_PASSWORD_LENGTH = 16;

    // Method to validate password
    public boolean isPasswordValid(String password) {
        if (password == null || password.isEmpty()) {
            return false;
        }

        if (password.length() < MIN_PASSWORD_LENGTH || password.length() > MAX_PASSWORD_LENGTH) {
            return false;
        }

        if (!password.matches(".*[0-9].*")) {
            return false;
        }

        if (!password.matches(".*[a-z].*")) {
            return false;
        }

        if (!password.matches(".*[A-Z].*")) {
            return false;
        }

        if (!password.matches(".*[^a-zA-Z0-9].*")) {
            return false;
        }

        return true;
    }
}