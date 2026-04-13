public class java_14056_CredentialValidator_A03 {

    public boolean validate(String password) {
        // Check if password is null or empty
        if (password == null || password.isEmpty()) {
            return false;
        }
        
        // Check if password has at least one digit, one uppercase letter, one lowercase letter, and one special character
        if (!(password.matches(".*[0-9].*")) || !(password.matches(".*[A-Z].*")) || !(password.matches(".*[a-z].*")) || !(password.matches(".*[^A-Za-z0-9].*"))) {
            return false;
        }

        // Check if password is at least 8 characters long
        if (password.length() < 8) {
            return false;
        }

        return true;
    }
}