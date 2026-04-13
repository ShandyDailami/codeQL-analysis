public class java_24288_CredentialValidator_A08 {

    public boolean isValid(String username, String password) {
        // Check if the username is null or empty
        if (username == null || username.isEmpty()) {
            return false;
        }

        // Check if the password is null or empty
        if (password == null || password.isEmpty()) {
            return false;
        }

        // Assume a password is valid if it has at least one uppercase, one lowercase, one digit and one special character
        boolean hasUpperCase = password.matches(".*[A-Z].*");
        boolean hasLowerCase = password.matches(".*[a-z].*");
        boolean hasDigit = password.matches(".*[0-9].*");
        boolean hasSpecialChar = password.matches(".*[!@#$%^&*()_+\-=\\\\{\\}|:;\"'<,>.?].*");

        if (hasUpperCase && hasLowerCase && hasDigit && hasSpecialChar) {
            return true;
        } else {
            return false;
        }
    }
}