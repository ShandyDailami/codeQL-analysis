public class java_16939_CredentialValidator_A01 {

    // A method to check if the password is valid
    public boolean isValidPassword(String password) {
        // The password must be 8 characters long
        if (password.length() != 8) {
            return false;
        }

        // The password must contain at least one uppercase letter
        if (!password.matches(".*[A-Z].*")) {
            return false;
        }

        // The password must contain at least one lowercase letter
        if (!password.matches(".*[a-z].*")) {
            return false;
        }

        // The password must contain at least one special character
        if (!password.matches(".*[@$%^&*()_+\\-={}|\\\\;:,<.>?\\[\\]\\\\`~].*")) {
            return false;
        }

        // The password must contain at least one digit
        if (!password.matches(".*[0-9].*")) {
            return false;
        }

        return true;
    }
}