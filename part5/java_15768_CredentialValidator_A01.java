public class java_15768_CredentialValidator_A01 {

    // List of forbidden passwords
    private static final List<String> FORBIDDEN_PASSWORDS = Arrays.asList("password", "admin", "qwerty");

    // Method to check if a password is strong enough
    public boolean isPasswordStrongEnough(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }

        if (password.length() < 8) {
            return false;
        }

        if (!hasUpperCase(password) || !hasLowerCase(password) || !hasNumber(password) || !hasSpecialChar(password)) {
            return false;
        }

        if (FORBIDDEN_PASSWORDS.contains(password)) {
            return false;
        }

        return true;
    }

    // Helper method to check if a string contains uppercase letters
    private boolean hasUpperCase(String password) {
        return password.matches(".*[A-Z].*");
    }

    // Helper method to check if a string contains lowercase letters
    private boolean hasLowerCase(String password) {
        return password.matches(".*[a-z].*");
    }

    // Helper method to check if a string contains numbers
    private boolean hasNumber(String password) {
        return password.matches(".*[0-9].*");
    }

    // Helper method to check if a string contains special characters
    private boolean hasSpecialChar(String password) {
        return password.matches(".*[!@#$%^&*(),.?\":{}|<>].*");
    }
}