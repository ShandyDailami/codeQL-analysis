public class java_05462_CredentialValidator_A08 {

    public boolean validatePassword(String password) {
        // Check if password is null
        if (password == null) {
            return false;
        }

        // Check if password is too short
        if (password.length() < 8) {
            return false;
        }

        // Check if password contains only alphanumeric characters
        if (!password.matches("^[a-zA-Z0-9]*$")) {
            return false;
        }

        // Check if password contains at least one digit
        if (!password.contains("\\d")) {
            return false;
        }

        // Check if password contains at least one lowercase letter
        if (!password.contains("[a-z]")) {
            return false;
        }

        // Check if password contains at least one uppercase letter
        if (!password.contains("[A-Z]")) {
            return false;
        }

        // If all checks passed, the password is valid
        return true;
    }

}