public class java_07802_CredentialValidator_A01 {
    public boolean isValidPassword(String password) {
        // Define a list of common passwords
        List<String> commonPasswords = Arrays.asList("password", "admin", "qwerty");

        // Check if the password is null or empty
        if (password == null || password.isEmpty()) {
            return false;
        }

        // Check if the password is in the list of common passwords
        if (commonPasswords.contains(password)) {
            return false;
        }

        // Check if the password is long enough
        if (password.length() < 8) {
            return false;
        }

        // Check if the password contains at least one uppercase letter, one lowercase letter, one digit and one special character
        if (!password.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$")) {
            return false;
        }

        // If all checks passed, the password is valid
        return true;
    }
}