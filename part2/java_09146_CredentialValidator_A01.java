public class java_09146_CredentialValidator_A01 {

    // Method to validate the password
    public boolean validatePassword(String password) {
        if (password == null) {
            return false;
        }

        // Check length
        if (password.length() < 8) {
            return false;
        }

        // Check for digits
        if (!password.matches(".*\\d.*")) {
            return false;
        }

        // Check for uppercase
        if (!password.matches(".*[A-Z]*")) {
            return false;
        }

        // Check for special character
        if (!password.matches(".*[!@#$%^&*()_+\\-=\\{\\}\\|:;\"'<,>.?\\/\\\\\\[\\]]*")) {
            return false;
        }

        return true;
    }
}