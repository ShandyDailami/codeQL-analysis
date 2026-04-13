public class java_31705_CredentialValidator_A01 {

    public boolean validateCredentials(String username, String password) {
        // Check if the password is null
        if (password == null) {
            return false;
        }

        // Check if the password is too short
        if (password.length() < 8) {
            return false;
        }

        // Check if the password contains at least one digit
        if (!password.matches(".*\\d.*")) {
            return false;
        }

        // Check if the password contains at least one uppercase letter
        if (!password.matches(".*[A-Z].*")) {
            return false;
        }

        // Check if the password contains at least one lowercase letter
        if (!password.matches(".*[a-z].*")) {
            return false;
        }

        // If all checks are passed, return true
        return true;
    }
}