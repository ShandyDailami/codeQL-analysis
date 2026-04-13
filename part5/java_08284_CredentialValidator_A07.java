public class java_08284_CredentialValidator_A07 {

    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()";
    private static final String NUMBERS = "0123456789";

    // Method to check if the password is strong enough
    public boolean isPasswordStrongEnough(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }
        
        // Check if password contains at least one upper-case letter, one lower-case letter,
        // one number and one special character
        if (!(password.matches(".*[A-Z].*"))
                || !(password.matches(".*[a-z].*"))
                || !(password.matches(".*[" + NUMBERS + "].*"))
                || !(password.matches(".*[" + SPECIAL_CHARACTERS + "].*"))) {
            return false;
        }

        // Check if password is at least 8 characters long
        if (password.length() < 8) {
            return false;
        }

        return true;
    }
}