public class java_18860_CredentialValidator_A03 {

    private static final String SPECIAL_CHARS = "!@#$%^&*()";
    private static final String NUMBERS = "0123456789";

    public boolean isValidPassword(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }

        // Check for minimum length
        if (password.length() < 8) {
            return false;
        }

        // Check for numbers
        if (!contains(password, NUMBERS)) {
            return false;
        }

        // Check for special characters
        if (!contains(password, SPECIAL_CHARS)) {
            return false;
        }

        // If all checks pass, password is valid
        return true;
    }

    private boolean contains(String str, String searchStr) {
        return str.contains(searchStr);
    }
}