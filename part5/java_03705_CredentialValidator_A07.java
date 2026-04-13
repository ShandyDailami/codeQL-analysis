public class java_03705_CredentialValidator_A07 {

    public boolean isValid(String userName, String password) {
        // Assuming a very simple way to check for valid credentials
        // This is a simplistic way and it will not handle all security-related issues
        // It's always recommended to use a well-established library for security-related operations

        if (userName == null || password == null) {
            return false;
        }

        // Checking if userName is not empty and password is not less than 6 characters
        if (userName.isEmpty() || password.length() < 6) {
            return false;
        }

        // Checking if password contains at least one digit and one uppercase letter
        if (!password.matches(".*[0-9].*") || !password.matches(".*[A-Z].*")) {
            return false;
        }

        // If all checks pass, return true
        return true;
    }
}