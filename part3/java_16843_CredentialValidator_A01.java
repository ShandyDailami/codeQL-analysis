public class java_16843_CredentialValidator_A01 {

    public boolean isValidPassword(String password) {
        if (password == null || password.length() == 0) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }

        // Check for common patterns such as "password", "admin", "123456", etc.
        if (isCommonPassword(password)) {
            throw new IllegalArgumentException("Password is too common");
        }

        // Check if password has a long enough length
        if (password.length() < 8) {
            throw new IllegalArgumentException("Password length must be at least 8 characters");
        }

        // Check if password has uppercase, lowercase, number and special characters
        if (!hasUpperCase(password) || !hasLowerCase(password) || !hasDigit(password) || !hasSpecialChar(password)) {
            throw new IllegalArgumentException("Password must contain at least one uppercase letter, one lowercase letter, one digit, and one special character");
        }

        return true;
    }

    private boolean isCommonPassword(String password) {
        // Implement your own common password list here
        // For the sake of this example, we'll just check if the password is a common one
        return commonPasswords.contains(password);
    }

    private boolean hasUpperCase(String password) {
        // Implement your own logic to check for uppercase characters here
        return false;
    }

    private boolean hasLowerCase(String password) {
        // Implement your own logic to check for lowercase characters here
        return false;
    }

    private boolean hasDigit(String password) {
        // Implement your own logic to check for digits here
        return false;
    }

    private boolean hasSpecialChar(String password) {
        // Implement your own logic to check for special characters here
        return false;
    }

    // Define your common password list here
    private List<String> commonPasswords = new ArrayList<>();
}